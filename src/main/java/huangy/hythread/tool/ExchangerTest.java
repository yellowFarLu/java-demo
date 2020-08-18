package huangy.hythread.tool;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author huangy on 2019-11-24
 */
public class ExchangerTest {

    private static final Exchanger<String> exgr = new Exchanger<>();

    private static ExecutorService threadPool =
            Executors.newFixedThreadPool(2);

    public static void main(String[] args) {

        threadPool.execute(new Runnable() {
            @Override
            public void run() {

                try {
                    // A录入银行流水数据
                    String A = "A的银行流水";
                    String B = exgr.exchange(A);

                    System.out.println("在A线程中  A和B数据是否一致：" + A.equals(B));
                    System.out.println("A=" + A + "    B=" + B);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });


        threadPool.execute(new Runnable() {
            @Override
            public void run() {

                try {
                    // B录入银行流水数据
                    String B = "B的银行流水";
                    String A = exgr.exchange(B);

                    System.out.println("在B线程中  A和B数据是否一致：" + A.equals(B));
                    System.out.println("A=" + A + "    B=" + B);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        threadPool.shutdown();
    }

}
