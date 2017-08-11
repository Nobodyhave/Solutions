package leetcode;

/**
 * Created by Aleksandr on 12/07/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/remove-linked-list-elements
 */
public class RemoveLinkedListElements {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return head;
        }

        ListNode dummy = new ListNode(0), prev = dummy;
        dummy.next = head;

        while (head != null) {
            if (head.val == val) {
                prev.next = head.next;
                head = head.next;
            } else {
                head = head.next;
                prev = prev.next;
            }
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
