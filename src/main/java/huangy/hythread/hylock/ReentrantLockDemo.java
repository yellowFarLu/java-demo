package huangy.hythread.hylock;

import huangy.hythread.SleepUtils;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author huangy on 2019-11-03
 */
public class ReentrantLockDemo {

    private static Lock lock = new ReentrantLock();

    public static void main(String[] args) {

        lockInterruptiblyDemo();
    }

    private static void lockInterruptiblyDemo() {

        Thread t0 = new Thread(() -> {
            lock.lock();
            System.out.println("线程0获取了锁");
        });

        Thread t1 = new Thread(() -> {
            try {
                lock.lockInterruptibly();
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("线程1获取了锁");

            lock.unlock();
            System.out.println("线程1释放了锁");
        });

        t0.start();
        t1.start();

        SleepUtils.second(5);

        t1.interrupt();
    }

    private static void synchronizedInterrupted() {

        Thread t1 = new Thread(() -> {
            synchronized (ReentrantLockDemo.class) {
                System.out.println("线程1获取了锁");

                SleepUtils.second(10);

                System.out.println("线程1释放了锁");
            }
        });

        t1.start();

        SleepUtils.second(1);

        t1.interrupt();
    }

    private static void lockInterrupted() {
        Thread t1 = new Thread(() -> {
            lock.lock();
            System.out.println("线程1获取了锁");

            SleepUtils.second(10);

            lock.unlock();
            System.out.println("线程1释放了锁");
        });

        t1.start();

        SleepUtils.second(1);

        t1.interrupt();
    }
}
