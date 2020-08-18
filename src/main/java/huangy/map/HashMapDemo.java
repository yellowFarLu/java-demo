package huangy.map;

import java.util.HashMap;
import java.util.Map;

/**
 * @author huangy on 2019-11-02
 */
public class HashMapDemo {

    public static void main(String[] args) {

        /*
         * 假如初始容量是1000，那么数组大小是
         */
        int num = 1000;

        HashMap map = new HashMap<>(num);

        for (int i = 0; i < num; i++) {
            map.put(i, i);
        }
    }

}
