package hackerrank.data_structures.trees;

/**
 * Created by Aleksandr on 24/01/2017.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/binary-search-tree-lowest-common-ancestor
 */
public class BinarySearchTreeLowestCommonAncestor {
    static Node lca(Node root, int v1, int v2) {
        if (root == null) {
            return null;
        }

        if (root.data == v1 || root.data == v2) {
            return root;
        }

        Node left = lca(root.left, v1, v2);
        Node right = lca(root.right, v1, v2);

        if (left != null && right != null) {
            return root;
        } else {
            return (left != null ? left : right);
        }
    }

    private static class Node {
        int data;
        Node left;
        Node right;
    }
}
