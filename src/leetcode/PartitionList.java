package leetcode;

/**
 * Created by Aleksandr on 01/06/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/partition-list
 */
public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummyLess = new ListNode(0);
        ListNode dummyLP = dummyLess;
        ListNode dummyGreater = new ListNode(0);
        ListNode dummyGP = dummyGreater;

        while (head != null) {
            if (head.val < x) {
                dummyLess.next = head;
                head = head.next;
                dummyLess = dummyLess.next;
                dummyLess.next = null;
            } else {
                dummyGreater.next = head;
                head = head.next;
                dummyGreater = dummyGreater.next;
                dummyGreater.next = null;
            }
        }

        dummyLess.next = dummyGP.next;

        return dummyLP.next;
    }

    private static class ListNode {
        private int val;
        private ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
