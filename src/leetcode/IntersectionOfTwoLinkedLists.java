package leetcode;

/**
 * Created by Aleksandr on 06/07/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/intersection-of-two-linked-lists
 */
public class IntersectionOfTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        int sizeA = 0, sizeB = 0;
        ListNode startA = headA, startB = headB;

        while (headA != null) {
            headA = headA.next;
            sizeA++;
        }

        while (headB != null) {
            headB = headB.next;
            sizeB++;
        }

        headA = startA;
        headB = startB;
        if (sizeA > sizeB) {
            for (int i = 0; i < sizeA - sizeB; i++) {
                headA = headA.next;
            }
        } else if (sizeB > sizeA) {
            for (int i = 0; i < sizeB - sizeA; i++) {
                headB = headB.next;
            }
        }

        while (headA != null) {
            if (headA == headB) {
                return headA;
            }

            headA = headA.next;
            headB = headB.next;
        }

        return null;
    }

    private static class ListNode {
        private int val;
        private ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
