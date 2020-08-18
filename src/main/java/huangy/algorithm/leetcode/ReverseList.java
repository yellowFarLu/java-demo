package huangy.algorithm.leetcode;

import huangy.algorithm.leetcode.common.ListNode;

/**
 * 反转链表
 * https://leetcode-cn.com/problems/reverse-linked-list/
 * @author huangy on 2020-04-06
 */
public class ReverseList {

    /**
     * 头插法反转链表
     */
    public ListNode reverseList(ListNode head) {
        ListNode newHead = null, p;

        p = head;
        ListNode tem;

        while (p != null) {
            tem = new ListNode(p.val);

            if (newHead == null) {
                newHead = tem;
            } else {
                tem.next = newHead;
                newHead = tem;
            }

            p = p.next;
        }

        return newHead;
    }

}
