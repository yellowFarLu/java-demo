package huangy.hythread;

import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * @author huangy on 2019-05-03
 */

class SleepBlocked implements Runnable {
    @Override
    public void run() {

        try {
            TimeUnit.SECONDS.sleep(100);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("exists SleepBlocked");
    }
}

class WaitBlocked implements Runnable {
    @Override
    public void run() {

        try {
            synchronized (WaitBlocked.class) {
                WaitBlocked.class.wait();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("exists WaitBlocked");
    }
}

class IOBlock implements Runnable {

    private InputStream in;

    public IOBlock(InputStream in) {
        this.in = in;
    }

    @Override
    public void run() {
        try {
            in.read();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("exists IOBlock");
    }
}

class SynchonizeBlock implements Runnable {

    public SynchonizeBlock() {
        // 构造函数初始化线程，并且占用锁
        new Thread() {
            @Override
            public void run() {
                f();
            }
        }.start();
    }

    public synchronized void f() {
        while (true) {
            Thread.yield();
        }
    }

    @Override
    public void run() {
        // 另外一条线程执行run（）方法，尝试获取锁
        System.out.println("try to call f()");
        f();
        System.out.println("exists SynchonizeBlock");
    }
}

public class InterruptExecutorDemo {

    private static ExecutorService exec = Executors.newCachedThreadPool();

    static void test(Runnable r) throws InterruptedException {
        Future<?> f = exec.submit(r);
        TimeUnit.MILLISECONDS.sleep(100);
        System.out.println("begin to interrupt " + r.getClass().getName());
        f.cancel(true);
    }

    public static void main(String[] args) throws Exception {
        // sleep阻塞 能够中断
//        test(new SleepBlocked());

        // IO阻塞不可以中断
//        test(new IOBlock(System.in));
//        System.in.close();

        // 同步等待锁的阻塞 不可以中断
//        test(new SynchonizeBlock());

        // wait()阻塞，可以中断
        test(new WaitBlocked());
    }

}













