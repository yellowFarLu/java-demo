package huangy.java8;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author huangy on 2019-06-21
 */
public class MapDemo {

    void func() {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 1);
        map.put(2, 2);
        map.put(3, 3);
        List list = map.entrySet().stream().map(Map.Entry::getValue).collect(Collectors.toList());

        System.out.println(list);
    }

    public static void main(String[] args) {
        new MapDemo().func();
    }

}
