package huangy.hythread.executor;

import huangy.hythread.SleepUtils;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author huangy on 2019-11-24
 */
public class ExecutorsMonitorDemo {

    public static void main(String[] args) {
        ExecutorsMonitor executorsMonitor = new ExecutorsMonitor(1, 10,
                1000, TimeUnit.SECONDS, new ArrayBlockingQueue(4), "监控线程池");

        executorsMonitor.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("这是线程池中执行的方法");
            }
        });

        // 等待任务执行完毕
        SleepUtils.second(1);

        executorsMonitor.shutdown();
    }

}
