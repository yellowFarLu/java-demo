package huangy.algorithm.leetcode;

import huangy.algorithm.leetcode.common.ListNode;
import huangy.algorithm.leetcode.common.Tool;

/**
 * @author huangy on 2020-04-11
 */
public class RemoveNthFromEnd {

    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode pre = null, cur = head, p = head;

        int i = 0;
        while ((i < n) && (p != null)) {
            p = p.next;
            i++;
        }

        while (p != null) {
            cur = cur.next;
            p = p.next;

            if (cur == head.next) {
                pre = head;
            } else {
                if (pre != null) {
                    pre = pre.next;
                }
            }
        }

        if (pre != null) {
            pre.next = cur.next;
        } else {
            // 没有前驱指针，证明删除的是倒数第一个元素
            head = head.next;
        }

        return head;
    }

    public static void main(String[] args) {
        int[] nums = {1};
        Tool.printListNodes(
                new RemoveNthFromEnd().removeNthFromEnd(
                        Tool.getListFromArr(nums), 1));
    }
}
