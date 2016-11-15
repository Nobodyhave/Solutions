package hackerrank.algorithms.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Aleksandr on 15/11/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/cut-the-tree
 */
public class CutTheTree {
    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);

        final int N = in.nextInt();
        final int[] weights = new int[N];
        for (int i = 0; i < N; i++) {
            weights[i] = in.nextInt();
        }

        final Graph graph = new Graph(N);
        for (int i = 0; i < N - 1; i++) {
            graph.addEdge(in.nextInt() - 1, in.nextInt() - 1);
        }

        final DepthFirstSearch dfs = new DepthFirstSearch(graph, weights, 0);

        System.out.println(dfs.getMinDiff());
    }

    private static class DepthFirstSearch {
        private boolean[] marked;
        private int[] weights;
        private int[] sumWeights;
        private int minDiff = Integer.MAX_VALUE;

        public DepthFirstSearch(Graph G, int[] weights, int s) {
            marked = new boolean[G.size()];
            sumWeights = new int[G.size()];
            this.weights = weights;

            marked[s] = true;
            sumWeights[s] = dfs1(G, s);

            Arrays.fill(marked, false);
            marked[s] = true;
            dfs2(G, s);
        }

        private int dfs1(Graph G, int v) {
            int sum = weights[v];
            for (Integer w : G.adj(v)) {
                if (!marked[w]) {
                    marked[w] = true;
                    sumWeights[w] = dfs1(G, w);
                    sum += sumWeights[w];
                }
            }

            return sum;
        }

        private void dfs2(Graph G, int v) {
            G.adj(v).stream().filter(w -> !marked[w]).forEach(w -> {
                marked[w] = true;
                minDiff = Math.min(minDiff, Math.abs(sumWeights[0] - 2 * sumWeights[w]));
                dfs2(G, w);
            });
        }

        public int getMinDiff() {
            return minDiff;
        }

    }

    private static class Graph {
        private final int V;
        private List<Integer>[] adj;

        public Graph(int V) {
            this.V = V;
            //noinspection unchecked
            adj = (List<Integer>[]) new ArrayList[V];
            for (int v = 0; v < V; v++) {
                adj[v] = new ArrayList<>();
            }
        }

        public int size() {
            return V;
        }

        public void addEdge(int v, int w) {
            adj[v].add(w);
            adj[w].add(v);
        }

        public List<Integer> adj(int v) {
            return adj[v];
        }
    }
}
