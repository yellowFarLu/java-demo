package huangy.algorithm.leetcode;

import java.util.Arrays;

/**
 * @author huangy on 2020-04-05
 */
public class CoinChange {

    /**
     * 动态规划
     * （1）状态: dp[i]表示达到价值i的话，最少需要多少个硬币
     *
     * （2）递推公式
     * dp[i] = dp[i - c] + 1;
     * c可以是任意一个硬币，所以要迭代所有硬币
     *
     * @param coins 硬币的数组
     * @param amount 金额
     * @return 所需硬币的最少数量
     */
    public int coinChange(int[] coins, int amount) {

        if (amount == 0) {
            return 0;
        }

        int[] dp = new int[amount + 1];

        // 注意这里默认值要填充一个比较大的值，保证可以选择更加小的值。
        // 但是不能填充Integer.MAX_VALUE，因为后面有+1的操作，会导致变成负数
        int max = amount + 1;
        Arrays.fill(dp, max);

        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {

                int remain = i - coins[j];

                if (remain >= 0) {
                    dp[i] = Math.min(dp[remain] + 1, dp[i]);
                }
            }
        }

        if (dp[amount] == max) {
            // 等于默认值，则
            return -1;
        } else {
            return dp[amount];
        }
    }

    public static void main(String[] args) {
        int[] coins = {2};
        System.out.println(
                new CoinChange().coinChange(coins, 3));;
    }
}
