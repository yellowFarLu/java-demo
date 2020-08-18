package huangy.algorithm.leetcode;

/**
 * @author huangy on 2020-04-11
 */
public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {

        if (strs.length == 0) {
            return "";
        }

        int i = 0;

        StringBuilder sb = new StringBuilder();

        String oneStr = strs[0];

        while (true) {

            if (i >= oneStr.length()) {
                break;
            }

            char tem = oneStr.charAt(i);

            boolean tag = true;

            for (String str : strs) {

                if (i >= str.length()) {
                    tag = false;
                    break;
                }

                if (str.charAt(i) != tem) {
                    tag = false;
                    break;
                }
            }

            if (tag) {
                sb.append(tem);
            } else {
                break;
            }

            i++;
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String[] strings = {"aa","a"};

        System.out.println(
                new LongestCommonPrefix().longestCommonPrefix(strings));;
    }
}
