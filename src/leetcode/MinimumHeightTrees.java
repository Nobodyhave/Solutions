package leetcode;

import java.util.*;

/**
 * Created by Aleksandr on 17/08/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/minimum-height-trees
 */
public class MinimumHeightTrees {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        final List<Integer> result = new ArrayList<>();

        if(n == 0) {
            return result;
        } else if(n == 1) {
            result.add(0);
            return result;
        }

        final Graph graph = new Graph(n);

        for (int i = 0; i < edges.length; i++) {
            graph.addEdge(edges[i][0], edges[i][1]);
        }

        final Bfs bfs1 = new Bfs(graph, 0);

        int maxDist = Integer.MIN_VALUE;
        int maxDistV = 0;
        for (int i = 0; i < n; i++) {
            if (bfs1.distTo[i] > maxDist) {
                maxDist = bfs1.distTo[i];
                maxDistV = i;
            }
        }

        final Bfs bfs2 = new Bfs(graph, maxDistV);

        maxDist = Integer.MIN_VALUE;
        maxDistV = 0;
        for (int i = 0; i < n; i++) {
            if (bfs2.distTo[i] > maxDist) {
                maxDist = bfs2.distTo[i];
                maxDistV = i;
            }
        }

        final List<Integer> path = bfs2.pathTo(maxDistV);
        result.add(path.get(path.size() / 2));
        if (path.size() % 2 == 0) {
            result.add(path.get(path.size() / 2 - 1));
        }

        return result;
    }

    private static class Bfs {
        private boolean[] marked;
        private int[] edgeTo;
        private int[] distTo;

        Bfs(Graph graph, int start) {
            marked = new boolean[graph.size];
            edgeTo = new int[graph.size];
            distTo = new int[graph.size];

            for (int i = 0; i < graph.size; i++) {
                edgeTo[i] = i;
                distTo[i] = Integer.MAX_VALUE;
            }

            distTo[start] = 0;
            marked[start] = true;

            final Queue<Integer> queue = new LinkedList<>();
            queue.add(start);

            while (!queue.isEmpty()) {
                int u = queue.poll();
                for (Integer w : graph.adj(u)) {
                    if (!marked[w]) {
                        marked[w] = true;
                        edgeTo[w] = u;
                        distTo[w] = distTo[u] + 1;
                        queue.add(w);
                    }
                }
            }
        }

        List<Integer> pathTo(int u) {
            final List<Integer> path = new ArrayList<>();

            while (edgeTo[u] != u) {
                path.add(u);
                u = edgeTo[u];
            }
            path.add(u);

            Collections.reverse(path);

            return path;
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

        public void addEdge(int u, int v) {
            vertices[u].add(v);
            vertices[v].add(u);
        }

        public List<Integer> adj(int u) {
            return vertices[u];
        }
    }
}
