package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aleksandr on 13/06/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/binary-tree-level-order-traversal
 */
public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        final List<List<Integer>> result = new ArrayList<>();
        List<TreeNode> current = new ArrayList<>();
        List<TreeNode> next = new ArrayList<>();
        current.add(root);

        while (!current.isEmpty()) {
            final List<Integer> vals = new ArrayList<>();
            for (TreeNode node : current) {
                vals.add(node.val);
                if (node.left != null) {
                    next.add(node.left);
                }
                if (node.right != null) {
                    next.add(node.right);
                }
            }

            result.add(vals);

            final List<TreeNode> temp = current;
            current = next;
            next = temp;
            next.clear();
        }

        return result;
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
