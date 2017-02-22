package hackerrank.algorithms.graph_theory;

import java.io.FileNotFoundException;
import java.util.*;

/**
 * Created by Aleksandr on 16/02/2017.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/beautiful-path
 */
public class MinimumPenaltyPath {
    public static void main(String[] args) throws FileNotFoundException {
        final Scanner reader = new Scanner(System.in);
        //final Scanner reader = new Scanner(new FileInputStream("C:\\Projects\\Solutions\\src\\tests.txt"));

        int N = reader.nextInt();
        int M = reader.nextInt();

        final List<Edge>[] edges = (List<Edge>[]) new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            edges[i] = new ArrayList<>(10000);
        }

        final boolean[][] marked = new boolean[N + 1][1024];
        for (int i = 0; i < M; i++) {
            int from = reader.nextInt();
            int to = reader.nextInt();
            int weight = reader.nextInt();
            edges[from].add(new Edge(from, to, weight));
            edges[to].add(new Edge(to, from, weight));
        }

        final int start = reader.nextInt();
        final int end = reader.nextInt();

        final Queue<Integer> queue = new ArrayDeque<>();
        queue.add(start);
        queue.add(0);
        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            int cost = queue.poll();
            marked[vertex][cost] = true;

            for (Edge e : edges[vertex]) {
                int to = e.other(vertex);
                if (!marked[to][cost | e.weight]) {
                    marked[to][cost | e.weight] = true;
                    queue.add(to);
                    queue.add(cost | e.weight);
                }
            }
        }

        int result = -1;
        for (int i = 0; i < 1024; i++) {
            if (marked[end][i]) {
                result = i;
                break;
            }
        }

        System.out.println(result);
    }

    private static class Edge implements Comparable<Edge> {
        private final int from;
        private final int to;
        private final int weight;

        public Edge(int v, int w, int weight) {
            if (v < 0) throw new IndexOutOfBoundsException("Vertex name must be a nonnegative integer");
            if (w < 0) throw new IndexOutOfBoundsException("Vertex name must be a nonnegative integer");
            if (Double.isNaN(weight)) throw new IllegalArgumentException("Weight is NaN");
            this.from = v;
            this.to = w;
            this.weight = weight;
        }

        public double weight() {
            return weight;
        }

        public int other(int vertex) {
            if (vertex == from) return to;
            else if (vertex == to) return from;
            else throw new IllegalArgumentException("Illegal endpoint");
        }

        @Override
        public int compareTo(Edge that) {
            if (this.weight() < that.weight()) return -1;
            else if (this.weight() > that.weight()) return +1;
            else return 0;
        }

        public String toString() {
            return String.format("%d-%d %d", from, to, weight);
        }
    }
}
