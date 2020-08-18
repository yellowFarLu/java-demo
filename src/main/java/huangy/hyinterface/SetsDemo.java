package huangy.hyinterface;

import java.util.HashSet;
import java.util.Set;

/**
 * @author huangy on 2019-04-06
 */
public class SetsDemo {

    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>();
        set1.add(1);
        set1.add(2);
        set1.add(3);
        Set<Integer> set2 = new HashSet<>();
        set2.add(1);
        set2.add(2);
        set2.add(5);

        Set<Integer> result = Sets.intersection(set1, set2);

        System.out.println(result);
    }

}
