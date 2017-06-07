package leetcode;

/**
 * Created by Aleksandr on 31/05/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii
 */
public class RemoveDuplicatesFromSortedListII {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        ListNode start = null, candidate = null;

        while (head != null) {
            if (candidate == null) {
                candidate = head;
                head = head.next;
            } else {
                if (head.val != candidate.val) {
                    dummy.next = candidate;
                    if (start == null) {
                        start = dummy.next;
                    }
                    dummy = dummy.next;
                    candidate = null;
                } else {
                    while (head != null && head.val == candidate.val) {
                        head = head.next;
                    }
                    candidate = null;
                }
            }
        }

        if (candidate != null) {
            dummy.next = candidate;
            if (start == null) {
                start = dummy.next;
            }
            dummy.next.next = null;
        } else {
            dummy.next = null;
        }

        return start;
    }

    private static class ListNode {
        private int val;
        private ListNode next;

        ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder();

            ListNode p = this;
            sb.append("[");
            while (p != null) {
                sb.append(p.val).append(" ");
                p = p.next;
            }
            sb.setCharAt(sb.length() - 1, ']');

            return sb.toString();
        }
    }
}
