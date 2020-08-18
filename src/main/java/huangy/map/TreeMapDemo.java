package huangy.map;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author huangy on 2019-11-02
 */
public class TreeMapDemo {

    public static void main(String[] args) {
        Map<Integer, Integer> map = new TreeMap<>();

        for (int i = 10; i >= 0; i--) {
            map.put(i, i);
        }

        System.out.println(map);
    }

}
