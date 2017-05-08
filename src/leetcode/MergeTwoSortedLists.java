package leetcode;

/**
 * Created by Aleksandr on 08/05/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/merge-two-sorted-lists
 */
public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        } else if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }

        final ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        while (l1 != null || l2 != null) {
            if (l1 == null) {
                p.next = l2;
                p = p.next;
                l2 = l2.next;
                p.next = null;
            } else if (l2 == null) {
                p.next = l1;
                p = p.next;
                l1 = l1.next;
                p.next = null;
            } else {
                if (l1.val <= l2.val) {
                    p.next = l1;
                    p = p.next;
                    l1 = l1.next;
                    p.next = null;
                } else {
                    p.next = l2;
                    p = p.next;
                    l2 = l2.next;
                    p.next = null;
                }
            }
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
