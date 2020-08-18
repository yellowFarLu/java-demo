package huangy.hythread.atomic;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * @author huangy on 2020-05-03
 */
public class AtomicIntegerFieldUpdaterTest {

    private volatile int old;

    public AtomicIntegerFieldUpdaterTest(int old) {
        this.old = old;
    }

    private static AtomicIntegerFieldUpdater<AtomicIntegerFieldUpdaterTest> a = AtomicIntegerFieldUpdater
            .newUpdater(AtomicIntegerFieldUpdaterTest.class, "old");

    public static void main(String[] args) {
        AtomicIntegerFieldUpdaterTest conan = new AtomicIntegerFieldUpdaterTest( 10);
        System.out.println(a.getAndIncrement(conan));
        System.out.println(a.get(conan));
    }
}
