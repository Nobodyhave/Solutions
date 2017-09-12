package leetcode;

import java.util.*;

/**
 * Created by Aleksandr on 07/09/2017.
 * Project Solutions
 */
public class PacificAtlanticWaterFlow {
    public List<int[]> pacificAtlantic(int[][] matrix) {
        final List<int[]> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return result;
        }

        final int rows = matrix.length;
        final int cols = matrix[0].length;
        final int pacific = rows * cols;
        final int atlantic = rows * cols + 1;
        final Graph graph = new Graph(rows * cols + 2);

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (r != 0 && matrix[r][c] <= matrix[r - 1][c]) {
                    graph.addEdge(r * cols + c, (r - 1) * cols + c);
                } else if (r == 0) {
                    graph.addEdge(pacific, r * cols + c);
                }
                if (r != rows - 1 && matrix[r][c] <= matrix[r + 1][c]) {
                    graph.addEdge(r * cols + c, (r + 1) * cols + c);
                } else if (r == rows - 1) {
                    graph.addEdge(atlantic, r * cols + c);
                }
                if (c != 0 && matrix[r][c] <= matrix[r][c - 1]) {
                    graph.addEdge(r * cols + c, r * cols + c - 1);
                } else if (c == 0) {
                    graph.addEdge(pacific, r * cols + c);
                }
                if (c != cols - 1 && matrix[r][c] <= matrix[r][c + 1]) {
                    graph.addEdge(r * cols + c, r * cols + c + 1);
                } else if (c == cols - 1) {
                    graph.addEdge(atlantic, r * cols + c);
                }
            }
        }

        final boolean[] pacificVisited = bfs(graph, pacific);
        final boolean[] atlanticVisited = bfs(graph, atlantic);

        for (int i = 0; i < pacificVisited.length; i++) {
            if (pacificVisited[i] && atlanticVisited[i]) {
                result.add(new int[]{i / cols, i % cols});
            }
        }

        return result;
    }

    private static boolean[] bfs(Graph graph, int start) {
        final boolean[] marked = new boolean[graph.size];
        final PriorityQueue<Integer> pq = new PriorityQueue<>();

        pq.add(start);
        marked[start] = true;
        while (!pq.isEmpty()) {
            int u = pq.poll();
            for (int v : graph.adj(u)) {
                if (!marked[v]) {
                    marked[v] = true;
                    pq.add(v);
                }
            }
        }

        return marked;
    }

    private static class Graph {
        private Map<Integer, List<Integer>> vertices;
        private int size;

        Graph(int n) {
            vertices = new HashMap<>();
            size = n;
        }

        void addEdge(int u, int v) {
            vertices.computeIfAbsent(u, key -> new ArrayList<>());
            vertices.get(u).add(v);
        }

        List<Integer> adj(int u) {
            return vertices.getOrDefault(u, Collections.emptyList());
        }
    }
}
