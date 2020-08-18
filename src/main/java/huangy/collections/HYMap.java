package huangy.collections;

import java.util.*;

/**
 * @author huangy on 2019-04-14
 */
public class HYMap {

    public static void main(String[] args) {
        new HYMap().treeMapDemo();
    }

    private void hashMapDemo() {
        int size = 10000;

        HashMap<Integer, Integer> map = new HashMap<>(size);

        for (int i = 0; i < size; i++) {
            map.put(i, i);
        }

        System.out.println(map);
    }

    private void IdentityHashMapDemo() {
        Map<String, String> maps = new IdentityHashMap<>();
        maps.put("aa", "aa");
        maps.put("bb", "bb");
        maps.put("cc", "cc");
        maps.put("dd", "dd");
        maps.put("ee", "ee");

        for (Map.Entry entry : maps.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }

    private void treeMapDemo() {
        TreeMap<Integer, String> maps = new TreeMap<>();

        maps.put(0, "zero");
        maps.put(1, "one");
        maps.put(2, "two");
        maps.put(3, "three");
        maps.put(4, "four");
        maps.put(5, "five");
        maps.put(6, "six");
        maps.put(7, "seven");

        System.out.println(maps.ceilingEntry(1));
    }
}
