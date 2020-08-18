package huangy.hythread.hyvolatile;

/**
 * @author huangy on 2019-10-11
 */
public class HYVolatile extends Thread {

    private static volatile boolean flag = false;

    public void run() {

        while (!flag) ;

        System.out.println("i receive flag");
    }

    public static void main(String[] args) throws Exception {
        new HYVolatile().start();

        Thread.sleep(2000);

        flag = true;
    }
}
