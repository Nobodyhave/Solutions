package leetcode;

/**
 * Created by Aleksandr on 26/06/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/binary-tree-maximum-path-sum
 */
public class BinaryTreeMaxPathSum {
    private int bestSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }

        maxPathSumHelper(root);

        return bestSum;
    }

    private int maxPathSumHelper(TreeNode root) {
        if (root.left == null && root.right == null) {
            bestSum = Math.max(bestSum, root.val);

            return root.val;
        } else if (root.left == null) {
            int rightSum = maxPathSumHelper(root.right);
            bestSum = Math.max(bestSum, Math.max(root.val, rightSum + root.val));

            return Math.max(root.val, rightSum + root.val);
        } else if (root.right == null) {
            int leftSum = maxPathSumHelper(root.left);
            bestSum = Math.max(bestSum, Math.max(root.val, leftSum + root.val));

            return Math.max(root.val, leftSum + root.val);
        } else {
            int leftSum = maxPathSumHelper(root.left);
            int rightSum = maxPathSumHelper(root.right);

            bestSum = Math.max(bestSum, Math.max(root.val, Math.max(root.val + leftSum + rightSum, Math.max(leftSum + root.val, rightSum + root.val))));

            return Math.max(root.val, Math.max(leftSum + root.val, rightSum + root.val));
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
