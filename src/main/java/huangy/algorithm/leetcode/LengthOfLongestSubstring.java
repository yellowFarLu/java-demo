package huangy.algorithm.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 无重复字符的最长子串
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 * @author huangy on 2020-04-06
 */
public class LengthOfLongestSubstring {

    /**
     * 使用滑动窗口进行计算
     */
    public int lengthOfLongestSubstring(String s) {
        if ((s == null) || s.isEmpty()) {
            return 0;
        }

        // set作为滑动窗口
        Set<Character> set = new HashSet<>();

        int i = 0, j = 0;

        int max = Integer.MIN_VALUE;

        while ((i < s.length()) && (j < s.length())) {

            if (!set.contains(s.charAt(j))) {

                // 如果当前也是符合条件的字符，则+1
                max = Math.max(max, j - i + 1);

                set.add(s.charAt(j));
                j++;

            } else {
                // 当前字符不符合条件，直接计算前面那截就好了，即j-i
                max = Math.max(max, j - i);

                // 整一个新的窗口，开始滑动
                set = new HashSet<>();
                i++;
                j = i;
                set.add(s.charAt(j));

                j++;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(
                new LengthOfLongestSubstring().lengthOfLongestSubstring(
                        "pwwkew"));;
    }
}
