package hackerrank.data_structures.trees;

/**
 * Created by Aleksandr on 24/01/2017.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/tree-inorder-traversal
 */
public class InOrderTraversal {
    void inOrder(Node root) {
        if (root == null) {
            return;
        }

        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    private static class Node {
        int data;
        Node left;
        Node right;
    }
}
