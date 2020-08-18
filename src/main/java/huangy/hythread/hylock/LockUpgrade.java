package huangy.hythread.hylock;

import huangy.hythread.SleepUtils;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 锁升级示例
 * @author huangy on 2019-11-20
 */
public class LockUpgrade {

    private static ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    private static ReentrantReadWriteLock.ReadLock readLock;

    private static ReentrantReadWriteLock.WriteLock writeLock;

    static {
        readLock =  readWriteLock.readLock();
        writeLock = readWriteLock.writeLock();
    }

    public static void main(String[] args) throws Exception {
        Thread t1 = new Thread(()->{
            readLock.lock();
            System.out.println("线程1获取了读锁");

            // 保证线程2已经运行了
            SleepUtils.second(2);

            System.out.println("线程1尝试获取写锁");
            writeLock.lock();
        });

        Thread t2 = new Thread(()->{
            System.out.println("线程2获取了读锁");
            readLock.lock();
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();
    }
}

