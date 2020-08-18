package huangy.algorithm.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author huangy on 2020-07-26
 */
public class IsHappy {

    public boolean isHappy(int n) {

        int p = n;
        List<Integer> list;

        // 用set来判断是否存在循环
        Set<Integer> set = new HashSet<>();

        while (true) {

            list = getWei(p);

            p = getSum(list);

            if (p == 1) {
                return true;
            }

            if (set.contains(p)) {
                // 如果set里面存在这个数，说明之前计算过这个数了，因此存在循环，直接返回false
                return false;
            } else {
                set.add(p);
            }
        }
    }

    private Integer getSum(List<Integer> list) {
        int sum = 0;

        for (Integer tem : list) {
            sum = sum + tem * tem;
        }

        return sum;
    }

    private List<Integer> getWei(int p) {
        List<Integer> temList = new ArrayList<>();

        while (p != 0) {
            int tem = p % 10;
            temList.add(tem);
            p = p / 10;
        }

        return temList;
    }

    public static void main(String[] args) {
        System.out.println(
                new IsHappy().isHappy(7));;
    }
}
