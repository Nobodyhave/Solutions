package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aleksandr on 19/07/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/binary-tree-paths
 */
public class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        final List<String> result = new ArrayList<>();

        dfs(root, result, "");

        return result;
    }

    private static void dfs(TreeNode root, List<String> result, String path) {
        if (root == null) {
            return;
        }

        if (path.isEmpty()) {
            path = path + root.val;
        } else {
            path = path + "->" + root.val;
        }

        if (root.left == null && root.right == null) {
            result.add(path);
            return;
        }

        dfs(root.left, result, path);
        dfs(root.right, result, path);
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
