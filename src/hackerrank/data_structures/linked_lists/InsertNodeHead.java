package hackerrank.data_structures.linked_lists;

/**
 * Created by Aleksandr on 17/11/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/insert-a-node-at-the-head-of-a-linked-list
 */
public class InsertNodeHead {
    Node insert(Node head, int x) {
        final Node newNode = new Node();
        newNode.data = x;
        newNode.next = head;

        return newNode;
    }

    private static class Node {
        int data;
        Node next;
    }
}
