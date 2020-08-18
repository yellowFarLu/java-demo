package huangy.array;

import huangy.base.Person;

import java.util.*;

/**
 * @author huangy on 2019-10-10
 */
public class ArrayDemo {

    public static void main(String[] args) {

        LinkedList<Integer> arr = new LinkedList<>();
        arr.add(0);
        arr.add(1);
        arr.add(2);

        ListIterator<Integer> iterator = (ListIterator)arr.iterator();
        while (iterator.hasNext()) {
            System.out.println("has pre=" + iterator.hasPrevious());
            System.out.println(iterator.next());
        }

        Person person = new Person() {
            @Override
            public void func() {

            }
        };

    }

}
