package huangy.algorithm.alibaba;

/**
 * @author huangy on 2020-07-08
 */
public class BuyInventory {

    private static Integer inventory = 200;

    public static void main(String[] args) throws Exception {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    buy();
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    buy();
                }
            }
        });

        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    buy();
                }
            }
        });

        // 不加同步的情况下，存在丢失更新的情况，从而导致超卖
        thread1.start();
        thread2.start();
        thread3.start();

        thread1.join();
        thread2.join();
        thread3.join();

        System.out.println("剩余的票=" + inventory);
    }

    static synchronized void buy() {
        if (inventory > 0) {
            inventory--;
        }
    }
}
