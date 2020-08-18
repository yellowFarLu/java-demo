package huangy.hythread.queue;

import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @author huangy on 2019-11-23
 */
public class ConcurrentLinkedQueueDemo {

    public static void main(String[] args) {
        ConcurrentLinkedQueue<Integer> queue = new ConcurrentLinkedQueue<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
    }

}
