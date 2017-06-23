package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aleksandr on 22/06/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree
 */
public class ConvertSortedListToBinarySearchTree {
    public TreeNode sortedListToBST(ListNode head) {
        final List<Integer> nums = new ArrayList<>();

        while (head != null) {
            nums.add(head.val);
            head = head.next;
        }

        return createTree(nums, 0, nums.size() - 1);
    }

    private static TreeNode createTree(List<Integer> nums, int start, int end) {
        if (start > end) {
            return null;
        } else if (start == end) {
            return new TreeNode(nums.get(start));
        }

        final int mid = start + (end - start) / 2;
        final TreeNode root = new TreeNode(nums.get(mid));
        root.left = createTree(nums, start, mid - 1);
        root.right = createTree(nums, mid + 1, end);

        return root;
    }

    private static class TreeNode {
        private int val;
        public TreeNode left;
        public TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private static class ListNode {
        private int val;
        private ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
