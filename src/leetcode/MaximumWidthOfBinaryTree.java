package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Aleksandr on 25/10/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/maximum-width-of-binary-tree
 */
public class MaximumWidthOfBinaryTree {
    private Map<Integer, Integer> minPerLevel = new HashMap<>();
    private Map<Integer, Integer> maxPerLevel = new HashMap<>();

    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        dfs(root, 0, 0);

        int maxWidth = Integer.MIN_VALUE;
        int level = 0;
        while (true) {
            final Integer min = minPerLevel.get(level);
            final Integer max = maxPerLevel.get(level);

            if (min == null || max == null) {
                break;
            }

            if (min == Integer.MAX_VALUE || max == Integer.MIN_VALUE) {
                maxWidth = Math.max(maxWidth, 1);
            } else {
                maxWidth = Math.max(maxWidth, Math.abs(max - min + 1));
            }
            level++;
        }

        return maxWidth;
    }

    private void dfs(TreeNode root, int level, int index) {
        if (root == null) {
            return;
        }

        minPerLevel.put(level, Math.min(index, minPerLevel.getOrDefault(level, Integer.MAX_VALUE)));
        maxPerLevel.put(level, Math.max(index, maxPerLevel.getOrDefault(level, Integer.MIN_VALUE)));

        dfs(root.left, level + 1, 2 * index);
        dfs(root.right, level + 1, 2 * index + 1);
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
