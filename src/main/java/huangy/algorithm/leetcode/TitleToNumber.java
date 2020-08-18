package huangy.algorithm.leetcode;

/**
 * @author huangy on 2020-06-27
 */
public class TitleToNumber {

    public int titleToNumber(String s) {
        int result = 0;

        int pow = 1;

        for (int i = s.length() - 1; i >= 0; i--) {

            int charToInt = s.charAt(i) - 'A' + 1;

            result = result + (charToInt * pow);

            pow = pow * 26;
        }

        return result;
    }
}
