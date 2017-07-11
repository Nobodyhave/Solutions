package leetcode;

/**
 * Created by Aleksandr on 11/07/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/house-robber-iii
 */
public class HouseRobberIII {
    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }

        final int[] result = dfs(root);

        return Math.max(result[0], result[1]);
    }

    private static int[] dfs(TreeNode root) {
        final int[] result = new int[2];
        if (root == null) {
            return result;
        } else if (root.left == null && root.right == null) {
            result[0] = root.val;
        } else if (root.left == null) {
            int[] right = dfs(root.right);
            result[1] = Math.max(right[0], right[1]);
            result[0] = Math.max(right[1] + root.val, right[0]);
        } else if (root.right == null) {
            int[] left = dfs(root.left);
            result[1] = Math.max(left[0], left[1]);
            result[0] = Math.max(left[1] + root.val, left[0]);
        } else {
            int[] left = dfs(root.left);
            int[] right = dfs(root.right);
            result[1] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
            result[0] = Math.max(left[1] + right[1] + root.val, left[0] + right[0]);
        }

        return result;
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
