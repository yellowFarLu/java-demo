package huangy.hyreference;

import java.lang.ref.SoftReference;

/**
 * @author huangy on 2019-04-20
 */
public class SoftReferenceTest {

    public static void main(String[] args) {
        SoftReference<MyDate> ref = new SoftReference<>(new MyDate());
        // 异步消耗大量内存，触发垃圾回收（同步的情况下，貌似不会触发gc）
        ReferenceTest.drainMemory();
    }

}
