package huangy.hythread.threadmethod;

/**
 * @author huangy on 2019-10-14
 */
public class YieldDemo {

    public static void main(String[] args) throws Exception {
        Thread t1 = new Thread(()->{
            try {
                while (true) {
                    System.out.println("线程1执行");

                    Thread.yield();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        Thread t2 = new Thread(()->{
            try {
                while (true) {
                    System.out.println("线程2执行");

                    Thread.yield();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();
    }

}
