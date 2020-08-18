package huangy.hyinterface;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huangy on 2019-04-06
 */
public class UnboundedWild {

    static List list1;

    static List<?> list2;

    static List<? extends Object> list3;

    static void assgin1(List list) {
        list1 = list;
        list2 = list;
        list3 = list;
    }

    static void assgin2(List<?> list) {
        list1 = list;
        list2 = list;
        list3 = list;
    }

    static void assgin3(List<? extends Object> list) {
        list1 = list;
        list2 = list;
        list3 = list;
    }

    public static void main(String[] args) {
        assgin1(new ArrayList());
        assgin2(new ArrayList<>());
        assgin3(new ArrayList<>());


        assgin1(new ArrayList<String>());
        assgin2(new ArrayList<String>());
        assgin3(new ArrayList<String>());


        List<?> wildList = new ArrayList();
        wildList = new ArrayList<String>();
        assgin1(wildList);
        assgin2(wildList);
        assgin3(wildList);
    }
}
