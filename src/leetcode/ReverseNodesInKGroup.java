package leetcode;

/**
 * Created by Aleksandr on 07/06/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/reverse-nodes-in-k-group
 */
public class ReverseNodesInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k == 1) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p = dummy, start = dummy;

        while (true) {
            int count = 0;
            while (count < k && p != null) {
                p = p.next;
                count++;
            }

            if (count == k && p != null) {
                ListNode temp = start.next;
                start.next = reverseList(start.next, p.next, k);
                start = temp;
                p = start;
            } else {
                break;
            }
        }

        return dummy.next;
    }

    private ListNode reverseList(ListNode head, ListNode tail, int count) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode p1 = head, p2 = head.next, temp = null;

        p1.next = tail;
        while (p2 != null && count > 1) {
            temp = p2.next;
            p2.next = p1;
            p1 = p2;
            p2 = temp;
            count--;
        }

        return p1;
    }

    public static class ListNode {
        public int val;
        public ListNode next;

        ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder();

            ListNode p = this;
            sb.append("[");
            while (p != null) {
                sb.append(p.val).append(" ");
                p = p.next;
            }
            sb.setCharAt(sb.length() - 1, ']');

            return sb.toString();
        }
    }
}
