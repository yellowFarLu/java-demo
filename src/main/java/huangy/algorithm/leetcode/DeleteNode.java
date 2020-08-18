package huangy.algorithm.leetcode;

import huangy.algorithm.leetcode.common.ListNode;

/**
 * 删除节点
 * https://leetcode-cn.com/problems/delete-node-in-a-linked-list/
 *
 * @author huangy on 2020-06-27
 */
public class DeleteNode {

    public void deleteNode(ListNode node) {
        if (node == null) {
            return;
        }

        node.val = node.next.val;
        node.next = node.next.next;
    }
}
