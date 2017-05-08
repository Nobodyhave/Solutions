package leetcode;

/**
 * Created by Aleksandr on 08/05/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/swap-nodes-in-pairs
 */
public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(0), start = new ListNode(0);
        dummy.next = start;
        while (head != null && head.next != null) {
            ListNode first = head;
            ListNode second = head.next;
            ListNode next = head.next.next;

            start.next = second;
            second.next = first;
            first.next = next;
            start = first;
            head = next;
        }

        return dummy.next.next;
    }

    private static class ListNode {
        private int val;
        private ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
