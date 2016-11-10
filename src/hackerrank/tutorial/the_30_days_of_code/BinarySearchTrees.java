package hackerrank.tutorial.the_30_days_of_code;

import java.util.Scanner;

/**
 * Created by Aleksandr on 10/11/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/30-binary-search-trees
 */
public class BinarySearchTrees {
    public static int getHeight(Node root) {
        if (root.left == null && root.right == null) {
            return 0;
        } else if (root.left == null) {
            return getHeight(root.right) + 1;
        } else if (root.right == null) {
            return getHeight(root.left) + 1;
        } else {
            return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
        }
    }

    public static Node insert(Node root, int data) {
        if (root == null) {
            return new Node(data);
        } else {
            Node cur;
            if (data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        Node root = null;
        while (T-- > 0) {
            int data = sc.nextInt();
            root = insert(root, data);
        }
        int height = getHeight(root);
        System.out.println(height);
    }

    private static class Node {
        Node left, right;
        int data;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }
}
