package huangy.algorithm.leetcode;

import huangy.algorithm.leetcode.common.Tool;

import java.math.BigDecimal;

/**
 * @author huangy on 2020-04-11
 */
public class PlusOne {

    public int[] plusOne(int[] digits) {
        BigDecimal num = new BigDecimal(0);
        BigDecimal ten = new BigDecimal(1);

        for (int i = digits.length - 1; i >= 0; i--) {

            num = num.add(
                    new BigDecimal(digits[i]).multiply(ten));

            ten = ten.multiply(new BigDecimal(10));
        }

        num = num.add(new BigDecimal(1));

        int[] newNums = new int[String.valueOf(num).length()];

        int j = newNums.length - 1;

        while (j >= 0) {

            BigDecimal tem = num.divideAndRemainder(new BigDecimal(10))[1];

            newNums[j] = tem.intValue();

            num = num.divide(new BigDecimal(10), BigDecimal.ROUND_DOWN);

            j--;
        }

        return newNums;
    }

    public static void main(String[] args) {
        int[] nums = {9,8,7,6,5,4,3,2,1,0};
        Tool.printfArray(new PlusOne().plusOne(nums));
    }
}
