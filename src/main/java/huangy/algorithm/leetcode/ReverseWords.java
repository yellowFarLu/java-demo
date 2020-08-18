package huangy.algorithm.leetcode;

/**
 * @author huangy on 2020-04-04
 */
public class ReverseWords {

    public String reverseWords(String s) {
        s = s.trim();

        String[] arr = s.split(" ");

        if (arr.length < 1) {
            return s;
        }

        int begin = 0;
        int end = arr.length - 1;
        String tem;

        while (begin < end) {

            if (begin > (arr.length - 1)) {
                break;
            }

            if (end < 0) {
                break;
            }

            tem = arr[begin];
            arr[begin] = arr[end];
            arr[end] = tem;

            begin++;
            end--;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            if (i == (arr.length - 1)) {
                sb.append(arr[i]);
            } else {
                if (!arr[i].equals("")) {
                    sb.append(arr[i] + " ");
                }
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new ReverseWords().reverseWords("a good   example"));
    }
}
