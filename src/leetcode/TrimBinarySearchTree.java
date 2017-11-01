package leetcode;

/**
 * Created by Aleksandr on 26/10/2017.
 * Project Solutions
 */
public class TrimBinarySearchTree {
    public TreeNode trimBST(TreeNode root, int L, int R) {
        if (root == null) {
            return null;
        } else if (root.left == null && root.right == null) {
            if (root.val >= L && root.val <= R) {
                return root;
            } else {
                return null;
            }
        }

        root.left = trimBST(root.left, L, R);
        root.right = trimBST(root.right, L, R);

        if (root.left != null && root.left.val < L) {
            root.left = null;
        }
        if (root.right != null && root.right.val > R) {
            root.right = null;
        }
        if (root.val < L) {
            if (root.right != null && root.right.val >= L) {
                root = root.right;
            }
        } else if (root.val > R) {
            if (root.left != null && root.left.val <= R) {
                root = root.left;
            }
        }

        return root;
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
