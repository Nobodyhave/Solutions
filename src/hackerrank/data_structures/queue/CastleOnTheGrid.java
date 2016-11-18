package hackerrank.data_structures.queue;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * Created by Aleksandr on 17/11/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/castle-on-the-grid
 */
public class CastleOnTheGrid {
    public static void main(String[] args) throws FileNotFoundException {
        //final Scanner in = new Scanner(System.in);
        final Scanner in = new Scanner(new FileInputStream("C:\\Projects\\Solutions\\src\\tests.txt"));

        final int N = in.nextInt();
        final char[][] grid = new char[N][N];
        for (int i = 0; i < N; i++) {
            final String str = in.next();
            for (int j = 0; j < N; j++) {
                grid[i][j] = str.charAt(j);
            }
        }

        final int a = in.nextInt();
        final int b = in.nextInt();
        final int c = in.nextInt();
        final int d = in.nextInt();

        in.close();

        final Graph graph = new Graph(N * N);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] != '.') {
                    continue;
                }
                int x = j + 1;
                while (x < N && grid[i][x] == '.') {
                    graph.addEdge(i * N + j, i * N + x);
                    x++;
                }
                int y = i + 1;
                while (y < N && grid[y][j] == '.') {
                    graph.addEdge(i * N + j, y * N + j);
                    y++;
                }
            }
        }

        final BreadthFirstSearch bfs = new BreadthFirstSearch(graph, a * N + b);

        System.out.println(bfs.distTo(c * N + d));
    }

    private static class BreadthFirstSearch {
        private static final int INFINITY = Integer.MAX_VALUE;
        private boolean[] marked;
        private int[] edgeTo;
        private int[] distTo;

        public BreadthFirstSearch(Graph G, int s) {
            marked = new boolean[G.size()];
            distTo = new int[G.size()];
            edgeTo = new int[G.size()];
            bfs(G, s);
        }

        private void bfs(Graph G, int s) {
            Queue<Integer> q = new LinkedList<>();
            for (int v = 0; v < G.size(); v++)
                distTo[v] = INFINITY;
            distTo[s] = 0;
            marked[s] = true;
            q.add(s);

            while (!q.isEmpty()) {
                int v = q.poll();
                G.adj(v).stream().filter(w -> !marked[w]).forEach(w -> {
                    edgeTo[w] = v;
                    distTo[w] = distTo[v] + 1;
                    marked[w] = true;
                    q.add(w);
                });
            }
        }

        public int distTo(int v) {
            return distTo[v];
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
