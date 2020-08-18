package huangy.collections;

import java.util.*;

/**
 * @author huangy on 2019-04-14
 */
public class UnSpoort {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("A B C D".split(" "));

        ListIterator<String> listIterator = list.listIterator();
        listIterator.next();

        System.out.println(listIterator.hasPrevious());
        System.out.println(listIterator.previousIndex());
        System.out.println(listIterator.previous());

    }

}
