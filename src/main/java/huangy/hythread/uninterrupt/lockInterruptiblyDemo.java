package huangy.hythread.uninterrupt;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class lockInterruptiblyDemo {

    public static void test3() throws Exception {

        final Lock lock = new ReentrantLock();
        lock.lock();

        Thread t1 = new Thread(new Runnable(){

            @Override
            public void run() {
                // lock不会响应中断
//                lock.lock();

                // lockInterruptibly会响应中断
	        	try {
					lock.lockInterruptibly();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

                System.out.println(Thread.currentThread().getName()+" interrupted.");
            }
        });

        t1.start();
        Thread.sleep(1000);

        t1.interrupt();
    }

    public static void main(String[] args) throws Exception {
        test3();
    }
}