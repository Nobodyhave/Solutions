package hackerrank.algorithms.graph_theory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Aleksandr on 23/11/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/journey-to-the-moon
 */
public class JourneyToTheMoon {
    public static void main(String[] args) throws FileNotFoundException {
        //final Scanner in = new Scanner(System.in);
        final Scanner in = new Scanner(new FileInputStream("C:\\Projects\\Solutions\\src\\tests.txt"));

        final int N = in.nextInt();
        final int I = in.nextInt();

        final Graph graph = new Graph(N);
        for (int i = 0; i < I; i++) {
            graph.addEdge(in.nextInt(), in.nextInt());
        }

        final ConnectedComponents cc = new ConnectedComponents(graph);

        final int[] ps = new int[cc.count()];
        ps[0] = cc.size[0];
        for (int i = 1; i < cc.count; i++) {
            ps[i] = ps[i - 1] + cc.size[i];
        }

        long result = 0;
        for (int i = 0; i < cc.count; i++) {
            result += cc.size[i] * (ps[ps.length - 1] - ps[i]);
        }

        System.out.println(result);
    }

    private static class ConnectedComponents {
        private boolean[] marked;
        private int[] id;
        private int[] size;
        private int count;

        public ConnectedComponents(Graph G) {
            marked = new boolean[G.size()];
            id = new int[G.size()];
            size = new int[G.size()];
            for (int v = 0; v < G.size(); v++) {
                if (!marked[v]) {
                    dfs(G, v);
                    count++;
                }
            }
        }

        private void dfs(Graph G, int v) {
            marked[v] = true;
            id[v] = count;
            size[count]++;
            G.adj(v).stream().filter(w -> !marked[w]).forEach(w -> dfs(G, w));
        }

        public int size(int v) {
            return size[id[v]];
        }

        public int count() {
            return count;
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
    }
}
