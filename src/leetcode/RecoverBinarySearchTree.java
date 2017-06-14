package leetcode;

/**
 * Created by Aleksandr on 12/06/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/recover-binary-search-tree
 */
public class RecoverBinarySearchTree {
    private TreeNode swap1, swap2, prev = new TreeNode(Integer.MIN_VALUE);

    public void recoverTree(TreeNode root) {
        if (root == null) {
            return;
        }

        dfs(root);

        int temp = swap1.val;
        swap1.val = swap2.val;
        swap2.val = temp;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }

        dfs(root.left);

        if (swap1 == null && prev.val >= root.val) {
            swap1 = prev;
        }

        if (swap1 != null && prev.val >= root.val) {
            swap2 = root;
        }

        prev = root;

        dfs(root.right);
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
