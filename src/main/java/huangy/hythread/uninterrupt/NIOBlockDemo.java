package huangy.hythread.uninterrupt;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousCloseException;
import java.nio.channels.ClosedByInterruptException;
import java.nio.channels.SocketChannel;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author huangy on 2019-05-03
 */

class NIOBlocked implements Runnable {

    private final SocketChannel sc;

    public NIOBlocked(SocketChannel sc) {
        this.sc = sc;
    }

    @Override
    public void run() {
        try {
            sc.read(ByteBuffer.allocate(1));
        } catch (ClosedByInterruptException e) {
            System.out.println(e);
        } catch (AsynchronousCloseException e) {
            System.out.println(e);
        } catch (IOException e) {
            System.out.println(e);
        }

        System.out.println("exists NIOBlocked");
    }
}

public class NIOBlockDemo {

    public static void main(String[] args) throws Exception {
        ExecutorService exec = Executors.newCachedThreadPool();

        ServerSocket server = new ServerSocket(8080);

        InetSocketAddress isa = new InetSocketAddress("localhost", 8080);

        SocketChannel sc1 = SocketChannel.open(isa);

        SocketChannel sc2 = SocketChannel.open(isa);

        Future<?> future = exec.submit(new NIOBlocked(sc1));

        exec.submit(new NIOBlocked(sc2));

        exec.shutdown();

        // 中断InterruptibleChannel上的线程，抛出ClosedByInterruptException异常
        future.cancel(true);

        // 关闭通道的方式，抛出AsynchronousCloseException异常
        sc2.close();
    }


}
