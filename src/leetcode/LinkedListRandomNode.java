package leetcode;

import java.util.Random;

/**
 * Created by Aleksandr on 29/08/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/linked-list-random-node
 */
public class LinkedListRandomNode {
    private int length;
    private ListNode head;
    private Random random;

    public LinkedListRandomNode(ListNode head) {
        random = new Random();
        this.head = head;
        while (head != null) {
            head = head.next;
            length++;
        }
    }

    public int getRandom() {
        int index = random.nextInt(length);
        ListNode start = head;
        int i = 0;
        while (i < index) {
            start = start.next;
            i++;
        }

        return start.val;
    }

    private static class ListNode {
        private int val;
        private ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
