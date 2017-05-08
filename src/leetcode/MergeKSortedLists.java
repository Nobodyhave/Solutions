package leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by Aleksandr on 08/05/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/merge-two-sorted-lists
 */
public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        final ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        final PriorityQueue<ListNode> pq = new PriorityQueue<>(new NodeComparator());
        for (ListNode node : lists) {
            if (node != null) {
                pq.add(node);
            }
        }
        while (pq.isEmpty()) {
            ListNode min = pq.poll();

            p.next = min;
            p = p.next;
            if (min.next != null) {
                pq.add(min.next);
            }
            p.next = null;
        }

        return dummy.next;
    }

    private static class NodeComparator implements Comparator<ListNode> {
        @Override
        public int compare(ListNode o1, ListNode o2) {
            return Integer.compare(o1.val, o2.val);
        }
    }

    private static class ListNode {
        private int val;
        private ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
