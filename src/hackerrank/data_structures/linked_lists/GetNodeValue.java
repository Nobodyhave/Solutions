package hackerrank.data_structures.linked_lists;

/**
 * Created by Aleksandr on 17/11/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/get-the-value-of-the-node-at-a-specific-position-from-the-tail
 */
public class GetNodeValue {
    int getNode(Node head, int n) {
        int count = 0;

        Node start = head;
        while (head != null) {
            if (count > n) {
                start = start.next;
            }
            count++;
            head = head.next;
        }

        return start.data;
    }

    private static class Node {
        int data;
        Node next;
    }
}
