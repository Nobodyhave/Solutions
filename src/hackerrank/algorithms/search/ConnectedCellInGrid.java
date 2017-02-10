package hackerrank.algorithms.search;

/**
 * Created by Aleksandr on 24/10/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/ctci-connected-cell-in-a-grid
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConnectedCellInGrid {

    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);
        final int n = in.nextInt();
        final int m = in.nextInt();
        int grid[][] = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = in.nextInt();
            }
        }

        final Graph graph = new Graph(n * m);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] != 1) {
                    continue;
                }

                final int v = i * m + j;
                int w;
                if (i != 0 && j != 0 && grid[i - 1][j - 1] == 1) {
                    w = (i - 1) * m + (j - 1);
                    graph.add(v, w);
                }
                if (i != 0 && grid[i - 1][j] == 1) {
                    w = (i - 1) * m + j;
                    graph.add(v, w);
                }
                if (i != 0 && j != m - 1 && grid[i - 1][j + 1] == 1) {
                    w = (i - 1) * m + (j + 1);
                    graph.add(v, w);
                }
                if (j != m - 1 && grid[i][j + 1] == 1) {
                    w = (i) * m + (j + 1);
                    graph.add(v, w);
                }
                if (i != n - 1 && j != m - 1 && grid[i + 1][j + 1] == 1) {
                    w = (i + 1) * m + (j + 1);
                    graph.add(v, w);
                }
                if (i != n - 1 && grid[i + 1][j] == 1) {
                    w = (i + 1) * m + j;
                    graph.add(v, w);
                }
                if (i != n - 1 && j != 0 && grid[i + 1][j - 1] == 1) {
                    w = (i + 1) * m + (j - 1);
                    graph.add(v, w);
                }
                if (j != 0 && grid[i][j - 1] == 1) {
                    w = (i) * m + (j - 1);
                    graph.add(v, w);
                }
            }
        }
        final DFS dfs = new DFS(graph);

        System.out.println(dfs.getMaxRegion());
    }

    private static class DFS {
        private boolean[] marked;
        private int count;
        private int maxCount;

        public DFS(Graph graph) {
            marked = new boolean[graph.size()];

            for (int i = 0; i < graph.size(); i++) {
                if (!marked[i]) {
                    marked[i] = true;
                    count = 1;
                    dfs(graph, i);
                    maxCount = Math.max(maxCount, count);
                }
            }
        }

        public int getMaxRegion() {
            return maxCount;
        }

        private void dfs(Graph graph, int start) {
            graph.adj(start).stream().filter(v -> !marked[v]).forEach(v -> {
                marked[v] = true;
                count++;
                dfs(graph, v);
            });
        }
    }

    private static class Graph {
        private List<Integer>[] vertices;
        private int size;

        public Graph(int size) {
            this.size = size;
            //noinspection unchecked
            vertices = (List<Integer>[]) new ArrayList[size];

            for (int i = 0; i < size; i++) {
                vertices[i] = new ArrayList<>();
            }
        }

        public void add(int v, int w) {
            vertices[v].add(w);
            vertices[w].add(v);
        }

        public List<Integer> adj(int v) {
            return vertices[v];
        }

        public int size() {
            return size;
        }
    }
}

