package huangy.concurrent;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author huangy on 2020-04-09
 */
public class ConcurrentHashMapDemo {

    public static void main(String[] args) throws Exception {
        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();

        for (int i = 0; i < 10; i++) {
            map.putIfAbsent("1", i);
        }

        System.gc();

        Thread.sleep(10000000);
    }

}
