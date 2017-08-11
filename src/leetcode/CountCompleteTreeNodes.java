package leetcode;

/**
 * Created by Aleksandr on 17/07/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/count-complete-tree-nodes
 */
public class CountCompleteTreeNodes {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int depth = 0;
        TreeNode right = root;
        while (right != null) {
            right = right.right;
            depth++;
        }

        int start = 0, end = (int) Math.pow(2, depth - 1) - 1, maxFull = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;

            TreeNode node = getBottomNode(root, mid, depth - 2);
            if (node.left == null && node.right == null) {
                end = mid - 1;
            } else if (node.left != null && node.right != null) {
                start = mid + 1;
                maxFull = mid;
            } else {
                return (int) Math.pow(2, depth) + mid * 2;
            }
        }

        return (int) Math.pow(2, depth) - 1 + (maxFull + 1) * 2;
    }

    private TreeNode getBottomNode(TreeNode root, int num, int steps) {
        while (steps >= 0) {
            if ((num & (1 << steps)) != 0) {
                root = root.right;
            } else {
                root = root.left;
            }
            steps--;
        }
        return root;
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
