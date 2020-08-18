package huangy.hythread.tool;

import huangy.hythread.SleepUtils;

import java.util.concurrent.CyclicBarrier;

/**
 * @author huangy on 2019-11-24
 */
public class CyclicBarrierTest3 {

    static CyclicBarrier c = new CyclicBarrier(2);

    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    c.await();
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println(c.isBroken());
                }
            }
        });

        thread.start();

        // 保证thread线程被阻塞了，才中断thread线程
        SleepUtils.second(1);

        thread.interrupt();

        try {
            c.await();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(c.isBroken());
        }
    }

}
