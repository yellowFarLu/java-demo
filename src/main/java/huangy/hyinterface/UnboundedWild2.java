package huangy.hyinterface;

import java.util.HashMap;
import java.util.Map;

/**
 * @author huangy on 2019-04-06
 */
public class UnboundedWild2 {

    static Map map1;

    static Map<?, ?> map2;

    static Map<String, ?> map3;

    static void assgin1(Map map) {
        map1 = map;
    }

    static void assgin2(Map<?, ?> map) {
        map2 = map;
    }

    static void assgin3(Map<String, ?> map) {
        map3 = map;
    }

    public static void main(String[] args) {
        assgin1(new HashMap());
        assgin2(new HashMap());
        assgin3(new HashMap());

        assgin1(new HashMap<String, Integer>());
        assgin2(new HashMap<String, Integer>());
        assgin3(new HashMap<String, Integer>());
    }
}
