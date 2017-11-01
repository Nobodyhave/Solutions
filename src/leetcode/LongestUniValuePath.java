package leetcode;

/**
 * Created by Aleksandr on 01/11/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/longest-univalue-path
 */
public class LongestUniValuePath {
    private int maxVal;

    public int longestUnivaluePath(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return Math.max(dfs(root), maxVal);
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftLength = dfs(root.left);
        int rightLength = dfs(root.right);

        if (root.left != null && root.left.val == root.val) {
            leftLength++;
        } else {
            maxVal = Math.max(maxVal, leftLength);
            leftLength = 0;
        }
        if (root.right != null && root.right.val == root.val) {
            rightLength++;
        } else {
            maxVal = Math.max(maxVal, rightLength);
            rightLength = 0;
        }
        int max = Math.max(leftLength, rightLength);
        if (root.left != null && root.right != null && root.val == root.left.val && root.val == root.right.val) {
            maxVal = Math.max(maxVal, leftLength + rightLength);
        }

        return max;
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
