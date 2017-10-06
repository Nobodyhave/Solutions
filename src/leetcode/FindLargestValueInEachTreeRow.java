package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aleksandr on 27/09/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/find-largest-value-in-each-tree-row
 */
public class FindLargestValueInEachTreeRow {
    public List<Integer> largestValues(TreeNode root) {
        final List<Integer> result = new ArrayList<>();
        if (root != null) {
            preorder(root, result, 0);
        }

        return result;
    }

    private void preorder(TreeNode root, List<Integer> result, int depth) {
        if (root == null) {
            return;
        }

        if (depth >= result.size()) {
            result.add(root.val);
        } else {
            result.set(depth, Math.max(result.get(depth), root.val));
        }

        preorder(root.left, result, depth + 1);
        preorder(root.right, result, depth + 1);
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
