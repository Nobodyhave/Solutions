package hackerrank.data_structures.linked_lists;

/**
 * Created by Aleksandr on 17/11/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/insert-a-node-at-a-specific-position-in-a-linked-list
 */
public class InsertNode {
    Node insertNth(Node head, int data, int position) {
        final Node newNode = new Node();
        newNode.data = data;

        if (position == 0) {
            newNode.next = head;
            return newNode;
        } else {
            Node start = head;
            int count = 0;
            while (count + 1 < position) {
                start = start.next;
                count++;
            }
            final Node tempNext = start.next;
            start.next = newNode;
            newNode.next = tempNext;
            return head;
        }
    }

    private static class Node {
        int data;
        Node next;
    }
}
