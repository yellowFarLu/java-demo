package huangy.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huangy on 2019-06-12
 */
public class RemoveDemo {

    //
    public static void main(String[] args) {
        List<Integer> one = new ArrayList<>();
        one.add(1);
        one.add(2);
        one.add(3);

        List<Integer> two = new ArrayList<>();
        two.add(2);
        two.add(3);

        one.removeAll(two);

        System.out.println(one);

    }

}
