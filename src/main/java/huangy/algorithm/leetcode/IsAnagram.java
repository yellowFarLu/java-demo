package huangy.algorithm.leetcode;

import java.util.Arrays;

/**
 * @author huangy on 2020-06-27
 */
public class IsAnagram {

    public boolean isAnagram(String s, String t) {
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();

        Arrays.sort(sArr);
        Arrays.sort(tArr);

        String s1 = new String(sArr);
        String t1 = new String(tArr);

        return s1.equals(t1);
    }
}
