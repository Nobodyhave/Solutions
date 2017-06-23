package leetcode;

/**
 * Created by Aleksandr on 22/06/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree
 */
public class ConvertSortedArrayToBinarySearchTree {
    public TreeNode sortedArrayToBST(int[] nums) {
        return createTree(nums, 0, nums.length - 1);
    }

    private static TreeNode createTree(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        } else if (start == end) {
            return new TreeNode(nums[start]);
        }

        final int mid = start + (end - start) / 2;
        final TreeNode root = new TreeNode(nums[mid]);
        root.left = createTree(nums, start, mid - 1);
        root.right = createTree(nums, mid + 1, end);

        return root;
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
