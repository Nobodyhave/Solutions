package leetcode;

/**
 * Created by Aleksandr on 14/06/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/maximum-depth-of-binary-tree
 */
public class MaximumDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
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
