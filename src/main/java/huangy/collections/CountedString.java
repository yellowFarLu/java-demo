package huangy.collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author huangy on 2019-04-14
 */
public class CountedString {

    private static List<String> created =
            new ArrayList<>();

    private String s;

    private Integer id = 0;

    public CountedString(String str) {
        this.s = str;
        created.add(str);

        for (String s2 : created) {
            if (s2.equals(s)) {
                id++;
            }
        }
    }

    @Override
    public int hashCode() {
        // 给int变量赋予某个非零常量值
        int result = 17;

        // 为对象内每个有意义的域f(即每个可以做euqal()操作的域)计算出一个int散列码c
        // 合并计算得到的散列码  result = result*37 + c
        result = 37 * result + s.hashCode();
        result = 37 * result + id.hashCode();

        return result;
    }

    @Override
    public String toString() {
        return "CountedString{" +
                "s='" + s + '\'' +
                ", id=" + id +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof CountedString) {
            CountedString other = (CountedString)obj;

            return this.s.equals(other.s) && this.id.equals(other.id);
        }

        return false;
    }

    public static void main(String[] args) {
        Map<CountedString, Integer> map = new HashMap<>();

        CountedString[] cs = new CountedString[5];
        for (int i = 0; i < cs.length; i++) {
            cs[i] = new CountedString("hi");
            map.put(cs[i], i);
        }

        System.out.println(map);

        for (CountedString countedString : cs) {
            System.out.println(countedString);
            System.out.println(map.get(countedString));
        }
    }
}
