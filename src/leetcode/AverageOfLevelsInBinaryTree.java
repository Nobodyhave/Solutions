package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aleksandr on 18/10/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/average-of-levels-in-binary-tree
 */
public class AverageOfLevelsInBinaryTree {
    public List<Double> averageOfLevels(TreeNode root) {
        final List<Double> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        final List<List<Integer>> lists = new ArrayList<>();
        dfs(root, lists, 0);

        for (List<Integer> list : lists) {
            result.add(average(list));
        }

        return result;
    }

    private void dfs(TreeNode root, List<List<Integer>> values, int depth) {
        if (root == null) {
            return;
        }

        if (depth == values.size()) {
            values.add(new ArrayList<>());
        }

        values.get(depth).add(root.val);

        dfs(root.left, values, depth + 1);
        dfs(root.right, values, depth + 1);
    }

    private double average(List<Integer> list) {
        double result = 0;
        for (Integer num : list) {
            result += num;
        }

        return result / list.size();
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
