package huangy.hythread.threadlocal;

import java.lang.ref.WeakReference;

/**
 * @author huangy on 2019-10-13
 */
public class Demo {

    public static void main(String[] args) {

        WeakReference<ThreadLocal<Integer>> reference = new WeakReference<>(new ThreadLocal<>());
        reference.get().set(1);

        System.gc();

        System.out.println("看看ThreadLocal 还在不在， threadLocal=" + reference.get());
    }

}
