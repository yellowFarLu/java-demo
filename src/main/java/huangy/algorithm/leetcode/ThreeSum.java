package huangy.algorithm.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author huangy on 2020-03-28
 */
public class ThreeSum {

    public void func2(int[] nums) {

        /*
         * key表示当前数字，value表示当前数字所能匹配的另外两个数字
         */
        Map<Integer, List<Integer>> hash = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {

                int thrid = 0 - nums[i] - nums[j];
                List<Integer> list = new ArrayList<>();
                list.add(nums[i]);
                list.add(nums[j]);

                hash.put(thrid, list);
            }
        }

        for (int i = 0; i < nums.length; i++) {
            List<Integer> temList = hash.get(nums[i]);

            if (temList != null) {
                // 找到结果
            }
        }
    }

    public void func1(int[] nums) {

        for (int i = 0; i <= (nums.length - 3); i++) {
            for (int j = i + 1; j <= (nums.length - 2); j++) {
                for (int k = j + 1; k <= (nums.length - 1); k++) {

                    if ((nums[i] + nums[j] + nums[k]) == 0) {
                        // 满足条件
                    }
                }
            }
        }
    }

    public static void main(String[] args) {

    }

}
