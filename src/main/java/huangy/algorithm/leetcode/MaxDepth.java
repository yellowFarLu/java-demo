package huangy.algorithm.leetcode;

import huangy.algorithm.leetcode.common.TreeNode;

/**
 * @author huangy on 2020-04-04
 */
public class MaxDepth {

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

}
