package hackerrank.data_structures.linked_lists;

/**
 * Created by Aleksandr on 17/11/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/find-the-merge-point-of-two-joined-linked-lists
 */
public class FindMergePointOfTwoLists {
    int findMergeNode(Node headA, Node headB) {
        int length1 = 0, length2 = 0;

        Node startA = headA, startB = headB;

        while (startA != null) {
            length1++;
            startA = startA.next;
        }

        while (startB != null) {
            length2++;
            startB = startB.next;
        }

        int count = Math.abs(length1 - length2);

        if (length1 > length2) {
            while (count > 0) {
                headA = headA.next;
                count--;
            }
        } else if (length2 > length1) {
            while (count > 0) {
                headB = headB.next;
                count--;
            }
        }

        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }

        return headA.data;
    }

    private static class Node {
        int data;
        Node next;
    }
}
