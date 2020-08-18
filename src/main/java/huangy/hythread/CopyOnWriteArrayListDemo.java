package huangy.hythread;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author huangy on 2019-10-14
 */
public class CopyOnWriteArrayListDemo {

    public static void main(String[] args) throws Exception {

        CopyOnWriteArrayList<Integer> arrayList = new CopyOnWriteArrayList<>();
        arrayList.add(0);

        Thread t1 = new Thread(() -> {
            try {
                System.out.println("线程1尝试修改");
                arrayList.set(0, 1);
                System.out.println("线程1修改好了");
                Thread.sleep(3000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        t1.start();

        Thread t2 = new Thread(() -> {
            try {
                // 睡一下，保证线程1获取到锁
                Thread.sleep(200);

                System.out.println("线程2尝试修改");
                arrayList.set(0, 2);
                System.out.println("线程2修改好了");
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        t2.start();

        t1.join();
        t2.join();

        System.out.println(arrayList);
    }

}
