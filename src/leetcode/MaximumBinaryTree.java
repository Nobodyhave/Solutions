package leetcode;

/**
 * Created by Aleksandr on 23/10/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/maximum-binary-tree
 */
public class MaximumBinaryTree {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }

        return constructTree(nums, 0, nums.length - 1);
    }

    private TreeNode constructTree(int[] nums, int l, int r) {
        if (l > r) {
            return null;
        } else if (l == r) {
            return new TreeNode(nums[l]);
        }

        final int maxIndex = findMaxIndex(nums, l, r);
        final TreeNode node = new TreeNode(nums[maxIndex]);
        node.left = constructTree(nums, l, maxIndex - 1);
        node.right = constructTree(nums, maxIndex + 1, r);

        return node;
    }

    private int findMaxIndex(int[] nums, int l, int r) {
        int max = Integer.MIN_VALUE;
        int maxIndex = l;
        for (int i = l; i <= r; i++) {
            if (nums[i] > max) {
                max = nums[i];
                maxIndex = i;
            }
        }

        return maxIndex;
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
