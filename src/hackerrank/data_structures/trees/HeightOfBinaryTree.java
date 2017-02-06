package hackerrank.data_structures.trees;

/**
 * Created by Aleksandr on 24/01/2017.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/tree-height-of-a-binary-tree
 */
public class HeightOfBinaryTree {
    int height(Node root) {
        if (root == null) {
            return -1;
        } else {
            return Math.max(height(root.left), height(root.right)) + 1;
        }
    }

    private static class Node {
        int data;
        Node left;
        Node right;
    }
}
