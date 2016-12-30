package hackerrank.algorithms.contests_unpublished;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Aleksandr on 30/12/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/contests/world-codesprint-8/challenges/torque-and-development
 */
public class RoadsAndLibraries {
    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);
        final int q = in.nextInt();
        for (int a0 = 0; a0 < q; a0++) {
            final int n = in.nextInt();
            final int m = in.nextInt();
            final int cLib = in.nextInt();
            final int cRoad = in.nextInt();
            final Graph graph = new Graph(n + 1);
            for (int a1 = 0; a1 < m; a1++) {
                int city_1 = in.nextInt();
                int city_2 = in.nextInt();
                graph.addEdge(city_1, city_2);
            }

            final ConnectedComponents cc = new ConnectedComponents(graph);
            long cost = 0;

            for (int i = 1; i < cc.size.length; i++) {
                if (cc.size[i] != 0) {
                    long libsCost = cLib * cc.size[i];
                    long roadsCost = cRoad * (cc.size[i] - 1) + cLib;

                    if (libsCost <= roadsCost) {
                        cost += libsCost;
                    } else {
                        cost += roadsCost;
                    }
                }
            }

            System.out.println(cost);
        }
    }

    private static class Graph {
        private final int V;
        private int E;
        private List<Integer>[] adj;

        public Graph(int V) {
            this.V = V;
            this.E = 0;
            //noinspection unchecked
            adj = (List<Integer>[]) new ArrayList[V];
            for (int v = 0; v < V; v++) {
                adj[v] = new ArrayList<>();
            }
        }

        public int size() {
            return V;
        }

        public int E() {
            return E;
        }

        public void addEdge(int v, int w) {
            E++;
            adj[v].add(w);
            adj[w].add(v);
        }

        public List<Integer> adj(int v) {
            return adj[v];
        }

        public int degree(int v) {
            return adj[v].size();
        }
    }

    private static class ConnectedComponents {
        private boolean[] marked;
        private int[] id;
        private int[] size;
        private int count;

        public ConnectedComponents(Graph G) {
            marked = new boolean[G.size()];
            id = new int[G.size()];
            size = new int[G.size()];
            for (int v = 0; v < G.size(); v++) {
                if (!marked[v]) {
                    dfs(G, v);
                    count++;
                }
            }
        }

        private void dfs(Graph G, int v) {
            marked[v] = true;
            id[v] = count;
            size[count]++;
            G.adj(v).stream().filter(w -> !marked[w]).forEach(w -> dfs(G, w));
        }

        public int id(int v) {
            return id[v];
        }

        public int size(int v) {
            return size[id[v]];
        }

        public int count() {
            return count;
        }

        public boolean connected(int v, int w) {
            return id(v) == id(w);
        }

        public boolean areConnected(int v, int w) {
            return id(v) == id(w);
        }
    }
}
