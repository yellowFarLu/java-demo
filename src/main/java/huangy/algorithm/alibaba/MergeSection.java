package huangy.algorithm.alibaba;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 合并区间
 * @author huangy on 2020-07-09
 */
public class MergeSection {

    /**
     * （1）排序
     * （2）从左到右遍历结果集，进行n-1次合并
     * （3）i<j，如果i个区间的右边大于j区间的左边，则进行合并
     */
    public int[][] merge(int[][] intervals) {

        if (intervals.length == 0) {
            return intervals;
        }

        int[][] result = new int[intervals.length][2];
        int index = 0;

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] < o2[0]) {
                    return -1;
                } else if (o1[0] > o2[0]) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });

        for (int i = 0; i < intervals.length; i++) {
            if (i == 0) {
                result[index][0] = intervals[i][0];
                result[index][1] = intervals[i][1];
            } else {
                if (result[index][1] >= intervals[i][0]) {
                    result[index][1] = Math.max(result[index][1], intervals[i][1]);
                } else {
                    index++;
                    result[index][0] = intervals[i][0];
                    result[index][1] = intervals[i][1];
                }
            }
        }

        // 拷贝出有效元素
        return Arrays.copyOf(result, index + 1);
    }
}
