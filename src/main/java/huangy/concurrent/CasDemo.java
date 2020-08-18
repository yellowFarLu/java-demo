package huangy.concurrent;

/**
 * @author huangy on 2020-04-12
 */
public class CasDemo {

    public static void main(String[] args) throws Exception {

        CasLock casLock = new CasLock();

        Thread  t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    casLock.incrValue();
                }
            }
        });

        Thread  t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    casLock.incrValue();
                }
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(casLock.getValue());
    }

}
