package leetcode;

/**
 * Created by Aleksandr on 03/07/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/copy-list-with-random-pointer
 */
public class CopyListWithRandomPointer {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return null;
        }

        RandomListNode start = head;

        while (head != null) {
            final RandomListNode node = new RandomListNode(head.label);
            node.next = head.next;

            head.next = node;
            head = node.next;
        }

        head = start;

        while (head != null && head.next != null) {
            if (head.random != null) {
                head.next.random = head.random.next;
            } else {
                head.next.random = null;
            }
            head = head.next.next;
        }

        head = start;
        RandomListNode dummy = new RandomListNode(0);
        RandomListNode next, copy, copyIter = dummy;

        while (head != null) {
            next = head.next.next;

            copy = head.next;
            copyIter.next = copy;
            copyIter = copy;

            head.next = next;

            head = next;
        }

        return dummy.next;
    }

    private static class RandomListNode {
        int label;
        RandomListNode next, random;

        RandomListNode(int x) {
            this.label = x;
        }
    }
}
