package huangy.hythread.queue;

import huangy.hythread.SleepUtils;

import java.util.concurrent.LinkedTransferQueue;

/**
 * @author huangy on 2019-11-23
 */
public class LinkedTransferQueueDemo {

    public static void main(String[] args) {

        LinkedTransferQueue<Integer> queue = new LinkedTransferQueue<>();

        Thread consumer = new Thread(()->{
           try {
               System.out.println("消费者尝试拿数据");
               Integer result = queue.take();

               System.out.println("消费者拿到数据啦，result=" + result);
           } catch (Exception e) {
               e.printStackTrace();
           }
        });
        consumer.start();

        SleepUtils.second(2);

        queue.put(1);
    }

}
