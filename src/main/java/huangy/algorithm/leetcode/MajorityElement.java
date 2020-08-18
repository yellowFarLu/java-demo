package huangy.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author huangy on 2020-03-28
 */
public class MajorityElement {

    public int majorityElement(int[] nums) {

        Map<Integer, Integer> countMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (countMap.containsKey(nums[i])) {
                int count = countMap.get(nums[i]);
                count = count + 1;
                countMap.put(nums[i], count);
            } else {
                countMap.put(nums[i], 1);
            }
        }

        int max = -1;
        int maxCount = -1;
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                max = entry.getKey();
            }
        }

        return max;
    }

    public static void main(String[] args) {
        int[] num = {3,2,3};
        System.out.println(
                new MajorityElement().majorityElement(num));;
    }

}
