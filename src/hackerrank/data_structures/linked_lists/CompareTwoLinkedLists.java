package hackerrank.data_structures.linked_lists;

/**
 * Created by Aleksandr on 17/11/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/compare-two-linked-lists
 */
public class CompareTwoLinkedLists {
    int compareLists(Node headA, Node headB) {
        if (headA == null && headB == null) {
            return 1;
        } else if (headA == null || headB == null) {
            return 0;
        } else {
            while (headA != null && headB != null) {
                if (headA.data != headB.data) {
                    return 0;
                }
                headA = headA.next;
                headB = headB.next;
            }

            if (headA != null || headB != null) {
                return 0;
            }

            return 1;
        }
    }

    private static class Node {
        int data;
        Node next;
    }
}
