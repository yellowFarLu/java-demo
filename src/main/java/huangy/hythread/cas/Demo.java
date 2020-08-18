package huangy.hythread.cas;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author huangy on 2019-10-13
 */
public class Demo {

    private static AtomicInteger tem = new AtomicInteger(0);

    public static void main(String[] args) throws Exception {
        Thread t1 = new Thread() {
            @Override
            public void run() {
                func1();
            }
        };
        t1.start();

        Thread t2 = new Thread() {
            @Override
            public void run() {
                func2();
            }
        };
        t2.start();

        t1.join();
        t2.join();

        System.out.println("最终值， tem=" + tem);
    }

    private static void func1() {
        for (int i = 1; i <= 10; i++) {
            int aa = tem.getAndSet(i);
            System.out.println("线程1 set成功了, tem=" + aa);

            try {
                Thread.sleep(10);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static void func2() {
        for (int i = 1; i <= 10; i++) {
            int aa = tem.getAndSet(i);
            System.out.println("线程2 set成功了, tem=" + aa);

            try {
                Thread.sleep(10);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
