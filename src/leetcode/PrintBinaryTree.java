package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aleksandr on 23/10/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/print-binary-tree
 */
public class PrintBinaryTree {
    public List<List<String>> printTree(TreeNode root) {
        final List<List<String>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        final int maxDepth = maxDepth(root);
        final int count = (int) Math.pow(2, maxDepth) - 1;

        for (int i = 0; i < maxDepth; i++) {
            result.add(new ArrayList<>());
            for (int j = 0; j < count; j++) {
                result.get(i).add("");
            }
        }

        fill(result, root, 0, 0, count - 1);

        return result;
    }

    private void fill(List<List<String>> result, TreeNode root, int level, int l, int r) {
        if (root == null) {
            return;
        }

        final int index = l + (r - l) / 2;
        result.get(level).set(index, String.valueOf(root.val));
        fill(result, root.left, level + 1, index - (r - l) / 2, index - 1);
        fill(result, root.right, level + 1, index + 1, index + (r - l) / 2);
    }

    private int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
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
