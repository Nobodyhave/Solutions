package hackerrank.data_structures.trees;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by Aleksandr on 24/01/2017.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/tree-level-order-traversal
 */
public class LevelOrderTraversal {
    void LevelOrder(Node root) {
        if (root == null) {
            return;
        }

        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            System.out.print(node.data + " ");
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }

    }

    class Node {
        int data;
        Node left;
        Node right;
    }
}
