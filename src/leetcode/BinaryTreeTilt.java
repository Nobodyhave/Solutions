package leetcode;

/**
 * Created by Aleksandr on 05/10/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/binary-tree-tilt
 */
public class BinaryTreeTilt {
    public int findTilt(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return postOrder(root)[0];
    }

    private int[] postOrder(TreeNode root) {
        if (root == null) {
            return new int[]{0, 0};
        }

        final int[] left = postOrder(root.left);
        final int[] right = postOrder(root.right);

        final int tilt = Math.abs(left[1] - right[1]);
        left[0] += right[0] + tilt;
        left[1] += right[1] + root.val;

        return left;
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
