package huangy.jvm;

/**
 * @author huangy on 2020-04-13
 */
public class SynDemo {

    public static void main(String[] args) {

        synchronized (SynDemo.class) {
            System.out.println("获取第一把锁");

            synchronized (SynDemo.class) {
                System.out.println("获取第二把锁");
                System.out.println("证明可重入");
            }

        }
    }

}
