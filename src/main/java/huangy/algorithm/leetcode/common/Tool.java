package huangy.algorithm.leetcode.common;

/**
 * @author huangy on 2020-04-11
 */
public class Tool {

    public static void printListNodes(ListNode head) {

        ListNode p = head;

        while (p != null) {
            System.out.print(p.val + " ");
            p = p.next;
        }
    }

    public static void printfArray(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    public static ListNode getListFromArr(int[] nums) {
        if (nums.length == 0) {
            return null;
        }

        ListNode head = new ListNode(nums[0]);
        ListNode pre = head;

        for (int i = 1; i < nums.length; i++) {
            ListNode p = new ListNode(nums[i]);
            pre.next = p;
            pre = p;
        }

        return head;
    }
}
