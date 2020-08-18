package huangy.map;

import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * @author huangy on 2019-11-02
 */
public class LinkedHashMapDemo {

    public static void main(String[] args) {

        LinkedHashMap<Integer, Integer> linkedHashMap = new LinkedHashMap<>();

        for (int i = 10; i >= 0; i--) {
            linkedHashMap.put(i, i);
        }

        System.out.println(linkedHashMap);



        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int i = 10; i >= 0; i--) {
            hashMap.put(i, i);
        }

        System.out.println(hashMap);
    }

    private void accessOrderDemo() {

        LinkedHashMap<Integer, Integer> map =
                new LinkedHashMap<>(20, 0.75f, true);

        for (int i = 0; i < 10; i++) {
            map.put(i, i);
        }

        System.out.println(map);

        map.get(4);

        System.out.println(map);
    }

}
