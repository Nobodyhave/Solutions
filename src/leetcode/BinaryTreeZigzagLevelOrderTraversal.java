package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aleksandr on 14/06/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal
 */
public class BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        final List<List<Integer>> result = new ArrayList<>();
        List<TreeNode> current = new ArrayList<>();
        List<TreeNode> next = new ArrayList<>();
        current.add(root);

        boolean dirRight = true;
        while (!current.isEmpty()) {
            final List<Integer> vals = new ArrayList<>();
            for (int i = current.size() - 1; i >= 0; i--) {
                final TreeNode node = current.get(i);
                vals.add(node.val);
                if(dirRight) {
                    if (node.left != null) {
                        next.add(node.left);
                    }
                    if (node.right != null) {
                        next.add(node.right);
                    }
                } else {
                    if (node.right != null) {
                        next.add(node.right);
                    }
                    if (node.left != null) {
                        next.add(node.left);
                    }
                }
            }

            result.add(vals);

            final List<TreeNode> temp = current;
            current = next;
            next = temp;
            next.clear();
            dirRight = !dirRight;
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
