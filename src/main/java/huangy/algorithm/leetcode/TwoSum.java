package huangy.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author huangy on 2020-03-28
 */
public class TwoSum {

    public void func1(int[] num) {
        for (int i = 0; i < num.length; i++) {
            for (int j = i + 1; j < num.length; j++) {
                if (num[i] + num[j] == 0) {
                    // 满足条件
                }
            }
        }
    }

    public void func2(int[] num) {

        /*
         * key是当前数字所能匹配的数字，value是当前数字
         * 之所以这样子，是因为不知道所需要的数字在不在数组中
         */
        Map<Integer, Integer> hash = new HashMap<>();

        for (int i = 0; i < num.length; i++) {
            hash.put((0 - num[i]), num[i]);
        }

        for (int i = 0; i < num.length; i++) {
            Integer tem = hash.get(num[i]);
            if (tem != null) {
                // 满足条件
            }
        }
    }

    public void func3(int[] num) {

        Map<Integer, Integer> hash = new HashMap<>();

        for (int i = 0; i < num.length; i++) {
            Integer tem = hash.get(num[i]);

            if (tem != null) {
                // 有匹配的，满足条件

            } else {
                // 没有匹配的，把能够匹配的数字记录下来
                hash.put(0 - num[i], num[i]);
            }
        }

    }

    public static void main(String[] args) {


    }

}
