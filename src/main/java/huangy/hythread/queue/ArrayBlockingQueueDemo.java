package huangy.hythread.queue;

import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author huangy on 2019-10-15
 */
public class ArrayBlockingQueueDemo {

    public static void main(String[] args) throws Exception {
        ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);
        queue.put(1);
        queue.put(2);

        ArrayList<Integer> arr = new ArrayList<>();
        queue.drainTo(arr);

        System.out.println(arr);
    }

}
