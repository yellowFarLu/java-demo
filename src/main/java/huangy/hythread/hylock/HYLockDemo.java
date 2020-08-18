package huangy.hythread.hylock;

/**
 * @author huangy on 2019-11-19
 */
public class HYLockDemo {

    public static void main(String[] args) {

        HYLock lock = new HYLock();

        lock.lock();

        lock.unlock();

    }

}
