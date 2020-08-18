package huangy.algorithm.leetcode;

/**
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/
 * @author huangy on 2020-06-27
 */
public class MaxProfit2 {

    public int maxProfit(int[] prices) {
        int result = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i-1]) {
                result = result + (prices[i] - prices[i - 1]);
            }
        }

        return result;
    }

}
