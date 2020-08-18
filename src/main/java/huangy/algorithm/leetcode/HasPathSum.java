package huangy.algorithm.leetcode;

import huangy.algorithm.leetcode.common.TreeNode;

/**
 * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * @author huangy on 2020-04-04
 */
public class HasPathSum {

    private int TARGET;

    private boolean tag = false;

    public boolean hasPathSum(TreeNode root, int sum) {

        if (root == null) {
            return false;
        }

        TARGET = sum;

        dfs(root, 0);

        return tag;
    }

    private void dfs(TreeNode root, int currentSum) {

        // 当前节点为空，则直接返回
        if (root == null) {
            return;
        }

        // 增加当前节点的权值
        currentSum = root.val + currentSum;

        // 如果是叶子节点，那么判断下权值总和是否满足了
        if ((root.left == null) && (root.right == null)) {
            if (currentSum == TARGET) {
                tag = true;
            }
        }

        // 非叶子节点继续遍历左子树、右子树
        dfs(root.left, currentSum);
        dfs(root.right, currentSum);
    }
}
