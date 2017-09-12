package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by Aleksandr on 12/09/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/add-two-numbers-ii
 */
public class AddTwoNumbersII {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        final Deque<Integer> s1 = new ArrayDeque<>();
        final Deque<Integer> s2 = new ArrayDeque<Integer>();

        while (l1 != null) {
            s1.push(l1.val);
            l1 = l1.next;
        }

        while (l2 != null) {
            s2.push(l2.val);
            l2 = l2.next;
        }

        int sum = 0;
        ListNode list = new ListNode(0);
        while (!s1.isEmpty() || !s2.isEmpty()) {
            if (!s1.isEmpty()) {
                sum += s1.pop();
            }
            if (!s2.isEmpty()) {
                sum += s2.pop();
            }
            list.val = sum % 10;
            ListNode head = new ListNode(sum / 10);
            head.next = list;
            list = head;
            sum /= 10;
        }

        return list.val == 0 ? list.next : list;
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
