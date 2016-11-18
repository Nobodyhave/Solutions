package hackerrank.data_structures.linked_lists;

/**
 * Created by Aleksandr on 17/11/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/delete-duplicate-value-nodes-from-a-sorted-linked-list
 */
public class DeleteDuplicatesFromSortedList {
    Node removeDuplicates(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        final Node start = head;
        while (head.next != null) {
            if (head.data == head.next.data) {
                head.next = head.next.next;
            } else {
                head = head.next;
            }
        }

        return start;
    }

    private static class Node {
        int data;
        Node next;
    }
}
