package huangy.algorithm.leetcode;

import huangy.algorithm.leetcode.common.ListNode;

/**
 * @author huangy on 2020-06-27
 */
public class MergeTwoLists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }

        ListNode p1 = l1, p2 = l2;

        ListNode head = null, tail = null;

        while ((p1 != null) && (p2 != null)) {

            if (p1.val <= p2.val) {

                if (head == null) {
                    head = tail = new ListNode(p1.val);
                } else {
                    tail.next = new ListNode(p1.val);
                    tail = tail.next;
                }

                p1 = p1.next;

            } else {

                if (head == null) {
                    head = tail = new ListNode(p2.val);
                } else {
                    tail.next = new ListNode(p2.val);
                    tail = tail.next;
                }

                p2 = p2.next;
            }
        }

        while (p1 != null) {
            tail.next = new ListNode(p1.val);
            tail = tail.next;
            p1 = p1.next;
        }

        while (p2 != null) {
            tail.next = new ListNode(p2.val);
            tail = tail.next;
            p2 = p2.next;
        }

        return head;
    }

}
