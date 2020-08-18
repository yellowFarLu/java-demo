package huangy.hythread.hyvolatile;

/**
 * @author huangy on 2019-11-16
 */
public class DoubleDemo {

    private static volatile double tem = 1;

    public static void main(String[] args) throws Exception {
        Thread t1 = new Thread(() -> {
            tem = 100000;
        });

        Thread t2 = new Thread(() -> {
            tem = 1;
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(tem);
    }
}
