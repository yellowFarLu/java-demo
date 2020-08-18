package huangy.algorithm.leetcode;

import huangy.algorithm.leetcode.common.ListNode;
import java.math.BigDecimal;

/**
 * @author huangy on 2020-04-06
 */
public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        BigDecimal num1 = getNumFromLinkedList(l1);
        BigDecimal num2 = getNumFromLinkedList(l2);

        BigDecimal sum = num1.add(num2);

        ListNode head = null;

        if (sum.equals(new BigDecimal("0"))) {
            head = new ListNode(0);
            return head;
        }

        StringBuilder sb = new StringBuilder();

        while (!sum.equals(new BigDecimal("0"))) {

            // a.divideAndRemainder(b)[1]  表示a%b
            BigDecimal tem = sum.divideAndRemainder(new BigDecimal("10"))[1];

            // BigDecimal.ROUND_DOWN 表示不进位，相当于小数点后面的不要了
            sum = sum.divide(new BigDecimal("10"), BigDecimal.ROUND_DOWN);

            // 相当于翻转
            sb.append(tem);
        }

        ListNode p, tail = null;

        for (int i = 0; i < sb.length(); i++) {
            p = new ListNode(
                    Integer.parseInt(
                            String.valueOf(
                                    sb.charAt(i))));

            if (i == 0) {
                head = tail = p;
            } else {
                tail.next = p;
                tail = p;
            }
        }

        return head;
    }

    private BigDecimal getNumFromLinkedList(ListNode head) {
        StringBuilder sb = new StringBuilder();

        ListNode p = head;

        while (p != null) {

            sb.append(p.val);

            p = p.next;
        }

        return new BigDecimal(sb.reverse().toString());
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(0);

        ListNode l2 = new ListNode(0);

        ListNode result = new AddTwoNumbers().addTwoNumbers(l1, l2);
        System.out.println(result);
    }
}
