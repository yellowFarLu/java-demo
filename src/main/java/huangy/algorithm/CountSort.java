package huangy.algorithm;

/**
 * @author huangy on 2020-01-06
 */
public class CountSort {

    /**
     * 计数排序算法的实现
     * （1）计算最大值，创建桶数组
     * （2）统计每个桶的元素个数
     * （3）计算元素位置（小于当前位置的元素个数）
     * @param arr 待排序的数组
     */
    public static void countSort(int[] arr) {

        // 计算最大值
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        // 创建桶
        int[] slots = new int[max + 1];

        // 桶计数
        for (int i = 0; i < arr.length; i++) {
            slots[arr[i]]++;
        }

        // 计算元素位置
        int[] addressCount = new int[slots.length];
        addressCount[0] = slots[0];
        for (int i = 0; i < max; i++) {
            addressCount[i + 1] = addressCount[i] + slots[i + 1];
        }

        // 把元素按顺序先存放到临时数组中
        int[] tem = new int[arr.length];
        for (int i = arr.length - 1; i >= 0 ; i--) {

            tem[addressCount[arr[i]] - 1] = arr[i];

            addressCount[arr[i]]--;
        }

        // 数组的值赋值回去
        for (int i = 0; i < tem.length; i++) {
            arr[i] = tem[i];
        }
    }

    public static void main(String[] args) {

        int[] arr = {342, 58, 576, 356};

        countSort(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

}
