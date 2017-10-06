package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aleksandr on 03/10/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/minimum-absolute-difference-in-bst
 */
public class MinimumAbsoluteDifferenceInBst {
    public int getMinimumDifference(TreeNode root) {
        if (root == null) {
            return 0;
        } else if (root.left == null && root.right == null) {
            return 0;
        }

        final List<Integer> nums = new ArrayList<>();
        inorder(root, nums);

        int min = Integer.MAX_VALUE;
        for (int i = 1; i < nums.size(); i++) {
            min = Math.min(min, nums.get(i) - nums.get(i - 1));
        }

        return min;
    }

    private void inorder(TreeNode root, List<Integer> nums) {
        if (root == null) {
            return;
        }
        inorder(root.left, nums);
        nums.add(root.val);
        inorder(root.right, nums);
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
