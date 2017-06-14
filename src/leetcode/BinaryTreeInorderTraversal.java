package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aleksandr on 08/06/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/binary-tree-inorder-traversal
 */
public class BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        final List<Integer> result = new ArrayList<>();

        dfs(result, root);

        return result;
    }

    private static void dfs(List<Integer> result, TreeNode root) {
        if (root == null) {
            return;
        }

        dfs(result, root.left);
        result.add(root.val);
        dfs(result, root.right);
    }

    private static class TreeNode {
        private int val;
        private TreeNode left;
        private TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
