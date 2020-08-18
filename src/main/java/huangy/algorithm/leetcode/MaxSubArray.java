package huangy.algorithm.leetcode;


/**
 * @author huangy on 2020-04-12
 */
public class MaxSubArray {

    /**
     * 前面的累积和sum
     * 如果 sum + num[i] > num[i] ，则表示前面的子数组加上当前元素 比 直接从当前元素开始的子数组 总和 大，
     * 那么就加上nums[i]作为连续子数组，
     * 否则，从nums[i]开始计算新的子数组
     *
     * 这种思想：使用贪心算法，从较优的子数组中算出最优解，从而避免全排列出所有计算结果
     */
    public int maxSubArray(int[] nums) {

        int max = nums[0];

        int sum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (sum + nums[i] > nums[i]) {
                sum = sum + nums[i];
            } else {
                sum = nums[i];
            }

            max = Math.max(max, sum);
        }

        return max;
    }

    /**
     * 使用备忘录的方法
     */
    public int maxSubArra1(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }

        /*
         * map[i][j]表示[i,j]的总和
         */
        int[][] map = new int[nums.length][nums.length];
        map[0][0] = nums[0];

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {

                if ((j-1) < 0) {
                    map[i][j] = nums[j];
                } else {
                    map[i][j] = map[i][j-1] + nums[j];
                }

                if (map[i][j] > max) {
                    max = map[i][j];
                }
            }
        }

        return max;
    }

    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(
                new MaxSubArray().maxSubArray(nums));
    }
}
