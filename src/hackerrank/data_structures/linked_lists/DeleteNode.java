package hackerrank.data_structures.linked_lists;

/**
 * Created by Aleksandr on 17/11/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/delete-a-node-from-a-linked-list
 */
public class DeleteNode {
    Node delete(Node head, int position) {
        if (head == null || head.next == null) {
            return null;
        } else if (position == 0) {
            return head.next;
        } else {
            Node start = head;
            int count = 0;

            while (count + 1 < position) {
                start = start.next;
                count++;
            }

            start.next = start.next.next;

            return head;
        }

    }

    private static class Node {
        int data;
        Node next;
    }
}
