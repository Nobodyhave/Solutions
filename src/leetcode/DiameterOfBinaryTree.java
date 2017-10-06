package leetcode;

/**
 * Created by Aleksandr on 03/10/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/diameter-of-binary-tree
 */
public class DiameterOfBinaryTree {
    private int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        dfs(root);

        return max;
    }

    private int dfs(TreeNode root) {
        if (root.left == null && root.right == null) {
            return 0;
        }

        int leftHeight = (root.left != null ? dfs(root.left) : -1);
        int rightHeight = (root.right != null ? dfs(root.right) : -1);

        max = Math.max(max, leftHeight + rightHeight + 2);

        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static class TreeNode {
        private int val;
        public TreeNode left;
        public TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
