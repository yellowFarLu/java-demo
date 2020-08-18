package huangy.hythread.hylock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author huangy on 2019-10-14
 */
public class ReadWriteLockDemo {

    /**
     * lock、tryLock、lockInterruptibly、tryLock(long time, TimeUnit timeUnit)
     *
     * - lock 拿不到锁会一直等待。tryLock是去尝试，拿不到就返回false，拿到返回true
     * - tryLock 拿到锁返回true，否则false
     * - tryLock(long time, TimeUnit timeUnit) 拿不到锁，就等待一段时间，获取到锁返回true，超时返回false
     * - lockInterruptibly 调用后如果没有获取到锁会一直阻塞，阻塞过程中会接受中断信号
     */
    public static void main(String[] args) throws Exception {

        ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();

        ReentrantReadWriteLock.ReadLock readLock = readWriteLock.readLock();

        ReentrantReadWriteLock.WriteLock writeLock = readWriteLock.writeLock();

        Thread t1 = new Thread(() -> {
            try {
                readLock.lock();
                System.out.println("线程1 获取了读锁");

                Thread.sleep(3000);

                readLock.unlock();

                System.out.println("线程1 释放了读锁");
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        t1.start();


        Thread t2 = new Thread(() -> {
            try {
                // 保证读锁先被线程1获得
                Thread.sleep(100);

                readLock.lock();
                System.out.println("线程2 获取了读锁");

                writeLock.lock();
                System.out.println("线程2 获取了写锁");

                writeLock.unlock();
                System.out.println("线程2 释放了写锁");

                readLock.unlock();;
                System.out.println("线程2 释放了读锁");

            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        t2.start();

        Thread t3 = new Thread(() -> {
            try {
                Thread.sleep(200);
                // 等线程2尝试获取锁之后，中断线程2
                t2.interrupt();

            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        t3.start();

        t1.join();
        t2.join();
        t3.join();
    }
}
