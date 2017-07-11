package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by Aleksandr on 07/07/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/binary-search-tree-iterator
 */
public class BinarySearchTreeIterator {
    private TreeNode current = null;
    private Deque<TreeNode> stack = new ArrayDeque<>();

    public BinarySearchTreeIterator(TreeNode root) {
        if (root == null) {
            current = null;
        } else if (root.left == null) {
            stack.add(root);
        } else {
            current = root;
            while (current != null) {
                stack.add(current);
                current = current.left;
            }
        }
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return current != null || !stack.isEmpty();
    }

    /**
     * @return the next smallest number
     */
    public int next() {
        int val = 0;
        if (current != null) {
            val = current.val;
            current = null;
        } else {
            current = stack.pollLast();
            val = current.val;
            current = current.right;
            while (current != null) {
                stack.add(current);
                current = current.left;
            }
        }

        return val;
    }

    private static class TreeNode {
        private int val;
        private TreeNode left;
        private TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
