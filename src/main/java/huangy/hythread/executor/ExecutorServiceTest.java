package huangy.hythread.executor;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

public class ExecutorServiceTest {

    public static void main(String[] args) throws Exception {

        ExecutorService executorService = Executors.newCachedThreadPool();
        List<Future<String>> resultList = new ArrayList<>();

        // 创建10个任务并执行
        for (int i = 0; i < 10; i++) {
            // 使用ExecutorService执行Callable类型的任务，并将结果保存在future变量中
            Future<String> future = executorService.submit(new TaskWithResult(i));
            // 将任务执行结果存储到List中
            resultList.add(future);
        }
        executorService.shutdown();

        Thread.sleep(2000);

        // 遍历任务的结果
        for (Future<String> fs : resultList) {

            try {

                System.out.println(fs.get()); // 打印各个线程（任务）执行的结果

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

class TaskWithResult implements Callable<String> {
    private int id;

    public TaskWithResult(int id) {
        this.id = id;
    }

    /**
     * 任务的具体过程，一旦任务传给ExecutorService的submit方法，则该方法自动在一个线程上执行。
     */
    public String call() throws Exception {
        System.out.println("call()方法被自动调用,干活！！！             " + Thread.currentThread().getName());

        if (id == 1)
            throw new RuntimeException("这个任务抛出了异常");

        // 一个模拟耗时的操作
        for (int i = 999999999; i > 0; i--)
            ;

        return "call()方法被自动调用，任务的结果是：" + id + "    " +          	 Thread.currentThread().getName();
    }
}
