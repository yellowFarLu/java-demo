package huangy.hythread.pipe;


import java.io.IOException;
import java.io.PipedOutputStream;

/**
 * @author chenxihua
 * @Date 2018年9月17日
 *
 * 我们以数字替代产品 生产者每5秒提供5个产品，放入管道
 */
public class MyProducer extends Thread {

    private PipedOutputStream outputStream;

    public MyProducer(PipedOutputStream outputStream) {
        this.outputStream = outputStream;
    }

    @Override
    public void run() {
        while (true) {
            try {
                for (int i = 0; i < 5; i++) {
                    outputStream.write(i);
                    System.out.println("MyProducer write, i=" + i);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
