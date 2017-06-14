package leetcode;

/**
 * Created by Aleksandr on 09/06/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/validate-binary-search-tree
 */
public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }

        return dfs(root)[0] == 1;
    }

    // Returns int[] {valid, min, max}
    private static int[] dfs(TreeNode root) {
        if (root.left == null && root.right == null) {
            return new int[]{1, root.val, root.val};
        } else if (root.left == null) {
            final int[] right = dfs(root.right);
            right[0] &= root.val < right[1] ? 1 : 0;
            right[1] = Math.min(right[1], root.val);
            right[2] = Math.max(right[2], root.val);

            return right;
        } else if (root.right == null) {
            final int[] left = dfs(root.left);
            left[0] &= root.val > left[2] ? 1 : 0;
            left[1] = Math.min(left[1], root.val);
            left[2] = Math.max(left[2], root.val);

            return left;
        } else {
            final int[] right = dfs(root.right);
            final int[] left = dfs(root.left);

            final int[] result = left;
            result[0] = left[0] & right[0] & (root.val > left[2] ? 1 : 0) & (root.val < right[1] ? 1 : 0);
            result[1] = Math.min(root.val, Math.min(left[1], right[1]));
            result[2] = Math.max(root.val, Math.max(left[2], right[2]));

            return result;
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
