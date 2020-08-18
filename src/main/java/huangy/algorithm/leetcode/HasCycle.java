package huangy.algorithm.leetcode;

import huangy.algorithm.leetcode.common.ListNode;

/**
 * @author huangy on 2020-03-29
 */
public class HasCycle {

    public boolean hasCycle(ListNode head) {

        if (head == null) {
            return false;
        }

        ListNode slow, fast;
        slow = fast = head;

        while ((slow != null) && (fast != null) && (fast.next != null)) {

            slow = slow.next;
            fast = fast.next.next;

            if (fast == slow) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {

    }
}
