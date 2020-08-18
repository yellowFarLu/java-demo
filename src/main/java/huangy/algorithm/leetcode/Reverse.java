package huangy.algorithm.leetcode;

import java.math.BigDecimal;

/**
 * 整数反转
 *
 * https://leetcode-cn.com/problems/reverse-integer/
 *
 * @author huangy on 2020-04-06
 */
public class Reverse {

    public int reverse(int x) {

        // 判断负数
        boolean isFu = false;

        if (x < 0) {

            x = x * -1;

            if (x < 0) {
                return 0;
            }

            isFu = true;
        }

        String str = String.valueOf(x);
        StringBuilder sb = new StringBuilder(str).reverse();

        BigDecimal bigDecimal = new BigDecimal(sb.toString());

        if (isFu) {
            bigDecimal = bigDecimal.multiply(new BigDecimal("-1"));
        }

        /*
         * BigDecimal比较大小，使用compareTo进行对比
         * a.compare(b) > 0   表示 a>b
         * a.compare(b) < 0   表示 a<b
         */
        if ((bigDecimal.compareTo(new BigDecimal(Integer.MAX_VALUE)) > 0) ||
                (bigDecimal.compareTo(new BigDecimal(Integer.MIN_VALUE)) < 0)) {
            return 0;
        } else {
            return bigDecimal.intValue();
        }
    }

    public static void main(String[] args) {
        System.out.println(new Reverse().reverse(-2147483648));;
    }
}
