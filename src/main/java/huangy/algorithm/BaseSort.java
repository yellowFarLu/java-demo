package huangy.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * 基数排序
 * （1）从低位开始，每一位用桶排序
 * @author huangy on 2020-01-06
 */
public class BaseSort { 
    public static void baseSort(int[] arr) {

        // 计算出数字的最大位数
        int digit = getMaxDigit(arr);

        // 遍历每一位，依次进行桶排序
        int digitValue;
        for (int k = 1; k <= digit; k++) {

            List<Node> nodeList = new ArrayList<>(arr.length);
            int maxDigitValue = Integer.MIN_VALUE;

            for (int i = 0; i < arr.length; i++) {

                // 取出该数字，当前位的值，不够位则返回0
                digitValue = getDigitValue(arr[i], k);

                Node node = new Node();
                node.digitValue = digitValue;
                node.realValue = arr[i];

                nodeList.add(node);

                if (digitValue > maxDigitValue) {
                    maxDigitValue = digitValue;
                }
            }

            // 桶排序
            int[] countArr = new int[maxDigitValue + 1];

            for (Node node : nodeList) {
                countArr[node.digitValue]++;
            }

            int[] addressArr = new int[countArr.length];
            addressArr[0] = countArr[0];
            for (int j = 0; j < (addressArr.length - 1); j++) {
                addressArr[j + 1] = addressArr[j] + countArr[j + 1];
            }

            // 先存放到临时数组
            List<Node> temNodeList = new ArrayList<>(nodeList);
            int i = nodeList.size() - 1;

            /*
             * 这里一定要注意，从后往前遍历，那么才是稳定的桶排序算法
             * 因为addressArr存储的元素的下标，从后往前，对应下标逐个减少
             */
            while (i >= 0) {
                Node node = nodeList.get(i);
                temNodeList.set((addressArr[node.digitValue] - 1), node);
                addressArr[node.digitValue]--;
                i--;
            }

            // 更新arr数组
            for (int h = 0; h < arr.length; h++) {
                arr[h] = temNodeList.get(h).realValue;
            }

            System.out.print("按一位排序的结果：");
            for (i = 0; i < arr.length; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    }

    private static int getMaxDigit(int[] arr) {

        int digit = 0;
        int tem, temDigit;

        for (int i = 0; i < arr.length; i++) {
            tem = arr[i];
            temDigit = 0;

            while (tem != 0) {
                temDigit++;
                tem = tem / 10;
            }

            if (temDigit > digit) {
                digit = temDigit;
            }
        }

        return digit;
    }

    /**
     * 获取某一位的值
     * @param realValue 真正的值
     * @param k 第几位
     */
    private static int getDigitValue(int realValue, int k) {

        // 首先判断有没有这么多位，没有则返回0
        int tem = 1;
        int temK = k - 1;
        while (temK > 0) {
            tem = tem * 10;
            temK--;
        }
        if (realValue < tem) {
            return 0;
        }

        // 获取对应位数
        temK = k - 1;

        while (temK > 0) {

            realValue /= 10;

            temK--;
        }

        return realValue % 10;
    }

    private static class Node {

        /**
         * 当前位的值
         */
        public int digitValue;

        /**
         * 真真的值
         */
        public int realValue;
    }

    public static void main(String[] args) {

        int[] arr = {342, 58, 576, 356};

        baseSort(arr);

        System.out.print("最终结果:  ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
