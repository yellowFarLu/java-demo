package huangy.algorithm.leetcode;

import huangy.algorithm.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 判断是否有效的二叉搜索树，只要中序遍历是有序的即可
 * 注意判断是否有序的时候，前后节点不能相等，否则不满足左子树全部小于根节点的规则
 * @author huangy on 2020-04-04
 */
public class IsValidBST {

    private List<Integer> list = new ArrayList<>();

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }

        dfs(root);

        for (int i = 1; i < list.size(); i++) {
            if (list.get(i-1) >= list.get(i)) {
                return false;
            }
        }

        return true;
    }

    private void dfs(TreeNode root) {

        if (root == null) {
            return;
        }

        dfs(root.left);
        list.add(root.val);
        dfs(root.right);
    }

}
