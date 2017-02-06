package hackerrank.data_structures.trees;

/**
 * Created by Aleksandr on 24/01/2017.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/binary-search-tree-insertion
 */
public class BinarySearchTreeInsertion {

    static Node Insert(Node root, int value) {
        if (root == null) {
            Node node = new Node();
            node.data = value;
            return node;
        }

        if (value < root.data) {
            root.left = Insert(root.left, value);
        } else {
            root.right = Insert(root.right, value);
        }

        return root;
    }

    private static class Node {
        int data;
        Node left;
        Node right;
    }
}



