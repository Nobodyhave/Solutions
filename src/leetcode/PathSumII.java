package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aleksandr on 23/06/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/path-sum-ii
 */
public class PathSumII {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();

        hasPathSumHelper(root, result, new ArrayList<Integer>(), sum, 0);

        return result;
    }

    private void hasPathSumHelper(TreeNode root, List<List<Integer>> result, List<Integer> path, int sum, int currentSum) {
        if (root == null) {
            return;
        } else if (root.left == null && root.right == null) {
            if (currentSum + root.val == sum) {
                path.add(root.val);
                result.add(new ArrayList<>(path));
                path.remove(path.size() - 1);
            }
        } else if (root.left == null) {
            path.add(root.val);
            hasPathSumHelper(root.right, result, path, sum, currentSum + root.val);
            path.remove(path.size() - 1);
        } else if (root.right == null) {
            path.add(root.val);
            hasPathSumHelper(root.left, result, path, sum, currentSum + root.val);
            path.remove(path.size() - 1);
        } else {
            path.add(root.val);
            hasPathSumHelper(root.right, result, path, sum, currentSum + root.val);
            hasPathSumHelper(root.left, result, path, sum, currentSum + root.val);
            path.remove(path.size() - 1);
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
