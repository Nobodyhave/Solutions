package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Aleksandr on 04/07/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/binary-tree-preorder-traversal
 */
public class BinaryTreePreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        final List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        final Stack<TreeNode> stack = new Stack<>();
        while (true) {
            while (root != null) {
                result.add(root.val);
                stack.push(root);
                root = root.left;
            }
            if (!stack.isEmpty()) {
                root = stack.pop();
            } else {
                break;
            }

            root = root.right;
        }

        return result;
    }

    private static class TreeNode {
        private int val;
        public TreeNode left;
        public TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
