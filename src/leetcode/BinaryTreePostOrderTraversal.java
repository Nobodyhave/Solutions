package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * Created by Aleksandr on 05/07/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/binary-tree-postorder-traversal
 */
public class BinaryTreePostOrderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        final List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        final Stack<TreeNode> stack = new Stack<>();
        while (true) {
            while (root != null) {
                result.add(root.val);
                stack.push(root);
                root = root.right;
            }
            if (!stack.isEmpty()) {
                root = stack.pop();
            } else {
                break;
            }

            root = root.left;
        }

        Collections.reverse(result);

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
