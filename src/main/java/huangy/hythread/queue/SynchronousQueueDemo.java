package huangy.hythread.queue;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.SynchronousQueue;

/**
 * @author huangy on 2019-09-29
 */
public class SynchronousQueueDemo {

    public static void main(String[] args) {

        SynchronousQueue<Integer> synchronousQueue = new SynchronousQueue<>();

//        Thread t = new Thread(() -> {
//            try {
//                for (int i = 0; i < 10; i++) {
//
//                    Thread.sleep(1000);
//
//                    /*
//                     * 当拿出一个元素之后，如果队列没有被其他线程放入元素，当前线程会被阻塞
//                     */
//                    Object obj = synchronousQueue.take();
//
//                    System.out.println("获取元素=" + obj);
//                    System.out.println();
//                }
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        });
//        t.start();

        for (int i = 7; i < 10; i++) {
            try {

                Thread.sleep(1000);
                System.out.println("放入元素 i=" + i);

                /*
                 * 当放入一个元素之后，如果队列没有其他线程拿出元素，当前线程会被阻塞
                 */
                synchronousQueue.put(i);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
