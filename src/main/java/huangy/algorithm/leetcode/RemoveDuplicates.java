package huangy.algorithm.leetcode;

/**
 * 删除排序数组中的重复项
 *
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
 *
 * @author huangy on 2020-04-06
 */
public class RemoveDuplicates {

    public int removeDuplicates(int[] nums) {

        int len = nums.length;

        for (int i = 0; i < len; i++) {

            // k表示有多少个连续相等的
            int k = 0;
            int m = i;
            while (m < (len - 1) && (nums[m] == nums[m + 1])) {
                k++;
                m++;
            }

            for (int j = i+1; j < (len - k); j++) {
                nums[j] = nums[j + k];
            }

            len = len - k;

        }

        return len;
    }

    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};

        int result = new RemoveDuplicates().removeDuplicates(nums);

        System.out.println(result);;
    }
}
