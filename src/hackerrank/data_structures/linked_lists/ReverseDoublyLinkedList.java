package hackerrank.data_structures.linked_lists;

/**
 * Created by Aleksandr on 17/11/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/reverse-a-doubly-linked-list
 */
public class ReverseDoublyLinkedList {
    Node reverse(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node p1 = head, p2 = head.next;
        p1.next = null;
        while (p2 != null) {
            Node temp = p2.next;
            p1.prev = p2;
            p2.next = p1;
            p1 = p2;
            p2 = temp;
        }

        return p1;
    }

    private static class Node {
        int data;
        Node next;
        Node prev;
    }
}
