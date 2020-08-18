package huangy.algorithm.leetcode;

/**
 * @author huangy on 2020-04-05
 */
public class MaxProfit {

    public int maxProfit(int[] prices) {

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[i] <= prices[j]) {
                    max = Math.max(prices[j] - prices[i], max);
                }
            }
        }

        return (max == Integer.MIN_VALUE ? 0 : max);
    }

}
