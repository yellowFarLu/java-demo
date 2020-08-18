package huangy.algorithm.leetcode;

/**
 * @author huangy on 2020-06-27
 */
public class SingleNumber {

    public int singleNumber(int[] nums) {

        if (nums == null) {
            return 0;
        }

        if (nums.length == 0) {
            return nums[0];
        }

        int result = 0;

        for (int i = 0; i < nums.length; i++) {
            result = result ^ nums[i];
        }

        return result;
    }

}
