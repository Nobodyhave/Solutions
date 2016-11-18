package hackerrank.data_structures.linked_lists;

/**
 * Created by Aleksandr on 17/11/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/print-the-elements-of-a-linked-list
 */
public class PrintLinkedList {
    void print(Node head) {
        while (head != null) {
            System.out.println(head.data);
            head = head.next;
        }
    }

    private static class Node {
        int data;
        Node next;
    }
}
