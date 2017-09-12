package leetcode;

/**
 * Created by Aleksandr on 07/09/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/sum-of-left-leaves
 */
public class SumOfLeftLeaves {
    public int sumOfLeftLeaves(TreeNode root) {
        return sum(root, false);
    }

    private int sum(TreeNode root, boolean isLeft) {
        if (root == null) {
            return 0;
        } else if (root.left == null && root.right == null) {
            return isLeft ? root.val : 0;
        } else {
            return sum(root.left, true) + sum(root.right, false);
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
