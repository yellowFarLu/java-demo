package huangy.hythread.lock;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author huangy on 2019-10-13
 */
public class ConditionDemo {

    static Lock lock = new ReentrantLock();
    static Condition condition = lock.newCondition();

    public static void main(String[] args) throws Exception {

        Thread t1 = new Thread() {
            @Override
            public void run() {
                try {
                    lock.tryLock();
                    System.out.println("子线程1被挂起了");
                    condition.await();
                    lock.unlock();

                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println("子线程1被释放了");
            }
        };
        t1.start();
        Thread.sleep(100);


        Thread t2 = new Thread() {
            @Override
            public void run() {
                try {

                    System.out.println("线程2尝试获取锁， result=" + lock.tryLock());
                    lock.unlock();
                    condition.signal();
                    System.out.println("线程2释放锁");

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        t2.start();

        t1.join();
        t2.join();
    }

}
