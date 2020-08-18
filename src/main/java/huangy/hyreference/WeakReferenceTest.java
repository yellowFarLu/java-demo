package huangy.hyreference;

import java.lang.ref.WeakReference;

/**
 * @author huangy on 2019-04-20
 */
public class WeakReferenceTest {

    public static void main(String[] args) {
        WeakReference ref = new WeakReference(new MyDate());
        System.gc();
    }
}
