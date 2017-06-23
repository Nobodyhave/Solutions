package leetcode;

/**
 * Created by Aleksandr on 22/06/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/minimum-depth-of-binary-tree
 */
public class MinimumDepthOfBinaryTree {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return minDepthHelper(root, 1);
    }

    private int minDepthHelper(TreeNode root, int depth) {
        if (root.left == null && root.right == null) {
            return depth;
        } else if (root.left == null) {
            return minDepthHelper(root.right, depth + 1);
        } else if (root.right == null) {
            return minDepthHelper(root.left, depth + 1);
        } else {
            return Math.min(minDepthHelper(root.left, depth + 1), minDepthHelper(root.right, depth + 1));
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
