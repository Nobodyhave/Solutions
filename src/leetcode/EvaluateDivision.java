package leetcode;

import java.util.*;

/**
 * Created by Aleksandr on 07/09/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/evaluate-division
 */
public class EvaluateDivision {
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        final double[] result = new double[queries.length];
        final Graph graph = new Graph();
        for (int i = 0; i < values.length; i++) {
            graph.addEdge(equations[i][0], equations[i][1], values[i]);
        }
        for (String v : graph.vertices.keySet()) {
            graph.addEdge(v, v, 1.0);
        }

        for (int i = 0; i < queries.length; i++) {
            final Dfs dfs = new Dfs(graph, queries[i][0], queries[i][1]);
            result[i] = dfs.result;
        }

        return result;
    }

    private static class Dfs {
        private Set<String> marked = new HashSet<>();
        private double result = -1.0;
        private String start, end;

        Dfs(Graph graph, String start, String end) {
            this.start = start;
            this.end = end;
            dfs(graph, start, 1.0);
        }

        private void dfs(Graph graph, String u, double val) {
            marked.add(u);
            for (Edge e : graph.adj(u)) {
                if (e.v.equals(end)) {
                    result = val * e.w;
                    return;
                } else if (!marked.contains(e.v)) {
                    dfs(graph, e.v, val * e.w);
                }
            }
        }
    }

    private static class Graph {
        private Map<String, List<Edge>> vertices;
        private List<Edge> EMPTY = new ArrayList<>();

        Graph() {
            vertices = new HashMap<>();
        }

        void addEdge(String u, String v, double w) {
            vertices.computeIfAbsent(u, key -> new ArrayList<>());
            vertices.get(u).add(new Edge(u, v, w));
            vertices.computeIfAbsent(v, key -> new ArrayList<>());
            vertices.get(v).add(new Edge(v, u, 1.0 / w));
        }

        List<Edge> adj(String u) {
            return vertices.getOrDefault(u, EMPTY);
        }
    }

    private static class Edge {
        private String u;
        private String v;
        private double w;

        Edge(String u, String v, double w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }
    }
}
