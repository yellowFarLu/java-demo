package huangy.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huangy on 2020-06-27
 */
public class YangHuiSanJiao {

    public List<List<Integer>> generate(int numRows) {

        if (numRows == 0) {
            return new ArrayList<>();
        }

        int[][] nums = new int[numRows][numRows];
        nums[0][0] = 1;

        for (int i = 1; i < numRows; i++) {
            for (int j = 0; j < numRows; j++) {

                int one = 0, two = 0;

                // 上方的数
                one = nums[i-1][j];

                // 左上方的数
                if ((j - 1) >= 0) {
                    two = nums[i-1][j-1];
                }

                nums[i][j] = one + two;
            }
        }

        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            List<Integer> tem = new ArrayList<>();
            for (int j = 0; j < numRows; j++) {
                if (nums[i][j] != 0) {
                    tem.add(nums[i][j]);
                }
            }
            result.add(tem);
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(
                new YangHuiSanJiao().generate(5));;
    }
}
