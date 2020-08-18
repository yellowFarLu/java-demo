package huangy.io.aio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.concurrent.CountDownLatch;

/**
 * @author huangy on 2020-05-03
 */
public class AsyncTimeServerHandler implements Runnable {

    private int port;

    CountDownLatch latch;

    AsynchronousServerSocketChannel asynchronousServerSocketChannel;

    public AsyncTimeServerHandler(int port) {
        this.port = port;

        try {
            // 构建一个异步的服务端通道
            asynchronousServerSocketChannel = AsynchronousServerSocketChannel.open();
            // 服务端通道绑定监听端口
            asynchronousServerSocketChannel.bind(new InetSocketAddress(this.port));
            System.out.println("time server start in port=" + this.port);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {

        // CountDownLatch的作用是 在完成一组操作之前，当前线程一直阻塞
        // 在本例中，我们让线程在此阻塞，防止服务端执行完成退出。
        // 在实际项目中，不需哟启动独立线程来处理AsynchronousServerSocketChannel，这里仅仅是demo演示
        latch = new CountDownLatch(1);

        doAccept();

        try {
            latch.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 接收客户端连接。由于是异步操作，我们可以传递一个CompletionHandler的handler实例接收accept操作成功的
     * 通知消息。
     */
    public void doAccept() {
        asynchronousServerSocketChannel.accept(this, new AcceptCompletionHandler());
    }
}

class AcceptCompletionHandler implements CompletionHandler<AsynchronousSocketChannel, AsyncTimeServerHandler> {

    @Override
    public void completed(AsynchronousSocketChannel result, AsyncTimeServerHandler attachment) {

        /*
         * 从attachment成员变量获取asynchronousServerSocketChannel，然后继续调用accept方法。
         * 读者可能会疑惑，既然已经接收客户端成功了，为什么还要再次调用accept方法呢？
         * 原因是这样的：服务器可以接收成千上万的连接，那么接收到一个连接以后，会回调CompletionHandler的completed方法，
         * 应该在这个方法里面继续调用asynchronousServerSocketChannel的accept方法，来接收其他客户端连接。
         * 最终形成一个循环，每当接收一个客户端连接成功以后，再异步接收新的客户端连接。
         */
        attachment.asynchronousServerSocketChannel.accept(attachment, this);

        // 连接建立后，服务端读取客户端的消息
        ByteBuffer buffer = ByteBuffer.allocate(1024);

        /*
         * read用于读取请求数据，下面解释下参数
         *
         * ByteBuffer dst：接收缓冲区，用于从异步Channel中读取数据包
         * A attachment：异步Channel携带的附件，通知回调的时候作为入参使用
         * CompletionHandler<Integer,? super A> handler ： 接收通知回调的业务handler
         */
        result.read(buffer, buffer, new ReadCompletionHandler(result));
    }

    @Override
    public void failed(Throwable exc, AsyncTimeServerHandler attachment) {
        exc.printStackTrace();
        attachment.latch.countDown();
    }
}

class ReadCompletionHandler implements CompletionHandler<Integer, ByteBuffer> {

    // 主要用于读取半包消息和应答
    private AsynchronousSocketChannel channel;

    public ReadCompletionHandler(AsynchronousSocketChannel channel) {
        this.channel = channel;
    }

    @Override
    public void completed(Integer result, ByteBuffer attachment) {
        attachment.flip();
        byte[] body = new byte[attachment.remaining()];
        attachment.get(body);

        String req = new String(body, StandardCharsets.UTF_8);
        System.out.println("this time server recevice order, req=" + req);

        // 异步写
        doWrite(new Date().toString());
    }

    private void doWrite(String currentTime) {
        if ((currentTime != null) && currentTime.length() > 0) {
            byte[] bytes = currentTime.getBytes(StandardCharsets.UTF_8);
            ByteBuffer writeBuffer = ByteBuffer.allocate(bytes.length);
            writeBuffer.put(bytes);
            writeBuffer.flip();

            channel.write(writeBuffer, writeBuffer, new CompletionHandler<Integer, ByteBuffer>() {
                @Override
                public void completed(Integer result, ByteBuffer attachment) {
                    // 如果没有发送完成，继续发送（处理半包问题）
                    if (attachment.hasRemaining()) {
                        channel.write(attachment, attachment, this);
                    }
                }

                @Override
                public void failed(Throwable exc, ByteBuffer attachment) {
                    try {
                        channel.close();
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
            channel.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}