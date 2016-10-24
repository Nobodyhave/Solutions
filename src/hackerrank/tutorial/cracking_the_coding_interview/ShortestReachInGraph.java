package hackerrank.tutorial.cracking_the_coding_interview;

/**
 * Created by Aleksandr on 24/10/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/ctci-bfs-shortest-reach
 */

import java.util.*;

public class ShortestReachInGraph {

    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);

        final int Q = in.nextInt();
        for (int q = 0; q < Q; q++) {
            final int n = in.nextInt();
            final int m = in.nextInt();

            Graph graph = new Graph(n);
            for (int i = 0; i < m; i++) {
                graph.add(in.nextInt(), in.nextInt());
            }

            final int start = in.nextInt();
            final BFS bfs = new BFS(graph, start);
            final int[] distances = bfs.getDistances();
            for (int i = 1; i < distances.length; i++) {
                if (i != start) {
                    System.out.print(distances[i] + " ");
                }
            }
            System.out.println();
        }
    }

    private static class BFS {
        private boolean marked[];
        private int[] distTo;
        private Queue<Integer> queue;

        public BFS(Graph graph, int start) {
            marked = new boolean[graph.size()];
            distTo = new int[graph.size()];
            queue = new LinkedList<>();

            Arrays.fill(distTo, -1);
            distTo[start] = 0;

            marked[start] = true;
            queue.add(start);

            while (!queue.isEmpty()) {
                final int cur = queue.poll();
                graph.adj(cur).stream().filter(v -> !marked[v]).forEach(v -> {
                    marked[v] = true;
                    distTo[v] = distTo[cur] + 6;
                    queue.add(v);
                });
            }
        }

        public int[] getDistances() {
            return distTo;
        }
    }

    private static class Graph {
        private List<Integer>[] vertices;
        private int size;

        public Graph(int size) {
            this.size = size + 1;
            //noinspection unchecked
            vertices = (List<Integer>[]) new ArrayList[this.size];

            for (int i = 1; i < this.size; i++) {
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
