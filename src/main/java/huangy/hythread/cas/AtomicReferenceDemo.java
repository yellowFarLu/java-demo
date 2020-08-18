package huangy.hythread.cas;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author huangy on 2019-10-13
 */
public class AtomicReferenceDemo {

    static AtomicReference<Node> atomicReference = new AtomicReference<>();

    public static void main(String[] args) throws Exception {

        atomicReference.set(new Node());

        Thread t1 = new Thread() {
            @Override
            public void run() {
                Node node = atomicReference.get();
                for (int i = 0; i < 100000; i++) {
                    node.a++;
                }
            }
        };

        Thread t2 = new Thread() {
            @Override
            public void run() {
                Node node = atomicReference.get();
                for (int i = 0; i < 100000; i++) {
                    node.a++;
                }
            }
        };

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(atomicReference.get().a);
    }


    static class Node {
        public int a;
    }
}
