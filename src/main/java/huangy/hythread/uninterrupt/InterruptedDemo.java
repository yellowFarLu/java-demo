package huangy.hythread.uninterrupt;

/**
 * @author huangy on 2019-10-17
 */
public class InterruptedDemo {

    public static void main(String[] args) {

        Thread t = new Thread(() -> {

            try {
                while (true) {
                    System.out.println("子线程在运行");
                    Thread.sleep(1000);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }


        });

        t.start();

        t.interrupt();
    }

}
