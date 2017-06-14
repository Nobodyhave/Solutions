package leetcode;

/**
 * Created by Aleksandr on 13/06/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/symmetric-tree
 */
public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }

        return isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p == null || q == null) {
            return false;
        } else {
            return p.val == q.val && isSymmetric(p.left, q.right) && isSymmetric(p.right, q.left);
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
