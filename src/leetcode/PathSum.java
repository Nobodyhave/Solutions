package leetcode;

/**
 * Created by Aleksandr on 23/06/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/path-sum
 */
public class PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        return root != null && hasPathSumHelper(root, sum, 0);

    }

    private boolean hasPathSumHelper(TreeNode root, int sum, int currentSum) {
        if (root.left == null && root.right == null) {
            return currentSum + root.val == sum;
        } else if (root.left == null) {
            return hasPathSumHelper(root.right, sum, currentSum + root.val);
        } else if (root.right == null) {
            return hasPathSumHelper(root.left, sum, currentSum + root.val);
        } else {
            return hasPathSumHelper(root.right, sum, currentSum + root.val) || hasPathSumHelper(root.left, sum, currentSum + root.val);
        }
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
