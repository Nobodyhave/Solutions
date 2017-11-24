package leetcode;

/**
 * Created by Aleksandr on 17/11/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/split-linked-list-in-parts
 */
public class SplitLinkedListInParts {
    public ListNode[] splitListToParts(ListNode root, int k) {
        final ListNode[] result = new ListNode[k];
        if (root == null || k == 0) {
            return result;
        }

        int length = 0;
        ListNode start = root;
        while (start != null) {
            length++;
            start = start.next;
        }

        final int div = length / k;
        int rem = length % k;
        start = root;
        for (int i = 0; i <= k; i++) {
            ListNode cur = null;
            for (int j = 0; j < div && start != null; j++) {
                if (j == 0) {
                    result[i] = new ListNode(start.val);
                    cur = result[i];
                } else {
                    cur.next = new ListNode(start.val);
                    cur = cur.next;
                }
                start = start.next;
            }
            if (rem > 0 && start != null) {
                if (cur == null) {
                    result[i] = new ListNode(start.val);
                } else {
                    cur.next = new ListNode(start.val);
                }
                start = start.next;
                rem--;
            }
        }

        return result;
    }

    private static class ListNode {
        private int val;
        private ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
