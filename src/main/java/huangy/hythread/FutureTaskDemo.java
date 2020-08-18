package huangy.hythread;

import java.util.concurrent.*;

/**
 * @author huangy on 2019-05-04
 */
public class FutureTaskDemo {

    public static void main(String[] args) throws Exception {

        ExecutorService executor = Executors.newCachedThreadPool();

        MyTask myTask = new MyTask();
        FutureTask<Integer> futureTask = new FutureTask<>(myTask);

        executor.submit(futureTask);
        executor.shutdown();

        System.out.println("主线程在执行任务, time=" + System.currentTimeMillis());

        System.out.println("task运行结果"+futureTask.get());
    }
}

class MyTask implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        System.out.println("子线程在进行计算, time=" + System.currentTimeMillis());

        Thread.sleep(3000);
        int sum = 0;
        for(int i=0;i<100;i++)
            sum += i;
        System.out.println("子线程计算完了, time=" + System.currentTimeMillis());
        return sum;
    }
}