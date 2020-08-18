package huangy.algorithm.leetcode;

import huangy.algorithm.leetcode.common.TreeNode;

/**
 * @author huangy on 2020-06-27
 */
public class SortedArrayToBST {

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length <= 0) {
            return null;
        }

        return createBST(nums, 0, nums.length - 1);
    }

    private TreeNode createBST(int[] nums, int left, int right) {

        if (left > right) {
            return null;
        }

        int middle = (left + right) / 2;
        TreeNode node = new TreeNode(nums[middle]);

        node.left = createBST(nums, left, middle - 1);
        node.right = createBST(nums, middle + 1, right);

        return node;
    }

}
