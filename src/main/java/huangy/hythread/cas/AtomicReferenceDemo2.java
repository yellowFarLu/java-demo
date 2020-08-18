package huangy.hythread.cas;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author huangy on 2019-10-13
 */
public class AtomicReferenceDemo2 {

    public static void main(String[] args) {

        // 创建两个Person对象，它们的id分别是101和102。
        Person2 p1 = new Person2(101);
        Person2 p2 = new Person2(102);

        // 新建AtomicReference对象，初始化它的值为p1对象
        AtomicReference ar = new AtomicReference(p1);

        //更改p1的id.
        p1.setId(106);
        // 通过CAS设置ar。如果ar的值为p1的话，则将其设置为p2。
        boolean tag = ar.compareAndSet(p1, p2);
        System.out.println("设置p2的结果=" + tag);

        System.out.println("看下还是不是p1， 结果=" + ar.get().equals(p1));
    }

}

class Person2 {
    volatile long id;

    public Person2(long id) {
        this.id = id;
    }

    public String toString() {
        return "id:" + id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
