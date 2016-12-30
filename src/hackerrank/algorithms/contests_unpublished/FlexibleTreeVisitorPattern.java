package hackerrank.algorithms.contests_unpublished;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Aleksandr on 30/12/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/contests/ncr-codesprint/challenges/flexible-tree-visitor-pattern
 */

enum Color {
    RED, GREEN
}

abstract class Tree {

    private int value;
    private Color color;
    private int depth;

    public Tree(int value, Color color, int depth) {
        this.value = value;
        this.color = color;
        this.depth = depth;
    }

    public int getValue() {
        return value;
    }

    public Color getColor() {
        return color;
    }

    public int getDepth() {
        return depth;
    }

    public abstract void accept(TreeVis visitor);
}

class TreeNode extends Tree {

    private ArrayList<Tree> children = new ArrayList<>();

    public TreeNode(int value, Color color, int depth) {
        super(value, color, depth);
    }

    public void accept(TreeVis visitor) {
        visitor.visitNode(this);

        for (Tree child : children) {
            child.accept(visitor);
        }
    }

    public void addChild(Tree child) {
        children.add(child);
    }
}

class TreeLeaf extends Tree {

    public TreeLeaf(int value, Color color, int depth) {
        super(value, color, depth);
    }

    public void accept(TreeVis visitor) {
        visitor.visitLeaf(this);
    }
}

abstract class TreeVis {
    public abstract int getResult();

    public abstract void visitNode(TreeNode node);

    public abstract void visitLeaf(TreeLeaf leaf);

}

class SumInLeavesVisitor extends TreeVis {
    private int result;

    public int getResult() {
        return result;
    }

    public void visitNode(TreeNode node) {
        // Do nothing
    }

    public void visitLeaf(TreeLeaf leaf) {
        result += leaf.getValue();
    }
}

class ProductOfRedNodesVisitor extends TreeVis {
    private BigInteger product = BigInteger.ONE;

    public int getResult() {
        return product.mod(BigInteger.valueOf(1000000007)).intValue();
    }

    public void visitNode(TreeNode node) {
        if (node.getColor() == Color.RED) {
            product = product.multiply(BigInteger.valueOf(node.getValue())).mod(BigInteger.valueOf(1000000007));
        }
    }

    public void visitLeaf(TreeLeaf leaf) {
        if (leaf.getColor() == Color.RED) {
            product = product.multiply(BigInteger.valueOf(leaf.getValue())).mod(BigInteger.valueOf(1000000007));
        }
    }
}

class FancyVisitor extends TreeVis {
    private int result;

    public int getResult() {
        return Math.abs(result);
    }

    public void visitNode(TreeNode node) {
        if (node.getDepth() % 2 == 0) {
            result += node.getValue();
        }
    }

    public void visitLeaf(TreeLeaf leaf) {
        if (leaf.getColor() == Color.GREEN) {
            result -= leaf.getValue();
        }
    }
}

public class FlexibleTreeVisitorPattern {

    public static Tree solve() {
        final Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] x = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            x[i] = in.nextInt();
        }
        Color[] c = new Color[n + 1];
        for (int i = 1; i <= n; i++) {
            c[i] = in.nextInt() == 0 ? Color.RED : Color.GREEN;
        }

        List<Integer>[] nodes = (List<Integer>[]) new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            nodes[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            int v = in.nextInt();
            int w = in.nextInt();

            nodes[v].add(w);
            nodes[w].add(v);
        }

        boolean[] marked = new boolean[n + 1];
        marked[1] = true;

        return dfs(1, nodes, x, c, marked, 0);
    }

    public static void main(String[] args) {
        Tree root = solve();
        SumInLeavesVisitor vis1 = new SumInLeavesVisitor();
        ProductOfRedNodesVisitor vis2 = new ProductOfRedNodesVisitor();
        FancyVisitor vis3 = new FancyVisitor();

        root.accept(vis1);
        root.accept(vis2);
        root.accept(vis3);

        int res1 = vis1.getResult();
        int res2 = vis2.getResult();
        int res3 = vis3.getResult();

        System.out.println(res1);
        System.out.println(res2);
        System.out.println(res3);
    }

    private static Tree dfs(int node, List<Integer>[] nodes, int[] x, Color[] c, boolean[] marked, int depth) {
        List<Integer> adj = nodes[node];

        if (adj.size() == 1) {
            return new TreeLeaf(x[node], c[node], depth);
        }

        TreeNode newNode = new TreeNode(x[node], c[node], depth);
        adj.stream().filter(w -> !marked[w]).forEach(w -> {
            marked[w] = true;
            newNode.addChild(dfs(w, nodes, x, c, marked, depth + 1));
        });

        return newNode;
    }
}
