package huangy.algorithm.leetcode;

import huangy.algorithm.leetcode.common.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 判断一个链表是否回文链表
 * @author huangy on 2020-01-20
 */
public class PalindromeLinkedList {

    /**
     *
     * 解法一：
     * 将链表的值放到数组中，从数组两侧进行比较
     */
    public boolean isPalindrome1(ListNode head) {

        List<Integer> arr = new ArrayList<>();

        ListNode cur = head;
        while (cur != null) {
            arr.add(cur.val);
            cur = cur.next;
        }

        int begin = 0;
        int end = arr.size() - 1;

        while (begin <= end) {
            if (!arr.get(begin).equals(arr.get(end))) {
                return false;
            }

            begin++;
            end--;
        }

        return true;
    }

    /**
     * 解法二：
     *  (1）使用快慢指针找到链表中点
     * （2）然后将前半段链表倒置
     * （3）然后从中点开始比较前后两段链表是否相等
     */
    public boolean isPalindrome(ListNode head) {

        if ((head == null) || (head.next == null)) {
            return true;
        }

        // (1）使用快慢指针找到链表中点
        ListNode slow = head, fast = head;
        while ((fast != null) && (fast.next != null)) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // （2）然后将前半段链表倒置
        ListNode cur = head;
        ListNode pre = null;
        ListNode next = null;
        while (cur != slow) {
            next = cur.next;
            cur.next = pre;

            pre = cur;
            cur = next;
        }

        // 如果是奇数，把前半段多一个数（后半段去掉这个数）
        if (fast != null) {
            slow = slow.next;
        }

        // （3）然后从中点开始比较前后两段链表是否相等
        while ((pre != null) && (slow != null)) {
            if (pre.val != slow.val) {
                return false;
            }
            pre = pre.next;
            slow = slow.next;
        }

        return true;

    }

    public static void main(String[] args) {

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node33 = new ListNode(3);
        ListNode node22 = new ListNode(2);
        ListNode node11 = new ListNode(1);

        node1.next = node2;
        node2.next = node3;
        node3.next = node33;
        node33.next = node22;
        node22.next = node11;

        System.out.println(
                new PalindromeLinkedList().isPalindrome(node1));

    }
}
















