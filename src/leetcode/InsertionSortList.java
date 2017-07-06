package leetcode;

/**
 * Created by Aleksandr on 05/07/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/insertion-sort-list
 */
public class InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy, cur = dummy.next;

        while (cur != null) {
            ListNode curNext = cur.next, start = dummy;

            while (start.next != null && start != cur && cur.val >= start.next.val) {
                start = start.next;
            }

            if (start != cur) {
                prev.next = curNext;

                cur.next = start.next;
                start.next = cur;
            } else {
                prev = prev.next;
            }
            cur = curNext;
        }

        return dummy.next;
    }

    public static class ListNode {
        public int val;
        public ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
