package huangy.io.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.Set;

/**
 * @author huangy on 2020-05-03
 */
public class TimeClientHandle implements Runnable {

    private String host;

    private int port;

    private Selector selector;

    private SocketChannel socketChannel;

    private volatile boolean stop;

    public TimeClientHandle(String host, int port) {
        this.host = host;
        this.port = port;

        try {
            selector = Selector.open();

            socketChannel = SocketChannel.open();

            socketChannel.configureBlocking(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            doConnect();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }

        while (!stop) {
            try {

                selector.select();

                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                Iterator<SelectionKey> iterator = selectionKeys.iterator();

                while (iterator.hasNext()) {
                    SelectionKey selectionKey = iterator.next();
                    iterator.remove();

                    try {
                        handleInput(selectionKey);
                    } catch (Exception e) {
                        e.printStackTrace();
                        if (selectionKey != null) {
                            selectionKey.cancel();

                            if (selectionKey.channel() != null) {
                                selectionKey.channel().close();
                            }
                        }
                    }
                }


            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if (selector != null) {
            try {
                selector.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void handleInput(SelectionKey key) throws IOException {

        if (key.isValid()) {

            // 判断是否连接成功
            SocketChannel socketChannel = (SocketChannel)key.channel();
            if (key.isConnectable()) {
                if (socketChannel.finishConnect()) {
                    socketChannel.register(selector, SelectionKey.OP_READ);
                    doWrite(socketChannel);
                } else {
                    // 连接失败，进程退出
                    System.exit(1);
                }
            }

            if (key.isReadable()) {
                ByteBuffer readBuffer = ByteBuffer.allocate(1024);
                int readBytes= socketChannel.read(readBuffer);

                if (readBytes > 0) {
                    readBuffer.flip();
                    byte[] bytes = new byte[readBuffer.remaining()];
                    readBuffer.get(bytes);
                    String body = new String(bytes, StandardCharsets.UTF_8);
                    System.out.println("client get time=" + body);
                    this.stop = true;
                } else if (readBytes < 0) {
                    // 对端链路关闭
                    key.cancel();
                    socketChannel.close();
                } else {
                    // 读到0字节，忽略
                }
            }
        }
    }

    private void doConnect() throws IOException {
        // 尝试连接到服务器
        boolean connectResult = socketChannel.connect(new InetSocketAddress(host, port));


        if (connectResult) {
            // 如果连接成功，则注册到多路复用器上
            socketChannel.register(selector, SelectionKey.OP_READ);

            // 发送请求消息
            doWrite(socketChannel);

        } else {
            // 注册请求连接事件，继续连接
            socketChannel.register(selector, SelectionKey.OP_CONNECT);
        }
    }

    private void doWrite(SocketChannel socketChannel) throws IOException {
        byte[] bytes = "client query time".getBytes(StandardCharsets.UTF_8);
        ByteBuffer writeBuffer = ByteBuffer.allocate(bytes.length);
        writeBuffer.put(bytes);
        writeBuffer.flip();
        socketChannel.write(writeBuffer);
        if (!writeBuffer.hasRemaining()) {
            System.out.println("client query time success");
        }
    }
}
