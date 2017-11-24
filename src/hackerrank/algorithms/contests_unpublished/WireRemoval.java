package hackerrank.algorithms.contests_unpublished;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Aleksandr on 03/11/2017.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/contests/hourrank-24/challenges/wire-removal
 */
public class WireRemoval {
    public static void main(String[] args) throws FileNotFoundException {
        final Scanner in = new Scanner(System.in);
        final int n = in.nextInt();

        final TreeNode[] nodes = new TreeNode[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = new TreeNode(i);
        }

        for (int i = 0; i < n - 1; i++) {
            int x = in.nextInt();
            int y = in.nextInt();

            nodes[x - 1].children.add(nodes[y - 1]);
            nodes[y - 1].children.add(nodes[x - 1]);
        }

        dfs(nodes[0], new boolean[n], 0);

        double sum = 0.0;
        double count = 0.0;
        for (int i = 1; i < nodes.length; i++) {
            sum += (double) (n - nodes[i].count) * nodes[i].dist;
            count += nodes[i].dist;
        }

        System.out.println(sum / count);

        in.close();
    }

    private static void dfs(TreeNode root, boolean[] marked, int dist) {
        if (root == null) {
            return;
        }

        marked[root.index] = true;
        root.dist = dist;

        for (int i = 0; i < root.children.size(); i++) {
            if (!marked[root.children.get(i).index]) {
                dfs(root.children.get(i), marked, dist + 1);
                root.count += root.children.get(i).count;
            }
        }
    }


    private static class TreeNode {
        private int index;
        private int count = 1;
        private int dist = 0;
        private List<TreeNode> children = new ArrayList<>();

        TreeNode(int index) {
            this.index = index;
        }
    }
}
