package huangy.io.aio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.CountDownLatch;

/**
 * @author huangy on 2020-05-04
 */
public class AsyncTimeClientHandler implements CompletionHandler<Void, AsyncTimeClientHandler>, Runnable {

    private AsynchronousSocketChannel client;

    private String host;

    private int port;

    private CountDownLatch latch;


    public AsyncTimeClientHandler(String host, int port) {
        this.host = host;
        this.port = port;

        try {
            client = AsynchronousSocketChannel.open();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        latch = new CountDownLatch(1);

        /*
         * 发起连接服务端的异步操作，下面解析下参数
         * A attachment :  AsynchronousSocketChannel的附件，用于回调的时候作为参数传递，调用者可以自定义
         * CompletionHandler<Void,? super A> handler ： 异步操作通知回调接口，由调用者实现
         */
        client.connect(new InetSocketAddress(host, port), this, this);

        try {
            // 防止异步操作还没有执行完，线程就退出了
            latch.await();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            client.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 异步连接成功以后，回调该方法
     */
    @Override
    public void completed(Void result, AsyncTimeClientHandler attachment) {

        byte[] req = "Client query time".getBytes(StandardCharsets.UTF_8);
        ByteBuffer writeBuffer = ByteBuffer.allocate(req.length);
        writeBuffer.put(req);
        writeBuffer.flip();

        // 连接成功以后，通过write发送请求给服务端，由于是异步，如果没有写完，则通过CompletionHandler继续写
        client.write(writeBuffer, writeBuffer, new CompletionHandler<Integer, ByteBuffer>() {
            @Override
            public void completed(Integer result, ByteBuffer buffer) {
                if (buffer.hasRemaining()) {
                    // 没有写完，继续写
                    client.write(buffer, buffer, this);

                } else {
                    // 没有剩余的字节，证明写成功了，就开始异步读取结果，读取成功则回调CompletionHandler
                    ByteBuffer readBuffer = ByteBuffer.allocate(1024);
                    client.read(readBuffer, readBuffer, new CompletionHandler<Integer, ByteBuffer>() {
                        @Override
                        public void completed(Integer result, ByteBuffer buffer) {
                            buffer.flip();
                            byte[] bytes = new byte[buffer.remaining()];
                            buffer.get(bytes);
                            String body = new String(bytes, StandardCharsets.UTF_8);
                            System.out.println("receive server time=" + body);

                            // 读取到消息之后，让当前客户端线程退出
                            latch.countDown();
                        }

                        @Override
                        public void failed(Throwable exc, ByteBuffer buffer) {
                            try {
                                client.close();
                                latch.countDown();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    });
                }
            }

            @Override
            public void failed(Throwable exc, ByteBuffer attachment) {
                try {
                    client.close();
                    latch.countDown();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    public void failed(Throwable exc, AsyncTimeClientHandler attachment) {
        exc.printStackTrace();
        try {
            client.close();
            latch.countDown();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
