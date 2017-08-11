package leetcode;

/**
 * Created by Aleksandr on 18/07/2017.
 * Project Solutions
 */
public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) {
            return true;
        }

        int size = 0;
        ListNode start = head;
        while(head != null) {
            head = head.next;
            size++;
        }

        int offset = size/2 + (size % 2 == 0 ? 0 : 1);
        head = start;
        int i = 0;
        while(i < offset) {
            head = head.next;
            i++;
        }
        head = reverseList(head);

        i = 0;
        while(i < size / 2) {
            if(start.val != head.val) {
                return false;
            }
            head = head.next;
            start = start.next;
            i++;
        }

        return true;
    }

    private static ListNode reverseList(ListNode head) {
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

    public static class ListNode {
        public int val;
        public ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
