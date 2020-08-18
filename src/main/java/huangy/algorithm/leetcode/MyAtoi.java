package huangy.algorithm.leetcode;

import java.math.BigDecimal;

/**
 * @author huangy on 2020-04-04
 */
public class MyAtoi {

    private static final BigDecimal ZHENG_MAX = new BigDecimal(Integer.MAX_VALUE);

    private static final BigDecimal FU_MAX = new BigDecimal(Integer.MIN_VALUE);

    public int myAtoi(String str) {

        if (str == null) {
            return 0;
        }

        if (str.equals("-") || str.equals("+")) {
            return 0;
        }

        str = str.trim();

        if (str.equals(" ") || str.equals("")) {
            return 0;
        }

        char c = str.charAt(0);
        if (((c < '0') || (c > '9')) && ((c != '-') && (c != '+'))) {
            return 0;
        }

        if ((c == '+' || c == '-') && (str.length() > 2) &&
                (str.charAt(1) < '0' || str.charAt(1) > '9')) {
            return 0;
        }

        int endIndex = 0;
        while ((endIndex < str.length()) &&
                ((str.charAt(endIndex) >= '0')
                        && (str.charAt(endIndex) <= '9') || (str.charAt(endIndex) == '-' && endIndex == 0)
                || (str.charAt(endIndex) == '+'  && endIndex == 0))) {
            endIndex++;
        }

        String temStr = str.substring(0, endIndex);
        boolean tag = false;
        if (temStr.charAt(0) == '-') {
            temStr = temStr.substring(1, endIndex);
            tag = true;
        }

        BigDecimal tem = new BigDecimal(temStr);
        if (tag) {
            tem = tem.multiply(new BigDecimal(-1));
        }

        if (tem.compareTo(ZHENG_MAX) > 0) {
            return ZHENG_MAX.intValue();
        }

        if (tem.compareTo(FU_MAX) < 0) {
            return FU_MAX.intValue();
        }

        return tem.intValue();
    }

    public static void main(String[] args) {
        System.out.println(new MyAtoi().myAtoi("0-1"));;
    }
}
