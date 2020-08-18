package huangy.tem;

/**
 * 两个线程交替打印1-100的整数
 * 题目说明：两个线程交替打印1-100的整数，一个打印奇数，一个打印偶数，要求输出结果有序
 * @author huangy on 2020-03-30
 */
public class Tem1 {

    // volatile保证可见性
    private static volatile Boolean tag;

    public static void main(String[] args) throws Exception {

        tag = true;

        // 打印奇数
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i < 100; i++) {
                    if (i % 2 != 0) {

                        while (!tag) {
                            Thread.yield();
                        }

                        System.out.println(i);
                        tag = false;
                    }
                }
            }
        });

        // 打印偶数
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 100; i++) {
                    if (i % 2 == 0) {

                        while (tag) {
                            Thread.yield();
                        }

                        System.out.println(i);
                        tag = true;
                    }
                }
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
    }

}
