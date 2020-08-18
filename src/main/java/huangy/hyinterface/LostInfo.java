package huangy.hyinterface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author huangy on 2019-04-06
 */
public class LostInfo {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        System.out.println(Arrays.asList(list.getClass().getTypeParameters()));

        List ar = new ArrayList();
        ar.add(1);
        ar.add("sda");

    }

}
