package leetcode;

/**
 * Created by Aleksandr on 26/04/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/add-two-numbers
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode sum = new ListNode(0);
        ListNode result = sum;

        int carry = 0;
        while (l1 != null || l2 != null) {
            if (l1 == null) {
                sum.next = new ListNode((l2.val + carry) % 10);
                carry = (l2.val + carry) / 10;
                sum = sum.next;
                l2 = l2.next;
            } else if (l2 == null) {
                sum.next = new ListNode((l1.val + carry) % 10);
                carry = (l1.val + carry) / 10;
                sum = sum.next;
                l1 = l1.next;
            } else {
                sum.next = new ListNode((l1.val + l2.val + carry) % 10);
                carry = (l1.val + l2.val + carry) / 10;
                sum = sum.next;
                l1 = l1.next;
                l2 = l2.next;
            }
        }

        if (carry != 0) {
            sum.next = new ListNode(carry);
        }

        return result.next;
    }

    private static class ListNode {
        private int val;
        private ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
