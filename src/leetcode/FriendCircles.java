package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aleksandr on 04/10/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/friend-circles
 */
public class FriendCircles {
    public int findCircleNum(int[][] M) {
        if (M == null || M.length == 0 || M[0] == null || M[0].length == 0) {
            return 0;
        }

        final Graph graph = new Graph(M.length);
        for (int i = 1; i < M.length; i++) {
            for (int j = 0; j < i; j++) {
                if (M[i][j] == 1) {
                    graph.addEdge(i, j);
                }
            }
        }

        final Dfs dfs = new Dfs(graph);

        return dfs.cc;
    }

    private static class Dfs {
        private boolean[] marked;
        private int cc;

        Dfs(Graph graph) {
            marked = new boolean[graph.size];
            for (int i = 0; i < graph.size; i++) {
                if (!marked[i]) {
                    cc++;
                    marked[i] = true;
                    dfs(graph, i);
                }
            }
        }

        private void dfs(Graph graph, int u) {
            for (Integer v : graph.adj(u)) {
                if (!marked[v]) {
                    marked[v] = true;
                    dfs(graph, v);
                }
            }
        }
    }

    private static class Graph {
        private List<Integer>[] vertices;
        private int size;

        Graph(int size) {
            this.size = size;
            vertices = new ArrayList[size];
            for (int i = 0; i < size; i++) {
                vertices[i] = new ArrayList<>();
            }
        }

        void addEdge(int u, int v) {
            vertices[u].add(v);
            vertices[v].add(u);
        }

        List<Integer> adj(int u) {
            return vertices[u];
        }
    }
}
