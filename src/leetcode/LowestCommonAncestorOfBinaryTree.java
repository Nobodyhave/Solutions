package leetcode;

/**
 * Created by Aleksandr on 19/07/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree
 */
public class LowestCommonAncestorOfBinaryTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) {
            return root;
        } else if (root == p && (left == q || right == q)) {
            return root;
        } else if (root == q && (left == p || right == p)) {
            return root;
        } else if (left != null) {
            return left;
        } else if (right != null) {
            return right;
        } else if (root == p || root == q) {
            return root;
        } else {
            return null;
        }
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
