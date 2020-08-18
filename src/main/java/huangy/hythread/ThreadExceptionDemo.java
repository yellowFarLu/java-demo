package huangy.hythread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;

/**
 * @author huangy on 2019-05-03
 */

class ExceptionThread2 implements Runnable {
    @Override
    public void run() {
        Thread t = Thread.currentThread();

        System.out.println("run() by" + t);

//        System.out.println("eh=" + t.getUncaughtExceptionHandler());

//        throw new RuntimeException();
    }
}

class MyUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println("caught " + e);
    }
}

class HandlerThreadFactory implements ThreadFactory {
    @Override
    public Thread newThread(Runnable r) {
        System.out.println(this + " to create new Thread");

        Thread t = new Thread(r);

        t.setUncaughtExceptionHandler(new MyUncaughtExceptionHandler());

//        System.out.println("eh=" + t.getUncaughtExceptionHandler());

        return t;
    }
}

public class ThreadExceptionDemo {

    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newCachedThreadPool(new HandlerThreadFactory());

        executorService.execute(new ExceptionThread2());

        executorService.shutdown();
    }

}
