package codechef;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

/**
 * Created by Aleksandr on 06/12/2017.
 * Project Solutions
 * <p>
 * https://www.codechef.com/DEC17/problems/CHEFFIB
 */
public class ChefLeonardoAndQueries {
    private static final int MOD = 1000000007;

    public static void main(String[] args) throws IOException {
        // TODO: To speed up may be pre-computing distances and do lazy updates on type 1 queries?
        //generateTest();
        //final Scanner in = new Scanner(System.in);
        final Scanner in = new Scanner(new FileInputStream("C:\\Projects\\Solutions\\src\\tests.txt"));

        final int T = in.nextInt();
        for (int t = 0; t < T; t++) {
            int N = in.nextInt();
            int Q = in.nextInt();

            final Graph graph = new Graph(N + 1);
            for (int i = 0; i < N - 1; i++) {
                graph.addEdge(in.nextInt(), in.nextInt());
            }

            for (int q = 0; q < Q; q++) {
                final int type = in.nextInt();
                if (type == 1) {
                    updateValues(graph, in.nextInt(), in.nextInt(), in.nextInt(), in.nextInt());
                } else {
                    System.out.println(graph.values[in.nextInt()]);
                }
            }
        }
    }

    private static void updateValues(Graph graph, int v, int k, int a, int b) {
        final Queue<Integer> queue = new ArrayDeque<>();
        final boolean[] marked = new boolean[graph.V];
        final int[] distTo = new int[graph.V];
        Arrays.fill(distTo, Integer.MAX_VALUE);
        marked[v] = true;
        distTo[v] = 0;
        queue.add(v);
        while (!queue.isEmpty()) {
            final int u = queue.poll();
            graph.values[u] = (graph.values[u] + calculateValue(a, b, distTo[u])) % MOD;
            for (int w : graph.adj(u)) {
                if (!marked[w] && distTo[u] + 1 <= k) {
                    marked[w] = true;
                    distTo[w] = distTo[u] + 1;
                    queue.add(w);
                }
            }
        }
    }

    private static int calculateValue(int a, int b, int d) {
        /*if (d == 0) {
            return a;
        } else if (d == 1) {
            return b;
        } else {
            return (calculateValue(a, b, d - 1) + calculateValue(a, b, d - 2)) % MOD;
        }*/
        return (int) fibonacciMatrixExponentiation(a, b, d, MOD);
    }

    private static long fibonacciMatrixExponentiation(int A, int B, int N, int mod) {
        if (N == 0) {
            return A;
        } else if (N == 1) {
            return B;
        }

        long[][] fib = {{1, 1}, {1, 0}};
        long[][] result = {{1, 0}, {0, 1}};
        long[][] tmp = {{0, 0}, {0, 0}};
        int i, j, k;
        while (N > 0) {
            if ((N & 1) == 1) {
                Arrays.fill(tmp[0], 0);
                Arrays.fill(tmp[1], 0);
                for (i = 0; i < 2; i++) {
                    for (j = 0; j < 2; j++) {
                        for (k = 0; k < 2; k++) {
                            tmp[i][j] = (tmp[i][j] + result[i][k] * fib[k][j]);
                        }
                    }
                }
                for (i = 0; i < 2; i++) {
                    for (j = 0; j < 2; j++) {
                        result[i][j] = tmp[i][j] % mod;
                    }
                }
            }

            Arrays.fill(tmp[0], 0);
            Arrays.fill(tmp[1], 0);
            for (i = 0; i < 2; i++) {
                for (j = 0; j < 2; j++) {
                    for (k = 0; k < 2; k++) {
                        tmp[i][j] = (tmp[i][j] + fib[i][k] * fib[k][j]);
                    }
                }
            }
            for (i = 0; i < 2; i++) {
                for (j = 0; j < 2; j++) {
                    fib[i][j] = tmp[i][j] % mod;
                }
            }
            N >>= 1;
        }
        return (result[1][0] * B + result[1][1] * A) % mod;
    }

    private static class Graph {
        private final int V;
        private int E;
        private List<Integer>[] adj;
        private int[] values;

        public Graph(int V) {
            this.V = V;
            this.E = 0;
            //noinspection unchecked
            adj = (List<Integer>[]) new ArrayList[V];
            values = new int[V];
            for (int v = 0; v < V; v++) {
                adj[v] = new ArrayList<>();
            }
        }

        public int size() {
            return V;
        }

        public int E() {
            return E;
        }

        public void addEdge(int v, int w) {
            E++;
            adj[v].add(w);
            adj[w].add(v);
        }

        public List<Integer> adj(int v) {
            return adj[v];
        }
    }
}
