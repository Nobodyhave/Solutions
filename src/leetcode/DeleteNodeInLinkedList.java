package leetcode;

/**
 * Created by Aleksandr on 19/07/2017.
 * Project Solutions
 * https://leetcode.com/problems/delete-node-in-a-linked-list
 */
public class DeleteNodeInLinkedList {
    public void deleteNode(ListNode node) {
        if (node == null || node.next == null) {
            return;
        }

        node.val = node.next.val;
        node.next = node.next.next;
    }

    public static class ListNode {
        public int val;
        public ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
