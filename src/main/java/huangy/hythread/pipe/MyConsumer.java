package huangy.hythread.pipe;

import java.io.IOException;
import java.io.PipedInputStream;

/**
 * @author chenxihua
 * @Date 2018年9月17日
 *
 * 消费者每0.5秒从管道中取1件产品，并打印剩余产品数量，并打印产品信息（以数字替代）
 */
public class MyConsumer extends Thread {

    private PipedInputStream inputStream;

    public MyConsumer(PipedInputStream inputStream) {
        this.inputStream = inputStream;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                int count = inputStream.available();
                if (count > 0) {
                    System.out.println("MyConsumer read, result=" + inputStream.read());
                }
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }
}
