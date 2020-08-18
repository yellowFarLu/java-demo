package huangy.hythread.queue;

import java.util.concurrent.PriorityBlockingQueue;

/**
 * @author huangy on 2019-10-15
 */
public class PriorityBlockingQueueDemo {

    public static void main(String[] args) throws Exception {

        PriorityBlockingQueue<Integer> queue = new PriorityBlockingQueue<>();

        queue.add(1);

        System.out.println(queue.take());
        System.out.println(queue.take());
    }

}
