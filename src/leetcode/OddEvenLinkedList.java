package leetcode;

/**
 * Created by Aleksandr on 22/08/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/odd-even-linked-list
 */
public class OddEvenLinkedList {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode oddDummy = new ListNode(0), oddStart = oddDummy;
        ListNode evenDummy = new ListNode(0), evenStart = evenDummy;

        while (head != null) {
            oddStart.next = head;
            oddStart = oddStart.next;
            head = head.next;
            evenStart.next = head;
            evenStart = evenStart.next;
            oddStart.next = null;

            if (head != null) {
                head = head.next;
                evenStart.next = null;
            }
        }

        oddStart.next = evenDummy.next;

        return oddDummy.next;
    }

    private static class ListNode {
        private int val;
        private ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
