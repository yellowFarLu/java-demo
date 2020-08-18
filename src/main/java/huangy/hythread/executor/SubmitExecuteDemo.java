package huangy.hythread.executor;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author huangy on 2019-10-19
 */
public class SubmitExecuteDemo {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();

        /*
         * submit有返回值
         */
        Future future = executorService.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    // 这里睡眠一下，是为了不要让这条线程执行太快，否则就可以1条线程直接执行3个任务了
                    Thread.sleep(100);
                } catch (Exception e) {
                     e.printStackTrace();
                }
                System.out.println("我是submit.Runnable任务, tid=" + Thread.currentThread().getId());
            }
        });

        executorService.submit(new Callable<Object>() {
            @Override
            public Object call() throws Exception {
                Thread.sleep(50);
                System.out.println("我是submit.Callable任务, tid=" + Thread.currentThread().getId());
                return null;
            }
        });

        /*
         * execute没有返回值
         */
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("我是execute.Runnable任务, tid=" + Thread.currentThread().getId());
            }
        });
    }

}
