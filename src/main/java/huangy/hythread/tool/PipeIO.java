package huangy.hythread.tool;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 线程间可以使用管道进行通讯 （示例）
 * @author huangy on 2019-05-04
 */


class Sender implements Runnable {

    private PipedWriter out = new PipedWriter();

    public PipedWriter getPipedWriter() {
        return out;
    }

    @Override
    public void run() {
        try {

            while (true) {
                for (char c = 'A'; c <= 'z'; c++) {
                    System.out.println("Sender write, c=" + c  + " time=" + System.currentTimeMillis());
                    out.write(c);

                    TimeUnit.SECONDS.sleep(1);
                }
            }

        } catch (IOException e) {
            System.out.println("send IOException, e=" + e);
        } catch (InterruptedException e) {
            System.out.println("send InterruptedException, e=" + e);
        }
    }
}

class Receiver implements Runnable {
    private PipedReader in;

    public Receiver(PipedWriter pipedWriter) throws IOException {
        in = new PipedReader(pipedWriter);
    }

    @Override
    public void run() {
        try {
            while (true) {
                System.out.println("Receiver, read, c=" + (char)in.read() + " time=" + System.currentTimeMillis());
            }
        } catch (IOException e) {
            System.out.println("receive IOException, e=" + e);
        }
    }
}

public class PipeIO {

    public static void main(String[] args) throws Exception {
        Sender sender = new Sender();
        Receiver receiver = new Receiver(sender.getPipedWriter());

        ExecutorService exec = Executors.newCachedThreadPool();

        exec.execute(sender);
        exec.execute(receiver);
    }

}
