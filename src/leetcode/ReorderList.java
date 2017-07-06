package leetcode;

/**
 * Created by Aleksandr on 04/07/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/reorder-list
 */
public class ReorderList {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        ListNode start = head;
        int length = 0;
        while (start != null) {
            length++;
            start = start.next;
        }

        ListNode mid = head;
        int i = (length % 2 == 0 ? length / 2 : length / 2 + 1);
        while (i > 0) {
            i--;
            mid = mid.next;
        }

        mid = reverseList(mid);
        start = head;
        i = (length % 2 == 0 ? length / 2 : length / 2 + 1);
        while (i > 0) {
            i--;
            ListNode oldStartNext = start.next;
            ListNode oldMidNext = mid != null ? mid.next : null;

            start.next = mid;
            start = oldStartNext;
            if (mid != null) {
                mid.next = i != 0 ? oldStartNext : null;
                mid = oldMidNext;
            }
        }
    }

    private static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode p1 = head, p2 = head.next, temp;

        p1.next = null;
        while (p2 != null) {
            temp = p2.next;
            p2.next = p1;
            p1 = p2;
            p2 = temp;
        }

        return p1;
    }

    public static class ListNode {
        public int val;
        public ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
