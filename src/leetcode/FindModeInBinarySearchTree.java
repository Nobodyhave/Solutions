package leetcode;

/**
 * Created by Aleksandr on 26/09/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/find-mode-in-binary-search-tree
 */
public class FindModeInBinarySearchTree {
    private int currVal;
    private int currCount = 0;
    private int maxCount = 0;
    private int modeCount = 0;
    private int[] modes;

    public int[] findMode(TreeNode root) {
        inorder(root);
        modes = new int[modeCount];
        modeCount = 0;
        currCount = 0;
        inorder(root);
        return modes;
    }

    private void handleValue(int val) {
        if (val != currVal) {
            currVal = val;
            currCount = 0;
        }
        currCount++;
        if (currCount > maxCount) {
            maxCount = currCount;
            modeCount = 1;
        } else if (currCount == maxCount) {
            if (modes != null)
                modes[modeCount] = currVal;
            modeCount++;
        }
    }

    private void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        handleValue(root.val);
        inorder(root.right);
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
