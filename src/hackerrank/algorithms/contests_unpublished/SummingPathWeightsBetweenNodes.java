package hackerrank.algorithms.contests_unpublished;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Aleksandr on 24/05/2017.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/contests/101hack49/challenges/summing-the-path-weights-between-nodes
 */
public class SummingPathWeightsBetweenNodes {
    public static void main(String[] args) throws FileNotFoundException {
        //final Scanner in = new Scanner(System.in);
        final Scanner in = new Scanner(new FileInputStream("C:\\Projects\\Solutions\\src\\tests.txt"));
        final int n = in.nextInt();
        final int[] C = new int[n];
        for (int i = 0; i < n; i++) {
            C[i] = in.nextInt();
        }

        final Graph graph = new Graph(n + 1);
        final Edge[] edges = new Edge[n];
        for (int i = 0; i < n - 1; i++) {
            int u = in.nextInt();
            int v = in.nextInt();
            int w = in.nextInt();

            graph.addEdge(u, v);
            edges[i + 1] = new Edge(u, v, w);
        }

        final Dfs dfs = new Dfs(C, graph, 1);

        long result = 0;
        for (Edge edge : edges) {
            if (edge == null) {
                continue;
            }

            int v = edge.u;
            if (dfs.parent[edge.u] != edge.v) {
                v = edge.v;
            }

            result += ((dfs.counts[0][1] - dfs.counts[0][v]) * dfs.counts[1][v]
                    + (dfs.counts[1][1] - dfs.counts[1][v]) * dfs.counts[0][v]) * edge.w;
        }

        System.out.println(result);
    }

    private static class Dfs {
        private boolean[] marked;
        private long[][] counts;
        private int[] parent;

        Dfs(int[] C, Graph graph, int start) {
            marked = new boolean[graph.size()];
            counts = new long[2][graph.size()];
            parent = new int[graph.size()];

            marked[start] = true;
            dfs(C, graph, start);
        }

        private void dfs(int[] C, Graph graph, int start) {
            counts[C[start - 1]][start] = 1;
            graph.adj(start).stream().filter(w -> !marked[w]).forEach(w ->
                    {
                        marked[w] = true;
                        parent[w] = start;
                        dfs(C, graph, w);
                        counts[0][start] += counts[0][w];
                        counts[1][start] += counts[1][w];
                    }
            );
        }
    }

    private static class Edge {
        private int u;
        private int v;
        private int w;

        Edge(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
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

        void addEdge(int u, int v) {
            adj[u].add(v);
            adj[v].add(u);
        }

        public List<Integer> adj(int v) {
            return adj[v];
        }
    }
}
