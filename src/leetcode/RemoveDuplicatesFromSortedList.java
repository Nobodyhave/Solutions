package leetcode;

/**
 * Created by Aleksandr on 30/05/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list
 */
public class RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        final ListNode start = head;

        while (head.next != null) {
            if (head.val == head.next.val) {
                head.next = head.next.next;
            } else {
                head = head.next;
            }
        }

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
