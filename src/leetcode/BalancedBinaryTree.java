package leetcode;

/**
 * Created by Aleksandr on 22/06/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/balanced-binary-tree
 */
public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }

        return isBalancedHelper(root) > 0;
    }

    public int isBalancedHelper(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = isBalancedHelper(root.left);
        int rightHeight = isBalancedHelper(root.right);

        if (leftHeight < 0 || rightHeight < 0 || Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        } else {
            return Math.max(leftHeight, rightHeight) + 1;
        }
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
