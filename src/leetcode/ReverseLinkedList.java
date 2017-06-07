package leetcode;

/**
 * Created by Aleksandr on 06/06/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/reverse-linked-list
 */
public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode p1 = head, p2 = head.next, temp = null;

        p1.next = null;
        while (p2 != null) {
            temp = p2.next;
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
