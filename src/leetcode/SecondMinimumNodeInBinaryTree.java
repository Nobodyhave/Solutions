package leetcode;

/**
 * Created by Aleksandr on 26/10/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/second-minimum-node-in-a-binary-tree
 */
public class SecondMinimumNodeInBinaryTree {
    private int min = Integer.MAX_VALUE;
    private int secondMin = Integer.MAX_VALUE;

    public int findSecondMinimumValue(TreeNode root) {
        if (root == null) {
            return -1;
        }

        dfs(root);

        return secondMin != Integer.MAX_VALUE ? secondMin : -1;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }

        if (root.val < min) {
            secondMin = min;
            min = root.val;
        } else if (root.val < secondMin && root.val != min) {
            secondMin = root.val;
        }

        dfs(root.left);
        dfs(root.right);
    }

    private static class TreeNode {
        private int val;
        private TreeNode left;
        private TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
