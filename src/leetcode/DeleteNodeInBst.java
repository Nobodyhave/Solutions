package leetcode;

/**
 * Created by Aleksandr on 14/09/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/delete-node-in-a-bst
 */
public class DeleteNodeInBst {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }

        TreeNode parent = null, current = root;
        while (current != null && current.val != key) {
            parent = current;
            current = key < current.val ? current.left : current.right;
        }

        if (current == null) {
            // Do nothing;
        } else if (current.left == null && current.right == null) {
            if (parent == null) {
                root = null;
            } else if (parent.left == current) {
                parent.left = null;
            } else {
                parent.right = null;
            }
        } else if (current.left == null) {
            if (parent == null) {
                root = current.right;
            } else if (parent.left == current) {
                parent.left = current.right;
            } else {
                parent.right = current.right;
            }
        } else if (current.right == null) {
            if (parent == null) {
                root = current.left;
            } else if (parent.left == current) {
                parent.left = current.left;
            } else {
                parent.right = current.left;
            }
        } else {
            TreeNode successorP = current;
            TreeNode successor = current.right;
            while (successor.left != null) {
                successorP = successor;
                successor = successor.left;
            }

            if (successorP != current) {
                successorP.left = successor.right;
                successor.right = current.right;
            }

            successor.left = current.left;
            if (parent == null) {
                root = successor;
            } else if (parent.left == current) {
                parent.left = successor;
            } else {
                parent.right = successor;
            }
        }

        return root;
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
