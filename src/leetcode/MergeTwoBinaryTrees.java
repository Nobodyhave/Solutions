package leetcode;

/**
 * Created by Aleksandr on 16/10/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/merge-two-binary-trees
 */
public class MergeTwoBinaryTrees {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        return merge(t1, t2);
    }

    private TreeNode merge(TreeNode t1, TreeNode t2) {
        TreeNode node;
        if (t1 == null && t2 == null) {
            return null;
        } else if (t1 == null) {
            node = new TreeNode(t2.val);
            node.left = merge(null, t2.left);
            node.right = merge(null, t2.right);
        } else if (t2 == null) {
            node = new TreeNode(t1.val);
            node.left = merge(t1.left, null);
            node.right = merge(t1.right, null);
        } else {
            node = new TreeNode(t1.val + t2.val);
            node.left = merge(t1.left, t2.left);
            node.right = merge(t1.right, t2.right);
        }

        return node;
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
