package huangy.hythread.tool;

import huangy.hythread.SleepUtils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * 30个线程，但是最多允许10个线程同时执行
 * @author huangy on 2019-11-24
 */
public class SemaphoreTest {

    private static ExecutorService threadPool =
            Executors.newFixedThreadPool(30);

    private static Semaphore s = new Semaphore(10);

    public static void main(String[] args) {
        for (int i = 0; i < 30; i++) {
            threadPool.execute(new Runnable() {
                @Override
                public void run() {
                    try {

                        s.acquire();
                        System.out.println("save data");

                        // sleep效果明细一点
                        SleepUtils.second(1);

                        s.release();

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }

        threadPool.shutdown();
    }

}
