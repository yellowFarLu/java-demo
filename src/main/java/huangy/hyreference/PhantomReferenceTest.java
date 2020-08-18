package huangy.hyreference;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

/**
 * @author huangy on 2019-04-20
 */
public class PhantomReferenceTest {

    public static void main(String[] args) throws Exception {
        ReferenceQueue<MyDate> queue = new ReferenceQueue<>();
        PhantomReference<MyDate> ref = new PhantomReference<MyDate>(new MyDate(), queue);
        System.gc();

        System.out.println(queue.poll());
    }

}
