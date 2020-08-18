package huangy.hythread.queue;

import java.util.Date;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 生产者-消费者实战
 * @author huangy on 2019-10-15
 */
public class LinkedBlockingQueueDemo {

    private static BlockingQueue<Integer> queue =
            new LinkedBlockingQueue<>(1);

    public static void main(String[] args) throws Exception {

        Thread consumer = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        System.out.println("消费者读取了数据，result=" + queue.take() + "  当前时间=" + new Date());
                        Thread.sleep(2000);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        Thread provider = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        queue.put(1);
                        System.out.println("生产者放入了数据" + "  当前时间=" + new Date());
                        Thread.sleep(2000);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        consumer.start();
        provider.start();

        consumer.join();
        provider.join();
    }

}
