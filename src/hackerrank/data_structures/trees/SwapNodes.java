package hackerrank.data_structures.trees;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by Aleksandr on 24/01/2017.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/swap-nodes-algo
 */
public class SwapNodes {
    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);

        final int N = in.nextInt();

        LinkedList<Node> cur = new LinkedList<>();
        LinkedList<Node> next = new LinkedList<>();
        Node root = new Node();
        root.val = 1;
        cur.add(root);
        int i = 1;
        while (i <= N) {
            while (!cur.isEmpty()) {
                Node curNode = cur.removeFirst();
                int leftVal = in.nextInt();
                if (leftVal != -1) {
                    Node left = new Node();
                    left.val = leftVal;
                    curNode.left = left;
                    next.addLast(left);
                } else {
                    curNode.left = null;
                }

                int rightVal = in.nextInt();
                if (rightVal != -1) {
                    Node right = new Node();
                    right.val = rightVal;
                    curNode.right = right;
                    next.addLast(right);
                } else {
                    curNode.right = null;
                }
                i++;
            }
            LinkedList<Node> temp = cur;
            cur = next;
            next = temp;
        }

        int K = in.nextInt();
        for (i = 0; i < K; i++) {
            int k = in.nextInt();
            swap(root, k, 1);
            printTree(root);
            System.out.println();
        }
    }

    private static void swap(Node root, int height, int curHeight) {
        if (root == null) {
            return;
        }

        if (curHeight % height == 0) {
            Node temp = root.left;
            root.left = root.right;
            root.right = temp;
        }

        swap(root.left, height, curHeight + 1);
        swap(root.right, height, curHeight + 1);
    }

    private static void printTree(Node root) {
        if (root == null) {
            return;
        }

        printTree(root.left);
        System.out.print(root.val + " ");
        printTree(root.right);
    }

    private static class Node {
        int val;
        Node left;
        Node right;
    }
}
