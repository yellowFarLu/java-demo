package huangy.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huangy on 2020-06-27
 */
public class MoveZeroes {

    public void moveZeroes(int[] nums) {

        // 记录值为0的元素的位置
        List<Integer> zeroIndex = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeroIndex.add(i);
            } else {
                if (!zeroIndex.isEmpty()) {
                    int index = zeroIndex.remove(0);
                    nums[index] = nums[i];
                    nums[i] = 0;
                    zeroIndex.add(i);
                }
            }
        }
    }

}
