package hackerrank.algorithms.search;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by Aleksandr on 14/11/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/count-luck
 */
public class CountLuck {
    public static void main(String[] args) throws FileNotFoundException {
        //final Scanner in = new Scanner(System.in);
        final Scanner in = new Scanner(new FileInputStream("C:\\Projects\\Solutions\\src\\tests.txt"));

        final int T = in.nextInt();
        for (int t = 0; t < T; t++) {
            final int N = in.nextInt();
            final int M = in.nextInt();
            final char[][] cells = new char[N][M];
            for (int i = 0; i < N; i++) {
                final String s = in.next();
                for (int j = 0; j < M; j++) {
                    cells[i][j] = s.charAt(j);
                }
            }
            final int K = in.nextInt();

            final Graph forest = new Graph(N * M);
            int start = 0, finish = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (cells[i][j] == 'X') {
                        continue;
                    }

                    if (cells[i][j] == 'M') {
                        start = i * M + j;
                    }
                    if (cells[i][j] == '*') {
                        finish = i * M + j;
                    }

                    if (i != 0 && cells[i - 1][j] != 'X') {
                        forest.addEdge(i * M + j, (i - 1) * M + j);
                    }
                    if (j != M - 1 && cells[i][j + 1] != 'X') {
                        forest.addEdge(i * M + j, i * M + j + 1);
                    }
                 }
            }

            final DepthFirstSearch dfs = new DepthFirstSearch(forest, start);

            int count = 0;
            for (Integer cell : dfs.pathTo(finish)) {
                if (cell != finish && forest.degree(cell) > 2 || cell == start && forest.degree(cell) > 1) {
                    count++;
                }
            }

            if (K == count) {
                System.out.println("Impressed");
            } else {
                System.out.println("Oops!");
            }
        }
    }

    private static class DepthFirstSearch {
        private boolean[] marked;
        private int[] edgeTo;
        private final int s;

        public DepthFirstSearch(Graph G, int s) {
            this.s = s;
            edgeTo = new int[G.size()];
            marked = new boolean[G.size()];
            dfs(G, s);
        }

        private void dfs(Graph G, int v) {
            marked[v] = true;
            G.adj(v).stream().filter(w -> !marked[w]).forEach(w -> {
                edgeTo[w] = v;
                dfs(G, w);
            });
        }

        public boolean hasPathTo(int v) {
            return marked[v];
        }

        public Stack<Integer> pathTo(int v) {
            if (!hasPathTo(v)) return null;
            Stack<Integer> path = new Stack<>();
            for (int x = v; x != s; x = edgeTo[x]) {
                path.push(x);
            }
            path.push(s);
            return path;
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

        public int degree(int v) {
            return adj[v].size();
        }
    }
}
