package hackerrank.tutorial.cracking_the_coding_interview;

/**
 * Created by Aleksandr on 20/10/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/ctci-is-binary-search-tree
 */
public class IsThisBinaryTree {

    boolean checkBst(Node root) {
        return root == null || innerCheckBst(root).isBst;

    }

    Entry innerCheckBst(Node root) {
        if (root.left == null && root.right == null) {
            return new Entry(root.data, root.data, true);
        } else if (root.left == null) {
            final Entry right = innerCheckBst(root.right);
            right.isBst = right.isBst && root.data < right.min;
            right.min = Math.min(root.data, right.min);
            right.max = Math.max(root.data, right.max);
            return right;
        } else if (root.right == null) {
            final Entry left = innerCheckBst(root.left);
            left.isBst = left.isBst && root.data > left.max;
            left.min = Math.min(root.data, left.min);
            left.max = Math.max(root.data, left.max);
            return left;
        } else {
            final Entry left = innerCheckBst(root.left);
            left.isBst = left.isBst && root.data > left.max;
            left.min = Math.min(root.data, left.min);
            left.max = Math.max(root.data, left.max);

            final Entry right = innerCheckBst(root.right);
            right.isBst = right.isBst && root.data < right.min;
            right.min = Math.min(root.data, right.min);
            right.max = Math.max(root.data, right.max);

            return new Entry(
                    Math.min(left.min, right.min),
                    Math.max(left.max, right.max),
                    left.isBst & right.isBst);
        }
    }

    private static class Node {
        private int data;
        private Node left;
        private Node right;
    }

    private static class Entry {
        private int min;
        private int max;
        private boolean isBst;

        public Entry(int min, int max, boolean isBst) {
            this.min = min;
            this.max = max;
            this.isBst = isBst;
        }
    }
}
