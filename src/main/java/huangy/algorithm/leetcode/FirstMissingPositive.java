package huangy.algorithm.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author huangy on 2020-03-29
 */
public class FirstMissingPositive {

    public int firstMissingPositive(int[] nums) {
        if (nums.length == 0) {
            return 1;
        }

        // 用set快速定位是否在数组中
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        for (int i = 1; i <= (nums.length + 1); i++) {
            if (!set.contains(i)) {
                return i;
            }
        }

        return 1;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,0};
        System.out.println(new FirstMissingPositive().firstMissingPositive(nums));;
    }
}
