package huangy.io.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

/**
 * @author huangy on 2020-05-03
 */
public class MultiplexerTimeServer implements Runnable {

    private Selector selector;

    private ServerSocketChannel serverSocketChannel;

    private volatile boolean stop;

    public MultiplexerTimeServer(int port) {
        try {

            // 初始化多路复用器
            selector = Selector.open();

            // 开启服务端通道
            serverSocketChannel = ServerSocketChannel.open();

            // 设置为非阻塞
            serverSocketChannel.configureBlocking(false);

            // 绑定监听端口（并且设置请求队列的长度为1024）
            serverSocketChannel.socket().bind(new InetSocketAddress(port), 1024);

            // 将serverSocketChannel注册到selector上，监听accept事件
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

            System.out.println("server has start in port="  + port);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        // 当没有停止服务器
        while (!stop) {
            try {

                // selector进行轮询
                selector.select();

                // 程序执行到这里，说明有事件就绪了，获取就绪事件对应的key
                Set<SelectionKey> selectionKeys = selector.selectedKeys();

                Iterator<SelectionKey> iterator = selectionKeys.iterator();

                // 处理就绪的IO事件
                while (iterator.hasNext()) {

                    SelectionKey key =  iterator.next();

                    // 要把该事件从集合中删除，避免重复处理
                    iterator.remove();

                    try {
                        handleInput(key);
                    } catch (Exception e) {
                        e.printStackTrace();

                        if (key != null) {
                            /*
                             * 将这个key关联的通道和选择器取消注册，并且不会再监听这个key的事件
                             */
                            key.cancel();

                            if (key.channel() != null) {
                                key.channel().close();
                            }
                        }
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        // 多路复用器关闭后，所有关联的资源都会被关闭
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
            // 处理新接入的请求消息
            if (key.isAcceptable()) {
                ServerSocketChannel ssc = (ServerSocketChannel)key.channel();
                // ssc.accept() 相当于完成了TCP三次握手
                SocketChannel sc = ssc.accept();

                // 新创建的SocketChannel要设置为非阻塞
                sc.configureBlocking(false);

                // 新的连接加到多路复用器上面
                sc.register(selector, SelectionKey.OP_READ);
            }

            if (key.isReadable()) {
                SocketChannel sc = (SocketChannel)key.channel();
                ByteBuffer readBuffer = ByteBuffer.allocate(1024);
                int readBytes = sc.read(readBuffer);

                if (readBytes > 0) {
                    // 回环以重新读取数据
                    readBuffer.flip();
                    // remaining()返回剩余可以读取的字节数
                    byte[] bytes = new byte[readBuffer.remaining()];
                    // 把数据读取到bytes字节数组
                    readBuffer.get(bytes);
                    String body = new String(bytes, StandardCharsets.UTF_8);
                    System.out.println("This time server receive order : " + body);

                    // 回写数据
                    doWrite(sc, new Date().toString());
                }
            }
        }
    }

    private void doWrite(SocketChannel socketChannel, String response) throws IOException {
        if (response != null && response.trim().length() > 0) {
            byte[] bytes = response.getBytes(StandardCharsets.UTF_8);
            ByteBuffer writeBuffer = ByteBuffer.allocate(bytes.length);
            writeBuffer.put(bytes);
            writeBuffer.flip();

            /*
             * socketChannel是异步非阻塞的，它并不保证一次能把需要发送的字节数组发送完，
             * 此时会出现"写半包"问题。我们需要注册写操作，不断轮询selector将没有发送完的ByteBuffer发送完毕。
             * 此处没有处理"写半包"问题。
             */
            socketChannel.write(writeBuffer);
        }
    }

    public void stop() {
        this.stop = true;
    }
}
