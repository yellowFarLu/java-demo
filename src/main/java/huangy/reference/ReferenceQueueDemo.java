package huangy.reference;

import huangy.hyreference.MyDate;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

/**
 * @author huangy on 2020-06-21
 */
public class ReferenceQueueDemo {

    public static void main(String[] args) {
        ReferenceQueue queue = new ReferenceQueue();
        PhantomReference ref = new PhantomReference(new MyDate(), queue);
        System.gc();
    }

}
