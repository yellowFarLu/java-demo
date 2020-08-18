package huangy.hythread.executor;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author huangy on 2019-10-19
 */
public class RunableDemo {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        executorService.submit(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println("Runnable线程执行，i=" + i);

                    if (i == 3) {
                        // 抛出异常到子线程，子线程挂了，不会继续执行
                        throw new RuntimeException();
                    }
                }
            }
        });

        executorService.submit(new Callable<Object>() {

            @Override
            public Object call() throws Exception {
                for (int i = 0; i < 10; i++) {
                    System.out.println("Callable线程执行，i=" + i);

                    if (i == 3) {
                        // 抛出异常到子线程，子线程挂了，不会继续执行
                        throw new RuntimeException();
                    }
                }

                return null;
            }
        });
    }

}
