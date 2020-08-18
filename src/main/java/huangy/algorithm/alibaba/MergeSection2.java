package huangy.algorithm.alibaba;

/**
 * 请合并所有重叠的区间值，输出最简表示方式。
 *
 * 输入均为正整数区间且单个区间最小值一定不等于最大值，每个区间使用;分隔，区间最小值和最大值使用-分隔。
 *
 * 示例如下：
 *
 * 输入：1-3;2-6;8-15;9-10;
 * 输出：1-6;8-15
 * @author huangy on 2020-07-09
 */
public class MergeSection2 {

    /**
     * （1）排序
     * （2）逐个放入（或者合并）到结果集中
     */
    public void optimize(String input) {

        String[] arr = input.split(";");
        int[][] interval = new int[arr.length][2];

        for (int i = 0; i < arr.length; i++) {
            String[] tem = arr[i].split("-");
            interval[i][0] = Integer.parseInt(tem[0]);
            interval[i][1] = Integer.parseInt(tem[1]);
        }

        int[][] result = new int[interval.length][2];
        int index = 0;

        for (int i = 0; i < interval.length; i++) {
            if (i == 0) {
                result[index][0] = interval[i][0];
                result[index][1] = interval[i][1];
            } else {
                if (result[index][1] >= interval[i][0]) {
                    result[index][1] = Math.max(result[index][1], interval[i][1]);
                } else {
                    index++;
                    result[index][0] = interval[i][0];
                    result[index][1] = interval[i][1];
                }
            }
        }

        int end = index + 1;
        for (int i = 0; i < end; i++) {
            if (i != (end - 1)) {
                System.out.print(result[i][0] + "-" + result[i][1] + ";");
            } else {
                System.out.print(result[i][0] + "-" + result[i][1]);
            }
        }
    }

    public static void main(String[] args) {
        new MergeSection2().optimize("1-3;2-6;8-15;9-10;");
    }
}
