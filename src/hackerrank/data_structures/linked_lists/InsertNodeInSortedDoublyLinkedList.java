package hackerrank.data_structures.linked_lists;

/**
 * Created by Aleksandr on 17/11/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/insert-a-node-into-a-sorted-doubly-linked-list
 */
public class InsertNodeInSortedDoublyLinkedList {
    Node sortedInsert(Node head, int data) {
        final Node newNode = new Node();
        newNode.data = data;

        if (head == null) {
            return newNode;
        } else if (head.data >= data) {
            newNode.next = head;
            head.prev = newNode;
            return newNode;
        } else {
            final Node start = head;

            while (head.next != null && head.next.data < data) {
                head = head.next;
            }

            if (head.next == null) {
                head.next = newNode;
                newNode.prev = head;
            } else {
                newNode.prev = head;
                newNode.next = head.next;
                head.next = newNode;
            }

            return start;
        }
    }

    private static class Node {
        int data;
        Node next;
        Node prev;
    }
}
