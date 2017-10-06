package leetcode;

/**
 * Created by Aleksandr on 27/09/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/find-bottom-left-tree-value
 */
public class FindBottomLeftTreeValue {
    private int maxDepth = -1;
    private int value = 0;

    public int findBottomLeftValue(TreeNode root) {
        if (root == null) {
            return 0;
        }

        inorder(root, 0);

        return value;
    }

    private void inorder(TreeNode root, int depth) {
        if (root == null) {
            return;
        }

        if (depth > maxDepth) {
            value = root.val;
            maxDepth = depth;
        }

        inorder(root.left, depth + 1);
        inorder(root.right, depth + 1);
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
