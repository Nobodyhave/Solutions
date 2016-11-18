package hackerrank.data_structures.linked_lists;

/**
 * Created by Aleksandr on 17/11/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/merge-two-sorted-linked-lists
 */
public class MergeTwoSortedLinkedLists {
    Node mergeLists(Node headA, Node headB) {
        if (headA == null) {
            return headB;
        } else if (headB == null) {
            return headA;
        }
        Node dummy = new Node();
        final Node start = dummy;

        while (headA != null || headB != null) {
            if (headA == null) {
                dummy.next = headB;
                headB = headB.next;
            } else if (headB == null) {
                dummy.next = headA;
                headA = headA.next;
            } else {
                if (headA.data <= headB.data) {
                    dummy.next = headA;
                    headA = headA.next;
                } else {
                    dummy.next = headB;
                    headB = headB.next;
                }
            }

            dummy = dummy.next;
        }

        return start.next;
    }

    private static class Node {
        int data;
        Node next;
    }
}
