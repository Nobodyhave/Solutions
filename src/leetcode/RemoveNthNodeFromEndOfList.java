package leetcode;

/**
 * Created by Aleksandr on 08/05/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list
 */
public class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || head.next == null) {
            return null;
        }

        final ListNode dummy = new ListNode(0);
        ListNode before = null;
        dummy.next = head;

        int count = 0;
        while (head.next != null) {
            if (count == n - 1) {
                before = dummy.next;
            } else if (count > n - 1) {
                before = before.next;
            }
            head = head.next;
            count++;
        }

        if (before == null) {
            dummy.next = dummy.next.next;
        } else {
            before.next = before.next.next;
        }

        return dummy.next;
    }

    private static class ListNode {
        private int val;
        private ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
