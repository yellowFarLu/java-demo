package huangy.algorithm.leetcode;

import huangy.algorithm.leetcode.common.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author huangy on 2020-03-29
 */
public class MergeKLists {

    public ListNode mergeKLists(ListNode[] lists) {

        ListNode head = null;

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < lists.length; i++) {
            ListNode p = lists[i];

            while (p != null) {
                list.add(p.val);
                p = p.next;
            }
        }

        Integer[] arr = new Integer[list.size()];
        arr = list.toArray(arr);

        Arrays.sort(arr);

        ListNode tail = null;
        ListNode p;

        for (int i = 0; i < arr.length; i++) {
            if (i == 0) {
                head = tail = new ListNode(arr[i]);
            } else {
                p = new ListNode(arr[i]);
                tail.next = p;
                tail = p;
            }
        }

        return head;
    }

    public static void main(String[] args) {

    }
}
