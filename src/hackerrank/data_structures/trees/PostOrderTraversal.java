package hackerrank.data_structures.trees;

/**
 * Created by Aleksandr on 24/01/2017.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/tree-postorder-traversal
 */
public class PostOrderTraversal {
    void postOrder(Node root) {
        if (root == null) {
            return;
        }

        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }

    private static class Node {
        int data;
        Node left;
        Node right;
    }
}
