package huangy.hythread.tool;

import java.util.concurrent.CyclicBarrier;

/**
 * @author huangy on 2019-11-24
 */
public class CyclicBarrierTest2 {

    static CyclicBarrier c = new CyclicBarrier(2, new A());

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    c.await();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println(1);
            }
        }).start();

        try {
            c.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(c.isBroken());
        System.out.println(2);
    }

    static class A implements Runnable {
        @Override
        public void run() {
            System.out.println("3");
        }
    }
}
