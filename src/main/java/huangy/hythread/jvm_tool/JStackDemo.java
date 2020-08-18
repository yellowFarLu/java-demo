package huangy.hythread.jvm_tool;

/**
 *
 * 使用jstack 排查死锁
 * @author dufyun
 *
 */
public class JStackDemo {

    public static void main(String[] args) {
        Thread t1 = new Thread(new DeadLockTest(true));//建立一个线程
        Thread t2 = new Thread(new DeadLockTest(false));//建立另一个线程
        t1.setName("thread-dufy-1");
        t2.setName("thread-dufy-2");
        t1.start();//启动一个线程
        t2.start();//启动另一个线程
    }
}

class DeadLockTest implements Runnable {

    public boolean falg;// 控制线程

    DeadLockTest(boolean falg) {
        this.falg = falg;
    }

    public void run() {
        /**
         * 如果falg的值为true则调用t1线程
         */
        if (falg) {
            while (true) {
                synchronized (Demo.o1) {
                    System.out.println("o1 " + Thread.currentThread().getName());
                    synchronized (Demo.o2) {
                        System.out.println("o2 " + Thread.currentThread().getName());
                    }
                }
            }
        }
        /**
         * 如果falg的值为false则调用t2线程
         */
        else {
            while (true) {
                synchronized (Demo.o2) {
                    System.out.println("o2 " + Thread.currentThread().getName());
                    synchronized (Demo.o1) {
                        System.out.println("o1 " + Thread.currentThread().getName());
                    }
                }
            }
        }
    }
}

class Demo {
    static Object o1 = new Object();
    static Object o2 = new Object();
}