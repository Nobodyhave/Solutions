package leetcode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Aleksandr on 12/07/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/course-schedule-ii
 */
public class CourseScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (numCourses == 0 || prerequisites == null) {
            return new int[0];
        }

        final Graph graph = new Graph(numCourses);
        for (int i = 0; i < prerequisites.length; i++) {
            graph.addEdge(prerequisites[i][0], prerequisites[i][1]);
        }

        final Dfs dfs = new Dfs(graph);

        if (dfs.hasCycle) {
            return new int[0];
        } else {
            final int[] result = new int[numCourses];
            int i = 0;
            while (!dfs.postOrder.isEmpty()) {
                result[i++] = dfs.postOrder.pollFirst();
            }
            return result;
        }
    }

    private static class Dfs {
        private boolean[] marked;
        private boolean[] onStack;
        private boolean hasCycle;
        private Deque<Integer> postOrder = new LinkedList<>();

        Dfs(Graph graph) {
            marked = new boolean[graph.size];
            onStack = new boolean[graph.size];

            for (int i = 0; i < graph.size; i++) {
                if (!marked[i]) {
                    dfs(graph, i);
                }
            }
        }

        private void dfs(Graph graph, int u) {
            marked[u] = true;
            onStack[u] = true;

            for (Integer v : graph.adj(u)) {
                if (!marked[v]) {
                    dfs(graph, v);
                } else if (onStack[v]) {
                    hasCycle = true;
                }
            }

            postOrder.add(u);
            onStack[u] = false;
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
        }

        List<Integer> adj(int u) {
            return vertices[u];
        }
    }
}
