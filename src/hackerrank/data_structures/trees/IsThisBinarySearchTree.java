package hackerrank.data_structures.trees;

/**
 * Created by Aleksandr on 24/01/2017.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/is-binary-search-tree
 */
public class IsThisBinarySearchTree {
    boolean checkBST(Node root) {
        return dfs(root).correct;
    }

    Pair dfs(Node root) {
        if (root.left == null && root.right == null) {
            Pair pair = new Pair();
            pair.min = root.data;
            pair.max = root.data;
            return pair;
        } else if (root.left == null) {
            Pair pair = new Pair();
            Pair right = dfs(root.right);
            pair.min = Math.min(right.min, root.data);
            pair.max = Math.max(right.max, root.data);
            pair.correct = right.correct && (root.data < right.min);
            return pair;
        } else if (root.right == null) {
            Pair pair = new Pair();
            Pair left = dfs(root.left);
            pair.min = Math.min(left.min, root.data);
            pair.max = Math.max(left.max, root.data);
            pair.correct = left.correct && (root.data > left.max);
            return pair;
        } else {
            Pair pair = new Pair();
            Pair right = dfs(root.right);
            pair.min = Math.min(right.min, root.data);
            pair.max = Math.max(right.max, root.data);
            pair.correct = right.correct && (root.data < right.min);

            Pair left = dfs(root.left);
            pair.min = Math.min(left.min, pair.min);
            pair.max = Math.max(left.max, pair.max);
            pair.correct = pair.correct && left.correct && (root.data > left.max);

            return pair;
        }
    }

    private static class Pair {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        boolean correct = true;
    }

    private static class Node {
        int data;
        Node left;
        Node right;
    }
}
