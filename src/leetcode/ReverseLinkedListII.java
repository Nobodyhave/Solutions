package leetcode;

/**
 * Created by Aleksandr on 06/06/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/reverse-linked-list-ii
 */
public class ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null || m == n) {
            return head;
        }

        ListNode p = head, start = null, tail = null;

        int count = 0;
        while (p != null) {
            if (count == m - 2) {
                start = p;
            }
            if (count == n) {
                tail = p;
            }
            p = p.next;
            count++;
        }

        if (start == null) {
            return reverseList(head, tail, n - m + 1);
        } else {
            start.next = reverseList(start.next, tail, n - m + 1);
            return head;
        }
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
