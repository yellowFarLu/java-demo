package huangy.algorithm.leetcode;

import huangy.algorithm.leetcode.common.TreeNode;

/**
 * @author huangy on 2020-04-04
 */
public class InvertTree {

    public TreeNode invertTree(TreeNode root) {

        dfs(root);

        return root;
    }

    private void dfs(TreeNode root) {

        if (root == null) {
            return;
        }

        TreeNode tem = root.left;
        root.left = root.right;
        root.right = tem;

        dfs(root.left);
        dfs(root.right);
    }
}
