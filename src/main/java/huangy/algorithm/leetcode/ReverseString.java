package huangy.algorithm.leetcode;

/**
 * @author huangy on 2020-04-04
 */
public class ReverseString {

    public void reverseString(char[] s) {
        int begin = 0;
        int end = s.length - 1;
        char tem;

        while (begin < end) {

            if (begin >= s.length) {
                break;
            }

            if (end < 0) {
                break;
            }

            tem = s[begin];
            s[begin] = s[end];
            s[end] = tem;

            begin++;
            end--;
        }
    }

    public static void main(String[] args) {
        char[] arr = {'h','e','l','l','o'};
        new ReverseString().reverseString(arr);
        System.out.println(new String(arr));
    }
}
