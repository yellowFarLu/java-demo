package huangy.jvm.jmm;

/**
 * @author huangy on 2019-11-13
 */
public class ReorderExample {

    int a = 0;

    boolean flag = false;

    public void writer() {
        a = 1;              // 1

        flag = true;        // 2
    }

    public void reader() {

        if (flag) {         // 3

            int i = a * a;  // 4
        }
    }

    public static void main(String[] args) throws Exception {

        ReorderExample reorderExample = new ReorderExample();

        Thread a = new Thread(()->{
            reorderExample.writer();
        });

        Thread b = new Thread(()->{
            reorderExample.reader();
        });
        a.start();
        b.start();

        a.join();
        b.join();

        System.out.println("a=" + reorderExample.a);
        System.out.println("flag=" + reorderExample.flag);
    }

}
