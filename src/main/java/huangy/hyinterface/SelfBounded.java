package huangy.hyinterface;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huangy on 2019-04-07
 */
public class SelfBounded <T extends SelfBounded<T>> {
    T element;

    SelfBounded<T> set(T element) {
        this.element = element;
        return this;
    }

    public T get() {
        return element;
    }

    class A extends SelfBounded<A> {}
    class B extends SelfBounded<A> {}



    static void func1(List<? extends Integer> arr) {

    }

    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>();
        func1(arr);
    }
}
