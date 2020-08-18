package huangy.algorithm.leetcode;

/**
 * @author huangy on 2020-04-06
 */
public class LongestPalindrome {

    /**
     * 动态规划
     *
     * dp[i][j] 表示i到j的子串是否回文
     *
     * dp[i][j] = (s[i] == s[j]) && dp[i+1][j-1]
     */
    public String longestPalindrome(String s) {

        if ((s == null) || (s.length() < 2)) {
            return s;
        }

        boolean[][] dp = new boolean[s.length()][s.length()];

        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
        }

        // 如意初始最大长度是1，因为单个字符自身也可以是回文子串
        int maxLen = 1;
        int start = 0;

        /*
         * 只计算上三角。 下面用到了i+1，计算上三角不会越界
         */
        for (int j = 1; j < s.length(); j++) {
            for (int i = 0; i < j; i++) {

                if (s.charAt(i) == s.charAt(j)) {

                    // 1个字符、2个字符、3个字符  这3种情况的子串，两边字符相等，那么直接判断为回文
                    if ((j - i) < 3) {
                        dp[i][j] = true;

                    } else {
                        dp[i][j] = dp[i+1][j-1];
                    }

                } else {
                    dp[i][j] = false;
                }

                if (dp[i][j]) {

                    int curLen = j - i + 1;

                    if (curLen > maxLen) {
                        maxLen = curLen;
                        start = i;
                    }
                }
            }
        }

        return s.substring(start, start + maxLen);
    }

    /**
     * 暴力破解
     */
    public String longestPalindrome1(String s) {

        if ((s == null) || s.isEmpty()) {
            return s;
        }

        String maxS = "";
        String temS;

        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {

                temS = s.substring(i, j);

                if (isPalindrome(temS) && (temS.length() > maxS.length())) {
                    maxS = temS;
                }
            }
        }

        return maxS;
    }

    private boolean isPalindrome(String s) {

        if (s.isEmpty()) {
            return true;
        }

        if (s.length() == 1) {
            return true;
        }

        String pre;

        if (s.length() % 2 == 0) {
            pre = s.substring(0, s.length() / 2);
            String reversePre = new StringBuilder(pre).reverse().toString();
            return reversePre.equals(
                    s.substring(s.length() / 2));

        } else {
            pre = s.substring(0, s.length() / 2);
            String reversePre = new StringBuilder(pre).reverse().toString();
            return reversePre.equals(
                    s.substring(s.length() / 2 + 1));
        }
    }

    public static void main(String[] args) {
        System.out.println(
                new LongestPalindrome().longestPalindrome("ac"));
    }

}
