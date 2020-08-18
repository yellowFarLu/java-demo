package huangy.jvm;

import java.lang.ref.WeakReference;

/**
 * @author huangy on 2019-10-13
 */
public class WeakReferenceDemo {

    public static void main(String[] args) {
        WeakReference<Node> weakReference = new WeakReference<>(new Node());
        System.gc();
        System.out.println("get result=" + weakReference.get());
    }

}
