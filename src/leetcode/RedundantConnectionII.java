package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aleksandr on 01/11/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/redundant-connection-ii
 */
public class RedundantConnectionII {
    public int[] findRedundantDirectedConnection(int[][] edges) {
        if (edges == null || edges.length == 0) {
            return new int[0];
        }

        final Graph graph = new Graph(edges.length + 1);
        for (int[] edge : edges) {
            graph.addEdge(edge[0], edge[1]);
        }

        final int root = new RootFinder(graph, edges.length).root;
        final Edge edgeToRemove = new EdgeFinder(graph, edges, root).edgeToRemove;

        return new int[]{edgeToRemove.u, edgeToRemove.v};
    }

    private static class Edge {
        private int u;
        private int v;

        Edge(int u, int v) {
            this.u = u;
            this.v = v;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Edge edge = (Edge) o;

            if (u != edge.u) return false;
            return v == edge.v;
        }

        @Override
        public int hashCode() {
            int result = u;
            result = 31 * result + v;
            return result;
        }
    }

    private static class Graph {
        private List<Edge>[] vertices;
        private int size;

        Graph(int size) {
            this.size = size;
            vertices = new ArrayList[size];
            for (int i = 0; i < size; i++) {
                vertices[i] = new ArrayList<>();
            }
        }

        void addEdge(int u, int v) {
            final Edge edge = new Edge(u, v);
            vertices[u].add(edge);
        }

        void addEdge(Edge e) {
            vertices[e.u].add(e);
        }

        void removeEdge(Edge e) {
            vertices[e.u].remove(e);
        }

        List<Edge> adj(int u) {
            return vertices[u];
        }
    }

    private static class RootFinder {
        private int root;

        RootFinder(Graph graph, int vCount) {
            for (int i = 1; i < graph.size; i++) {
                if (new Dfs(graph, i).visitedCount == vCount) {
                    root = i;
                    break;
                }
            }
        }
    }

    private static class Dfs {
        private boolean[] marked;
        private int visitedCount;

        Dfs(Graph graph, int root) {
            marked = new boolean[graph.size];

            marked[root] = true;
            dfs(graph, root);
        }

        private void dfs(Graph graph, int u) {
            visitedCount++;
            for (Edge e : graph.adj(u)) {
                if (!marked[e.v]) {
                    marked[e.v] = true;
                    dfs(graph, e.v);
                }
            }
        }
    }

    private static class EdgeFinder {
        private Edge edgeToRemove;

        EdgeFinder(Graph graph, int[][] edges, int root) {
            for (int i = edges.length - 1; i >= 0; i--) {
                final Edge e = new Edge(edges[i][0], edges[i][1]);
                graph.removeEdge(e);
                if (new Dfs(graph, root).visitedCount == edges.length) {
                    edgeToRemove = e;
                    break;
                }
                graph.addEdge(e);
            }
        }
    }
}
