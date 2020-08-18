package huangy.threadlocal;

import com.alibaba.ttl.TransmittableThreadLocal;
import com.alibaba.ttl.threadpool.TtlExecutors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author huangy on 2020-06-21
 */
public class InheritableThreadLocalDemo {

    private static void demo4() throws Exception {

        ThreadLocal<Integer> threadLocal = new TransmittableThreadLocal<>();

        // 如果是ThreadLocal，子线程无法读取到父线程的值
//        ThreadLocal<Integer> threadLocal = new ThreadLocal<>();

        // 如果是InheritableThreadLocal，子线程无法重新读取到父线程的值
//        ThreadLocal<Integer> threadLocal = new InheritableThreadLocal<>();

        ExecutorService executorService =
                TtlExecutors.getTtlExecutorService(Executors.newFixedThreadPool(1));

        System.out.println("主线程开启");
        threadLocal.set(1);
        System.out.println("主线程读取本地变量：" + threadLocal.get());

        executorService.submit(() -> {
            System.out.println("子线程读取本地变量：" + threadLocal.get());
        });

        TimeUnit.SECONDS.sleep(1);

        threadLocal.set(2);
        System.out.println("主线程读取本地变量：" + threadLocal.get());

        executorService.submit(() -> {
            //[读到了主线程修改后的新值]
            System.out.println("子线程读取本地变量：" + threadLocal.get());
            threadLocal.set(3);
            System.out.println("子线程读取本地变量：" + threadLocal.get());
        });

        TimeUnit.SECONDS.sleep(1);
        //依旧读取的是 2
        System.out.println("主线程读取本地变量：" + threadLocal.get());
    }

    private static void demo3() throws Exception {
        final InheritableThreadLocal<String> inheritableThreadLocal =
                new InheritableThreadLocal<>();
        inheritableThreadLocal.set("xiexiexie");

        //输出 xiexiexie
        System.out.println("父线程中获取inheritableThreadLocal， 值为：" +
                inheritableThreadLocal.get());

        Runnable runnable = new Runnable() {
            @Override
            public void run() {

                System.out.println("子线程中获取inheritableThreadLocal， 值为：" +
                        inheritableThreadLocal.get());

                inheritableThreadLocal.set("zhangzhangzhang");

                System.out.println("子线程中获取inheritableThreadLocal， 值为：" +
                        inheritableThreadLocal.get());
            }
        };

        ExecutorService executorService = Executors.newFixedThreadPool(1);
        executorService.submit(runnable);
        TimeUnit.SECONDS.sleep(1);

        /*
         * 第二次执行的时候，使用的是上一条线程，
         * 并且InheritableThreadLocal只有在线程初始化的时候才从父线程继承数据。
         * 因此这次执行任务直接使用线程当前的InheritableThreadLocal
         */
        System.out.println("父线程中获取inheritableThreadLocal， 值为：" +
                inheritableThreadLocal.get());
        executorService.submit(runnable);

        TimeUnit.SECONDS.sleep(1);

        executorService.shutdown();
    }

    private static void demo2() throws Exception {
        Thread.currentThread().setName("主线程");

        final ThreadLocal<String> threadLocal = new InheritableThreadLocal<>();
        // 调用set方法的时候，会初始化一个ThreadLocalMap
        threadLocal.set("这个父线程设置的变量");

        Thread subThread = new Thread(new Runnable() {
            @Override
            public void run() {
                // 子线程获取父线程的threadLocal
                // 输出为：    子线程获取的变量为   这个父线程设置的变量
                System.out.println("子线程获取的变量为   " +
                        threadLocal.get());
            }
        });
        subThread.setName("子线程");
        subThread.start();
    }

    private static void demo1() throws Exception {

        Thread.currentThread().setName("主线程");

        final ThreadLocal<String> threadLocal = new ThreadLocal<>();
        // 调用set方法的时候，会初始化一个ThreadLocalMap
        threadLocal.set("这个父线程设置的变量");

        Thread subThread = new Thread(new Runnable() {
            @Override
            public void run() {
                // 子线程获取父线程的threadLocal，结果为null
                System.out.println("子线程获取的变量为   " +
                        threadLocal.get());
            }
        });
        subThread.setName("子线程");
        subThread.start();
    }

    public static void main(String[] args) throws Exception {
        demo4();
    }
}
