package huangy.algorithm.alibaba;

import java.util.ArrayList;
import java.util.List;

/**
 * 粗心的小明在记IPv4地址时忘了加点，导致记不清原来的具体地址是哪个了，你能帮他分析出所有可能的结果吗？
 *
 * 输入: "25525511235"
 * 输出: ["255.255.11.235", "255.255.112.35"]
 *
 * 分析：
 * ipv4是3个"."隔开的字符串，并且数字一定在[0, 255]之间
 *
 * @author huangy on 2020-07-08
 */
public class Ipv4Address {

    private static final String MARGIN = ".";

    public List<String> printIpv4(String str) {

        List<String> result = new ArrayList<>();

        for (int one = 1; one < str.length(); one++) {
            for (int two = one + 1; two < str.length(); two++) {
                for (int three = two + 1; three < str.length(); three++) {
                    // 切割
                    String tem1 = str.substring(0, one);
                    String tem2 = str.substring(one, two);
                    String tem3 = str.substring(two, three);
                    String tem4 = str.substring(three, str.length());

                    // 加点
                    String tem = tem1 + MARGIN + tem2 + MARGIN + tem3 + MARGIN + tem4;

                    // 判断是否满足ipv4
                    if (isValidIpv4(tem1, tem2, tem3, tem4)) {
                        result.add(tem);
                    }
                }
            }
        }

        return result;
    }

    private boolean isValidIpv4(String tem1, String tem2, String tem3, String tem4) {
        return isIllegalNum(tem1) && isIllegalNum(tem2)
                && isIllegalNum(tem3) && isIllegalNum(tem4);
    }

    private boolean isIllegalNum(String temNum) {
        try {
            Integer num = Integer.parseInt(temNum);
            return (num >= 0) && (num <= 255);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Ipv4Address().printIpv4("25525511235"));
    }

}
