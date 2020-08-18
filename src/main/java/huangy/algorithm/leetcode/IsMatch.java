package huangy.algorithm.leetcode;

/**
 * 正则表达式匹配
 * 如果模式串第二个字符是'*'，那么第一个字符可以为0个或者多个。
 *     a、第一个字符是0个，则省略掉前面2个字符，从第3个字符开始匹配
 *     b、第一个字符是1....n个，如果主串第一个字符和*号前的字符相等，则每次剪切掉主串第一个字符，然后继续匹配
 * 如果模式串第二个字符不是'*'，则直接匹配当前字符是否相等，不相等返回false。相等则进行下一个字符的匹配
 * @author huangy on 2020-04-05
 */
public class IsMatch {

    public boolean isMatch(String s, String p) {

        if (s.isEmpty()) {

            if (p.isEmpty()) {
                // 主串是空串，并且模式串也是空串，这种情况是相等的
                return true;
            } else {
                // 主串是空串，模式串只有两个字符，并且第二个是*
                if ((p.length() == 2) && (p.charAt(1) == '*')) {
                    return true;
                }
            }
        }

        // .*表示可以匹配任意个 任意字符，所以一定能够全匹配
        if (".*".equals(p)) {
            return true;
        }

        // 主串不为空，但是模式串是空的，肯定不匹配
        if (p.isEmpty()) {
            return false;
        }

        // *单独出现，不合法
        if ((p.length() == 1) && p.charAt(0) == '*') {
            return false;
        }

        if (p.length() == 1) {

            if (s.length() == 1) {
                return (checkEuqals(s.charAt(0), p.charAt(0)));
            } else {
                // 模式串只有1个（肯定不包含*），那么主串有多个，肯定是不匹配的
                return false;
            }

        } else {
            char twoChar = p.charAt(1);

            if (twoChar == '*') {

                // *为0个首字符的时候
                boolean zeroMatch = isMatch(s, p.substring(2));

                if (!zeroMatch) {

                    // *为多个首字符的时候
                    if (!s.isEmpty() && checkEuqals(s.charAt(0), p.charAt(0))) {
                        return isMatch(s.substring(1), p);

                    } else {
                        return false;
                    }

                } else {
                    return true;
                }

            } else {
                if (!s.isEmpty() && checkEuqals(s.charAt(0), p.charAt(0))) {
                    // 当前第一个字符相等，匹配下一个字符
                    return isMatch(s.substring(1), p.substring(1));
                } else {
                    // 第一个字符都不相等了，直接返回
                    return false;
                }
            }
        }
    }

    // 检查两个字符是否相等
    private boolean checkEuqals(char sC, char pC) {
        return (sC == pC) || (pC == '.');
    }

    public static void main(String[] args) {
        System.out.println(
                new IsMatch().isMatch("ab", ".*c"));;
    }
}
