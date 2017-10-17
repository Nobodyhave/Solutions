package leetcode;

/**
 * Created by Aleksandr on 16/10/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/add-one-row-to-tree
 */
public class AddOneRowToTree {
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if (d == 1) {
            TreeNode node = new TreeNode(v);
            node.left = root;
            return node;
        } else {
            insert(root.left, root, v, d - 1, true);
            insert(root.right, root, v, d - 1, false);

            return root;
        }
    }

    private void insert(TreeNode root, TreeNode parent, int v, int d, boolean left) {
        if (d == 1) {
            if (left) {
                TreeNode nodeL = new TreeNode(v);
                nodeL.left = root;
                parent.left = nodeL;
            } else {
                TreeNode nodeR = new TreeNode(v);
                nodeR.right = root;
                parent.right = nodeR;
            }

            return;
        }
        if (root == null) {
            return;
        }

        insert(root.left, root, v, d - 1, true);
        insert(root.right, root, v, d - 1, false);
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
