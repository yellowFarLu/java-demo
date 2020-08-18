package huangy.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author huangy on 2019-06-19
 */
public class StringDemo {

    public static void main(String[] args) {
        List<String> arrays = new ArrayList<>();
        arrays.add("1");
        arrays.add("2");
        arrays.add("3");
        arrays.add("0");

        List<Integer> intLists = arrays.stream().map(Integer::parseInt).collect(Collectors.toList());

        System.out.println(intLists);
    }

}
