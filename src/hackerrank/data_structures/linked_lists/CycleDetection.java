package hackerrank.data_structures.linked_lists;

/**
 * Created by Aleksandr on 17/11/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/detect-whether-a-linked-list-contains-a-cycle
 */
public class CycleDetection {
    boolean hasCycle(Node head) {
        if (head == null || head.next == null || head.next.next == null) {
            return false;
        }

        Node slow = head, fast = head.next.next;

        while (slow != null && fast != null) {
            if (slow == fast) {
                return true;
            }
            slow = slow.next;
            fast = fast.next;
            if (fast == null) {
                return false;
            }
            fast = fast.next;
        }

        return false;
    }

    private static class Node {
        int data;
        Node next;
    }
}
