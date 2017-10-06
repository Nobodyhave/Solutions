package leetcode;

/**
 * Created by Aleksandr on 06/10/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/subtree-of-another-tree
 */
public class SubtreeOfAnotherTree {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        return s != null && t != null && dfs(s, t);
    }

    private boolean dfs(TreeNode s, TreeNode t) {
        return s != null
                && (s.val == t.val
                && isSameTree(s, t)
                || dfs(s.left, t)
                || dfs(s.right, t));

    }

    private boolean isSameTree(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        } else if (s == null || t == null) {
            return false;
        } else if (s.val != t.val) {
            return false;
        }

        return isSameTree(s.left, t.left) && isSameTree(s.right, t.right);
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
