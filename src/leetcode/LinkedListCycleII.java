package leetcode;

/**
 * Created by Aleksandr on 04/07/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/linked-list-cycle-ii
 */
public class LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode slow = head, fast = head, start = head;
        boolean isCycle = false;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (fast == slow) {
                isCycle = true;
                break;
            }
        }

        if (!isCycle) {
            return null;
        }

        while (start != slow) {
            start = start.next;
            slow = slow.next;
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
