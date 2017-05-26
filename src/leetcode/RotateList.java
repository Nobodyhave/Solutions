package leetcode;

/**
 * Created by Aleksandr on 26/05/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/rotate-list
 */
public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode start = head, p = head;

        int length = 0;
        while (p != null) {
            p = p.next;
            length++;
        }

        int count = k % length;

        if (count == 0) {
            return head;
        }

        p = head;
        while (count > 0) {
            p = p.next;
            count--;
        }

        count = 0;
        while (p.next != null) {
            p = p.next;
            start = start.next;
            count++;
        }
        start = start.next;
        count++;

        while (count > 1) {
            p.next = head;
            p = p.next;
            head = head.next;
            count--;
        }

        p.next = head;
        head.next = null;

        return start;
    }

    private static class ListNode {
        private int val;
        private ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
