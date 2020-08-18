package huangy.algorithm.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 最长有效括号
 * 方法一：枚举出每一种子串，判断是否满足匹配规则，满足的子串中取最大长度
 * 方法二：动态规划
 * @author huangy on 2020-03-29
 */
public class LongestValidParentheses {

    /**
     * 方法二：动态规划
     * 定义状态数组，dp[i]表示字符串下标是i的时候，当前最长有效符号
     * 如果s[i]='('，那么当前dp[i]肯定等于0，因为没有最后一个（即i的下标）'('没有匹配
     * 如果s[i]=')'，并且s[i-1]='('，那么字符串形如"....()"，那么dp[i] = dp[i - 2] + 2;
     * 如果s[i]=')'，并且s[i-1]=')'，那么字符串形如"....))"，那么：
     *         如果在dp[i-1]的字符是'('，则dp[i] = dp[i-1] + 2
     *         但是这样子就够了吗？
     *         如果dp[i-1]的字符是'('，那么该'('之前也可能有一段有效括号字符串，因此也要加上这段有效字符串，
     *         所以这种情况的表达式为： dp[i] = dp[i-1] + 2 + dp[i - dp[i-1] - 2];
     */
    public int longestValidParentheses(String s) {

        if ((s == null) || s.length() < 2) {
            return 0;
        }

        int[] dp = new int[s.length()];

        // 1个字符组成的子串，肯定有效符号为0
        dp[0] = 0;

        // 因为到i为止子串，有可能是'('，从而有效长度变成了0，所以要在求解的过程中计算最大值
        int max = 0;

        for (int i = 1; i < dp.length; i++) {

            if (s.charAt(i) == ')') {

                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i - 2 >= 0 ? dp[i - 2] : 0) + 2;

                } else {
                    if ((i - dp[i - 1] - 1 >= 0) && s.charAt(i - dp[i - 1] - 1) == '(') {
                        dp[i] = dp[i-1] + 2 +
                                (i - dp[i - 1] -2 >= 0 ? dp[i - dp[i - 1] - 2] : 0);
                    }
                }

                max = Math.max(max, dp[i]);
            }
        }

        return max;
    }

    /**
     * 方法一：
     * 枚举出每一种子串，判断是否满足匹配规则，满足的子串中取最大长度
     */
    public int longestValidParentheses1(String s) {

        if (s == null || s.length() < 2) {
            return 0;
        }

        int max = 0;

        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 2; j <= s.length(); j += 2) {
                // 这里j之所以每次加2，是因为子串只有是偶数的情况下，才是满足匹配规则的

                if (isValid(s.substring(i, j))) {
                    max = Math.max(max, j - i);
                }

            }
        }

        return max;
    }

    private boolean isValid(String s) {

        Deque<Character> deque = new ArrayDeque<>();

        char c;

        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);

            if (c == '(') {
                deque.push(c);

            } else {

                if (!deque.isEmpty()) {

                    char tem = deque.pop();
                    if (tem != '(') {
                        return false;
                    }

                } else {
                    return false;
                }
            }
        }

        return deque.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(
                new LongestValidParentheses().
                        longestValidParentheses(")()())"));;
    }
}
