package hackerrank.data_structures.linked_lists;

/**
 * Created by Aleksandr on 17/11/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/insert-a-node-at-the-tail-of-a-linked-list
 */
public class InsertNodeTail {
    Node insert(Node head, int data) {
        final Node newNode = new Node();
        newNode.data = data;
        if (head == null) {
            return newNode;
        } else {
            Node start = head;
            while (start.next != null) {
                start = start.next;
            }
            start.next = newNode;
            return head;
        }
    }

    private static class Node {
        int data;
        Node next;
    }
}
