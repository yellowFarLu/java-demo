package huangy.tem2;

/**
 * 实现两个线程，一个线程打印1到52的整数，另一个线程打印A到Z共26个字母，打印效果是12A34B...5152Z。
 * @author huangy on 2020-04-15
 */
public class Tem1 {

    /**
     * volatile保证可见性
     */
    private static volatile boolean tag = true;

    public static void main(String[] args) throws Exception {

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {

                int j = 0;

                for (int i = 1; i <= 52; i++) {

                    /*
                     * 笔试的时候写成了if，用if会有问题，
                     * 就是当前线程让出CPU，可能其他线程还没有执行，当前线程又去抢CPU，并且抢成功了，就有问题了
                     */
                    while (!tag) {
                        Thread.yield();
                    }

                    System.out.println(i);
                    j++;

                    if (j == 2) {
                        tag = false;
                        j = 0;
                    }
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                int end = (int)'Z';
                for(int i = (int)'A'; i <= end; i++) {
                    while (tag) {
                        Thread.yield();
                    }
                    System.out.println((char)i);
                    tag = true;
                }
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

    }

}
