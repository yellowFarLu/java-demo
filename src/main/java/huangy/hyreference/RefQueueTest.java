package huangy.hyreference;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/**
 * @author huangy on 2019-04-20
 */
public class RefQueueTest {

    public static void main(String[] args) throws Exception {

        ReferenceQueue referenceQueue = new ReferenceQueue();

        WeakReference weakReference = new WeakReference(new MyDate(), referenceQueue);
        ReferenceTest.drainMemory();

        WeakReference k = (WeakReference) referenceQueue.remove();
        System.out.println("额外处理 k.get()=" + k.get());
    }

}
