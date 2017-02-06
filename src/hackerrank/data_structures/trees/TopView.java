package hackerrank.data_structures.trees;

/**
 * Created by Aleksandr on 24/01/2017.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/tree-top-view
 */
public class TopView {
    void top_view(Node root) {
        if (root == null) {
            return;
        }

        left(root.left);
        System.out.print(root.data + " ");
        right(root.right);
    }

    private void left(Node left) {
        if (left == null) {
            return;
        }

        left(left.left);
        System.out.print(left.data + " ");
    }

    private void right(Node right) {
        if (right == null) {
            return;
        }

        System.out.print(right.data + " ");
        right(right.right);
    }

    private static class Node {
        int data;
        Node left;
        Node right;
    }
}
