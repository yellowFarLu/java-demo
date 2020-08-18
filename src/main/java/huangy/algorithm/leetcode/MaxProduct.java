package huangy.algorithm.leetcode;

/**
 * @author huangy on 2020-04-05
 */
public class MaxProduct {

    /**
     * 动态规划
     *
     * 分析：
     * 当前元素的最大乘积，那么前面一个元素肯定也是该位置上的最大乘积，存在最优子结构，可以使用动态规划。
     * （后效性使用dpMin来解决）
     * 如果没有负数的情况，很简单，直接比较乘积最大的
     * 但是存在负数，前面的一个很大的负数乘积，跟后面一个负数相乘，就会得到一个很大的乘积，
     * 因此，这种很大的负数也要保存下来。
     *
     * 状态：
     * dpMax[i] 表示以i元素结尾的子序列的最大乘积
     * dpMin[i] 表示以i元素结尾的子序列的最小乘积
     *
     * 状态转移方程：
     */
    public int maxProduct(int[] nums) {
        if ((nums == null) || (nums.length == 0)) {
            return 0;
        }

        // 1...n表示nums的n个元素
        int[] dpMax = new int[nums.length + 1];
        int[] dpMin = new int[nums.length + 1];

        // 0这个位置是预设的起始数字
        dpMax[0] = dpMin[0] = 1;

        int max = Integer.MIN_VALUE;

        for (int i = 1; i <= nums.length; i++) {

            // 先判断前面一个元素的最大值、最小值要不换位置
            if (nums[i - 1] < 0) {
                // 如果前面那个元素（即nums[i-1]）是负数，那么包含i-1这个元素子序列的最大值、最小值要换位置
                int tem = dpMax[i - 1];
                dpMax[i - 1] = dpMin[i - 1];
                dpMin[i -1] = tem;
            }

            /*
             * 由dpMax[i-1]和nums[i-1]推出当前的dpMax[i]
             * 由于nums[i-1]是负数的情况下，dpMax[i-1]和dpMin[i-1]交换了，
             * 那么dpMax[i-1]就只能在nums[i-1]、dpMax[i-1]*nums[i-1]之前产生。
             *
             * dpMin同理。
             */
            dpMax[i] = Math.max(nums[i-1], dpMax[i-1]*nums[i-1]);

            dpMin[i] = Math.min(nums[i-1], dpMin[i-1]*nums[i-1]);

            // 由于dpMax计算的是"表示以i元素结尾的子序列的最大乘积"，是局部的，所以要计算出全局的
            max = Math.max(max, dpMax[i]);
        }

        return max;
    }

    /**
     * 暴力，求出每一种子数组，求最大的乘积
     */
    public int maxProduct1(int[] nums) {

        if (nums.length == 1) {
            return nums[0];
        }

        int max = Integer.MIN_VALUE;

        for (int iBegin = 0; iBegin < nums.length; iBegin++) {

            for (int jEnd = iBegin; jEnd < nums.length; jEnd++) {

                int tem = 1;
                for (int k = iBegin; k <= jEnd; k++) {
                    tem = tem * nums[k];
                }

                max = Math.max(max, tem);
            }
        }

        return (max == Integer.MIN_VALUE ? 0 : max);
    }

    public static void main(String[] args) {
        int[] arr = {2,3,-1,4};
        System.out.println(new MaxProduct().maxProduct(arr));;
    }
}
