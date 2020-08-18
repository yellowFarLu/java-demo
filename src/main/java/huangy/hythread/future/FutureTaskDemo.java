package huangy.hythread.future;

import huangy.hythread.SleepUtils;

import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * @author huangy on 2019-11-24
 */
public class FutureTaskDemo {

    private static final ConcurrentHashMap<Object, Future<String>> taskCache
            = new ConcurrentHashMap<>();

    private static String executionTask(final String taskName) throws Exception {

        while (true) {

            System.out.println(Thread.currentThread().getName() + "准备获取数据");

            Future<String> future = taskCache.get(taskName);

            if (future == null) {
                Callable<String> task = new Callable<String>() {
                    @Override
                    public String call() throws Exception {
                        SleepUtils.second(2);
                        return taskName;
                    }
                };

                FutureTask<String> futureTask = new FutureTask<>(task);

                future = taskCache.putIfAbsent(taskName, futureTask);

                if (future == null) {
                    future = futureTask;
                    futureTask.run();
                }

            }

            return future.get();
        }
    }

    public static void main(String[] args) {

        String taskName = "myTask";

        Thread t1 = new Thread(() -> {
            try {
                String tem = executionTask(taskName);
                System.out.println("线程1获取到结果，result=" + tem);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        t1.setName("线程1");
        t1.start();

        Thread t2 = new Thread(() -> {
            try {
                String tem = executionTask(taskName);
                System.out.println("线程2获取到结果，result=" + tem);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        t2.setName("线程2");
        t2.start();
    }

}
