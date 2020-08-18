package huangy.hythread.hylock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 锁降级实例
 * @author huangy on 2019-11-20
 */
public class LockDowngrada {

    private ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    private ReentrantReadWriteLock.ReadLock readLock;

    private ReentrantReadWriteLock.WriteLock writeLock;

    private volatile boolean update;

    {
        readLock =  readWriteLock.readLock();
        writeLock = readWriteLock.writeLock();
    }

    public void processData() {

        readLock.lock();

        if (!update) {

            // 必须先释放读锁，才能获取写锁
            readLock.unlock();

            // 锁降级从写锁获取到开始
            writeLock.lock();

            try {
                if (!update) {
                    // 假装在准备数据

                    // 准备好了，设置标志位
                    update = true;
                }

                /*
                 * 因为下面todo的地方需要进行数据处理，所以这里需要先获取读锁，为什么这里要先获取读锁呢？
                 * 由于这里获取了读锁，由于不支持锁升级，那么任意线程都不能再获取写锁，因此在todo处理数据的时候，是线程安全的。
                 * 如果这里不获取读锁，那么在writeLock.unlock();释放掉写锁后，其他线程可以获取写锁，并且修改数据，那么当前线程是看不到最新的数据的。
                 */
                readLock.lock();

            } finally {
                writeLock.unlock();
            }

            // 锁降级完成，写锁降级为读锁
        }

        try {
            // todo 假装处理数据
        } finally {
            readLock.unlock();
        }
    }

}
