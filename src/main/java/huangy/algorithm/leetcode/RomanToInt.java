package huangy.algorithm.leetcode;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 罗马数字转整数
 * https://leetcode-cn.com/problems/roman-to-integer/
 * @author huangy on 2020-04-06
 */
public class RomanToInt {

    private static final Map<String, Integer> convertMap = new LinkedHashMap<>();

    static  {
        convertMap.put("IV", 4);
        convertMap.put("IX", 9);
        convertMap.put("XL", 40);
        convertMap.put("XC", 90);
        convertMap.put("CD", 400);
        convertMap.put("CM", 900);

        convertMap.put("I", 1);
        convertMap.put("V", 5);
        convertMap.put("X", 10);
        convertMap.put("L", 50);
        convertMap.put("C", 100);
        convertMap.put("D", 500);
        convertMap.put("M", 1000);
    }

    public int romanToInt(String s) {

        int sum = 0;

        while (!s.isEmpty()) {

            int value = 0;
            String pre = "";

            for (Map.Entry<String, Integer> entry : convertMap.entrySet()) {
                if (s.startsWith(entry.getKey())) {
                    value = entry.getValue();
                    pre = entry.getKey();
                    break;
                }
            }

            if (value == 0) {
                break;
            }

            sum += value;

            s = s.substring(pre.length());
        }

        return sum;
    }

    public static void main(String[] args) {
        System.out.println(
                new RomanToInt().romanToInt("III"));;
    }
}
