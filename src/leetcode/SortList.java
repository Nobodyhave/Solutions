package leetcode;

/**
 * Created by Aleksandr on 05/07/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/sort-list
 */
public class SortList {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode prev = null, slow = head, fast = head;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prev.next = null;

        ListNode left = sortList(head);
        ListNode right = sortList(slow);

        return merge(left, right);
    }

    private static ListNode merge(ListNode left, ListNode right) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;

        while (left != null && right != null) {
            if (left.val <= right.val) {
                cur.next = left;
                left = left.next;
            } else {
                cur.next = right;
                right = right.next;
            }
            cur = cur.next;
        }

        while (left != null) {
            cur.next = left;
            left = left.next;
            cur = cur.next;
        }

        while (right != null) {
            cur.next = right;
            right = right.next;
            cur = cur.next;
        }

        cur.next = null;

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
