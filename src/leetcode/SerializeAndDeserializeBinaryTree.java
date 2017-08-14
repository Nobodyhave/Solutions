package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aleksandr on 14/08/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/serialize-and-deserialize-binary-tree
 */
public class SerializeAndDeserializeBinaryTree {
    public String serialize(TreeNode root) {
        List<TreeNode> cur = new ArrayList<>();
        List<TreeNode> next = new ArrayList<>();
        final StringBuilder sb = new StringBuilder();

        cur.add(root);
        while (!cur.isEmpty()) {
            for (TreeNode node : cur) {
                if (node == null) {
                    sb.append("null").append(',');
                } else {
                    sb.append(node.val).append(',');
                    next.add(node.left);
                    next.add(node.right);
                }
            }

            List<TreeNode> temp = cur;
            cur = next;
            next = temp;
            next.clear();
        }
        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
        }

        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.length() == 0) {
            return null;
        }

        final String[] nodes = data.split(",");

        if (nodes[0].equals("null")) {
            return null;
        }

        List<TreeNode> cur = new ArrayList<>();
        List<TreeNode> next = new ArrayList<>();
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));

        cur.add(root);

        int i = 1;
        while (i < nodes.length && !cur.isEmpty()) {
            for (TreeNode node : cur) {
                Integer leftVal = !nodes[i].equals("null") ? Integer.parseInt(nodes[i]) : null;
                i++;
                Integer rightVal = !nodes[i].equals("null") ? Integer.parseInt(nodes[i]) : null;
                i++;

                node.left = leftVal != null ? new TreeNode(leftVal) : null;
                node.right = rightVal != null ? new TreeNode(rightVal) : null;

                if (node.left != null) {
                    next.add(node.left);
                }
                if (node.right != null) {
                    next.add(node.right);
                }
            }

            List<TreeNode> temp = cur;
            cur = next;
            next = temp;
            next.clear();
        }

        return root;
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
