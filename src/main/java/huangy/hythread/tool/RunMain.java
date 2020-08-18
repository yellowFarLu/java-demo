package huangy.hythread.tool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author huangy on 2019-05-04
 */
public class RunMain {

    static class MyRunable implements Runnable {
        @Override
        public void run() {
            System.out.println("MyRunable run, time=" + System.currentTimeMillis());
        }
    }

    public static void main(String[] args) {
        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();

        // 在1秒之后，间隔2秒执行1次
        executorService.scheduleWithFixedDelay(new MyRunable(), 1, 2, TimeUnit.SECONDS);
    }
}
