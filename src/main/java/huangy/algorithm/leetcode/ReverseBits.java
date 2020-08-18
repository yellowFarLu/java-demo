package huangy.algorithm.leetcode;


/**
 * @author huangy on 2020-07-26
 */
public class ReverseBits {

    /**
     * 二进制位转换的思想
     */
    public int reverseBits(int n) {
        int sum = 0;

        int bizSize = 31;

        while (n != 0) {

            // 无符号数的情况下，使用与运算得出最后一位bit
            int bit = n & 1;

            // 利用右移把当前bit去掉
            n = n >>> 1;

            // 把bit放到反转后的位置上面，得到对应的10进制数
            int tem = bit << bizSize;

            // 将bit反转后的10进制数加到sum中
            sum = sum + tem;

            bizSize--;
        }

        return sum;
    }

    public static void main(String[] args) {
        System.out.println(
                new ReverseBits().reverseBits(43261596));;
    }

}
