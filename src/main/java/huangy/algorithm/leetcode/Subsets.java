package huangy.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huangy on 2020-04-11
 */
public class Subsets {

    private List<List<Integer>> result = new ArrayList<>();

    private int[] nums;

    /**
     * 回溯法求解
     */
    public List<List<Integer>> subsets(int[] nums) {
        this.nums = nums;

        dfs(0, new ArrayList<>());

        return result;
    }

    /**
     * 回溯法
     */
    private void dfs(int t, List<Integer> currentList) {

        if (t == nums.length) {
            result.add(new ArrayList<>(currentList));
            return;
        }

        currentList.add(nums[t]);

        dfs(t+1, currentList);

        currentList.remove(Integer.valueOf(nums[t]));

        dfs(t+1, currentList);
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(
                new Subsets().subsets(nums));;
    }
}
