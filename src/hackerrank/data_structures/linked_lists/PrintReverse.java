package hackerrank.data_structures.linked_lists;

import java.util.Stack;

/**
 * Created by Aleksandr on 17/11/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/print-the-elements-of-a-linked-list-in-reverse
 */
public class PrintReverse {
    void reversePrint(Node head) {
        final Stack<Integer> stack = new Stack<>();

        if (head == null) {
            return;
        }

        while (head != null) {
            stack.push(head.data);
            head = head.next;
        }

        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }

    }

    private static class Node {
        int data;
        Node next;
    }
}
