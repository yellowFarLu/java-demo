package huangy.concurrent;

/**
 * @author huangy on 2020-04-12
 */
public class IncrQuestionDemo {

    private volatile static int value;

    public static void main(String[] args) throws Exception {

        Thread  t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    value++;
                }
            }
        });

        Thread  t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    value++;
                }
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(value);
    }

}
