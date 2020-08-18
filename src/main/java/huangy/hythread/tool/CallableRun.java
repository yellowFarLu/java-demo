package huangy.hythread.tool;

import java.util.concurrent.*;

public class CallableRun {

    static class MyCallableA implements Callable<String> {

        @Override
        public String call() throws Exception {
            try {
                System.out.println(
                        "callA begin " + Thread.currentThread().getName() + ", "
                                + System.currentTimeMillis());
                TimeUnit.SECONDS.sleep(3); // 休眠3秒
                System.out.println("callA end " + Thread.currentThread().getName() + ", "
                        + System.currentTimeMillis());
            } catch (Exception e) {
                e.printStackTrace();
            }
            return "returnA";
        }
    }

    static class MyCallableB implements Callable<String>  {

        @Override
        public String call() throws Exception{
            System.out.println("callB begin " + Thread.currentThread().getName() + ", "
                    + System.currentTimeMillis());
            System.out.println("callB end " + Thread.currentThread().getName() + ", "
                    + System.currentTimeMillis());
            return "returnB";
        }
    }

    public static void main(String[] args) {

        try {

            MyCallableA myCallableA = new MyCallableA();
            MyCallableB myCallableB = new MyCallableB();

            ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();

            // 延迟3秒执行A
            ScheduledFuture futureA =
                    executorService.schedule(myCallableA, 3L, TimeUnit.SECONDS);

            // 延迟1秒执行B
            ScheduledFuture futureB =
                    executorService.schedule(myCallableB, 1L, TimeUnit.SECONDS);

            System.out.println("返回值A：" + futureA.get());
            System.out.println("返回值B：" + futureB.get());

            executorService.shutdown();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
