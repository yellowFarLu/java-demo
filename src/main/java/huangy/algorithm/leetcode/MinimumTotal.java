package huangy.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huangy on 2020-04-06
 */
public class MinimumTotal {

    private int row;

    private int min;

    private List<List<Integer>> triangle;

    public int minimumTotal1(List<List<Integer>> triangle) {
        row = triangle.size();
        min = Integer.MAX_VALUE;
        this.triangle = triangle;

        dfs(0, 0, 0);

        return min;
    }

    /**
     * 动态规划
     *
     * 状态
     * dp[i][j] 表示走到i、j位置的最小值
     *
     * 状态方程
     * dp[i][j] = min(dp[i-1][j], dp[i-1][j-1])
     */
    public int minimumTotal(List<List<Integer>> triangle) {

        int row = triangle.size();
        this.triangle = triangle;

        int[][] dp = new int[row][getMaxCol(triangle)];

        dp[0][0] = triangle.get(0).get(0);

        for (int i = 1; i < row; i++) {

            int col = triangle.get(i).size();

            for (int j = 0; j < col; j++) {
                if ((j - 1) >= 0) {
                    // 注意三角形每一行最后一个元素的上一行同列是没有元素的
                    if (j == (col - 1)) {
                        dp[i][j] = dp[i-1][j-1] + getValue(i, j);
                    } else {
                        dp[i][j] = Math.min(dp[i-1][j], dp[i-1][j-1]) + getValue(i, j);
                    }

                } else {
                    dp[i][j] = dp[i-1][j] + getValue(i, j);
                }
            }
        }

        // 底部都是最短路径了，那么看那个底部元素的路径最短
        int min = Integer.MAX_VALUE;
        for (int j = 0; j < triangle.get(row - 1).size(); j++) {
            min = Math.min(min, dp[row - 1][j]);
        }
        return min;
    }

    private int getMaxCol(List<List<Integer>> triangle) {
        int max = 0;

        for (int i = 0; i < triangle.size(); i++) {
            max = Math.max(max, triangle.get(i).size());
        }

        return max;
    }

    /**
     * 暴力破解
     * @param i 当前位置i
     * @param j 当前位置j
     * @param currentSum 积累的总值
     */
    private void dfs(int i, int j, int currentSum) {

        if (i == row) {
            min = Math.min(min, currentSum);
            return;
        }

        if ((i < 0) || (i > row) || (j < 0) || (j >= triangle.get(i).size())) {
            return;
        }

        currentSum += getValue(i, j);

        // 往下走
        dfs(i+1, j, currentSum);

        // 往右下走
        dfs(i+1, j+1, currentSum);
    }

    private int getValue(int i, int j) {
        return triangle.get(i).get(j);
    }

    public static void main(String[] args) {
        int[][] arr = {{7},{-5,9},{6,5,2},{-8,-2,-7,3},{-2,6,-6,-1,4}};
        System.out.println(
                new MinimumTotal().minimumTotal(
                        getListFromArr(arr)));;
    }

    private static List<List<Integer>> getListFromArr(int[][] arr) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            List<Integer> tem = new ArrayList<>();
            for (int j = 0; j < arr[i].length; j++) {
                tem.add(arr[i][j]);
            }
            list.add(tem);
        }
        return list;
    }
}
