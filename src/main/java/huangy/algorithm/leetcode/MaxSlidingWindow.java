package huangy.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 滑动窗口最大值
 * @author huangy on 2020-04-04
 */
public class MaxSlidingWindow {

    public int[] maxSlidingWindow(int[] nums, int k) {

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i <= (nums.length - k); i++) {

            int max = Integer.MIN_VALUE;

            for (int begin = i, end = i + (k - 1); begin <= end; begin++) {
                if (nums[begin] > max) {
                    max = nums[begin];
                }
            }
            result.add(max);
        }

        int[] arr = new int[result.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = result.get(i);
        }

        return arr;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int[] result =
                new MaxSlidingWindow().maxSlidingWindow(nums, 3);

        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }
}
