package leetcode;

/**
 * Created by Aleksandr on 23/06/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/flatten-binary-tree-to-linked-list
 */
public class FlattenBinaryTreeToLinkedList {
    public void flatten(TreeNode root) {
        flattenHelper(root);
    }

    private static TreeNode flattenHelper(TreeNode root) {
        if (root == null) {

        } else if (root.left == null && root.right == null) {

        } else if (root.left == null) {
            root.right = flattenHelper(root.right);
        } else if (root.right == null) {
            root.right = flattenHelper(root.left);
            root.left = null;
        } else {
            TreeNode node = flattenHelper(root.left);
            appendToRight(node, flattenHelper(root.right));
            root.right = node;
            root.left = null;
        }

        return root;
    }

    private static TreeNode appendToRight(TreeNode dest, TreeNode source) {
        TreeNode p = dest;
        while (p.right != null) {
            p = p.right;
        }
        p.right = source;

        return dest;
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
