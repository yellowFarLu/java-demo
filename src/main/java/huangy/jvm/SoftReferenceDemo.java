package huangy.jvm;

import java.lang.ref.SoftReference;

/**
 * @author huangy on 2019-10-13
 */
public class SoftReferenceDemo {

    public static void main(String[] args) {
        SoftReference<Node> tem = new SoftReference<>(new Node());
        System.gc();
        System.out.println("get result=" + tem.get());
    }

}
