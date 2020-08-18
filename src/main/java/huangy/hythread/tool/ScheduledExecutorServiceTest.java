package huangy.hythread.tool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author huangy on 2019-05-04
 */
public class ScheduledExecutorServiceTest {

    public static void main(String[] args) {

        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();

        executorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println("run "+ System.currentTimeMillis());
            }

            // 1秒以后开始执行，而且每隔100毫秒执行1次
        }, 1000, 100, TimeUnit.MILLISECONDS);
    }
}
