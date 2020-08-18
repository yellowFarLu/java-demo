package huangy.base;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huangy on 2019-11-29
 */
public class Tem {

    int a;

    void func() {}

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);

        Integer[] arr = new Integer[list.size()];

        arr = list.toArray(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    static class A {
        void func() {

        }
    }
}

