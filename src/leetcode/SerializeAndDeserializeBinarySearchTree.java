package leetcode;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Aleksandr on 14/09/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/serialize-and-deserialize-bst
 */
public class SerializeAndDeserializeBinarySearchTree {
    public String serialize(TreeNode root) {
        if (root == null) {
            return "n";
        }

        final Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        final StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            final TreeNode node = queue.poll();
            if (node == null) {
                sb.append("n, ");
                continue;
            }
            sb.append(node.val).append(", ");

            queue.add(node.left);
            queue.add(node.right);
        }

        if (sb.length() != 0) {
            sb.deleteCharAt(sb.length() - 1);
            sb.deleteCharAt(sb.length() - 1);
        }

        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if ("n".equals(data)) {
            return null;
        }

        final String[] nodes = data.split(", ");
        int i = 0;
        final TreeNode root = new TreeNode(Integer.parseInt(nodes[i]));
        final Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        i++;
        while (!queue.isEmpty()) {
            final TreeNode node = queue.poll();

            if (!"n".equals(nodes[i])) {
                node.left = new TreeNode(Integer.parseInt(nodes[i]));
                queue.add(node.left);
            } else {
                node.left = null;
            }
            i++;


            if (!"n".equals(nodes[i])) {
                node.right = new TreeNode(Integer.parseInt(nodes[i]));
                queue.add(node.right);
            } else {
                node.right = null;
            }
            i++;
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
