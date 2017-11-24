package interviewbit;

/**
 * Created by Aleksandr on 24/11/2017.
 * Project Solutions
 * <p>
 * https://www.interviewbit.com/problems/subtract/
 */
public class Subtract {
    public ListNode subtract(ListNode a) {
        if (a == null || a.next == null) {
            return a;
        }

        int length = 0;
        ListNode start = a;
        while (start != null) {
            length++;
            start = start.next;
        }

        int half = length / 2 + (length % 2 != 0 ? 1 : 0);
        start = a;
        while (half > 0) {
            start = start.next;
            half--;
        }

        ListNode secondHalf = reverse(start);
        ListNode secondHalfStart = secondHalf;
        start = a;

        half = length / 2;
        while (half > 0) {
            start.val = secondHalf.val - start.val;
            half--;
            if (half != 0) {
                start = start.next;
                secondHalf = secondHalf.next;
            }
        }

        if (length % 2 != 0) {
            start = start.next;
        }
        start.next = reverse(secondHalfStart);

        return a;
    }

    private ListNode reverse(ListNode node) {
        ListNode p1 = node, p2 = node.next;
        p1.next = null;
        while (p2 != null) {
            ListNode temp = p2.next;
            p2.next = p1;
            p1 = p2;
            p2 = temp;
        }

        return p1;
    }

    private static class ListNode {
        private int val;
        private ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
