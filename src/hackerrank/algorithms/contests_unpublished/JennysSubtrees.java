package hackerrank.algorithms.contests_unpublished;

import java.io.FileNotFoundException;
import java.util.*;

/**
 * Created by Aleksandr on 03/01/2017.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/contests/hourrank-16/challenges/jenny-subtrees
 * <p>
 * Failing 3 test cases
 */

public class JennysSubtrees {
    private static List<Integer> PRIMES;
    private static boolean[][] MARKED;

    public static void main(String[] args) throws FileNotFoundException {
        final Scanner in = new Scanner(System.in);
        //final Scanner in = new Scanner(new FileInputStream("C:\\Projects\\Solutions\\src\\tests.txt"));
        final int N = in.nextInt();
        final int R = in.nextInt();

        final Graph graph = new Graph(N + 1);
        for (int i = 0; i < N - 1; i++) {
            final int v = in.nextInt();
            final int w = in.nextInt();
            graph.addEdge(v, w);
        }

        MARKED = new boolean[N + 1][N + 1];
        PRIMES = sieveOfEratosthenes(1000000);

        final Set<Long> set = new HashSet<>();

        //long t1 = System.currentTimeMillis();
        for (int i = 1; i <= N; i++) {
            final DepthFirstSearch dfs = new DepthFirstSearch(graph, i, R);
            set.add(dfs.hash);
        }
        //long t2 = System.currentTimeMillis();
        //System.out.println("Total: " + (t2 - t1));

        System.out.println(set.size());
    }

    private static List<Integer> sieveOfEratosthenes(int N) {
        final BitSet prime = new BitSet(Math.max(3, N + 1));
        final List<Integer> primes = new ArrayList<>();
        prime.set(0, false);
        prime.set(1, false);
        prime.set(2, N + 1, true);
        final int m = (int) Math.sqrt(N) + 1;

        for (int i = 2; i <= m; i++) {
            if (prime.get(i)) {
                primes.add(i);
                for (int k = i * i; k <= N; k += i) {
                    prime.set(k, false);
                }
            }
        }

        for (int i = m + 1; i <= N; i++) {
            if (prime.get(i)) {
                primes.add(i);
            }
        }

        return primes;
    }

    private static class DepthFirstSearch {
        private long hash;
        private int s;
        private boolean marked[];

        public DepthFirstSearch(Graph G, int s, int R) {
            this.s = s;
            final Set<Integer> vertices = new TreeSet<>();
            //long t1 = System.nanoTime();
            dfs(G, vertices, s, R, 0);
            //long t2 = System.nanoTime();
            //System.out.println("DFS: " + (t2 - t1));
            final Set<Integer> roots = findRoots(G, vertices);

            int count = 0;
            for (Integer root : roots) {
                if (count == 0) {
                    //long t3 = System.nanoTime();
                    marked = new boolean[G.size()];
                    hash = calculateHash(G, root, 0);
                    //long t4 = System.nanoTime();
                    //System.out.println("Hash1: " + (t4 - t3));
                } else if (count == 1) {
                    //long t3 = System.nanoTime();
                    Arrays.fill(marked, false);
                    hash *= calculateHash(G, root, 0);
                    //long t4 = System.nanoTime();
                    //System.out.println("Hash2: " + (t4 - t3));
                }
                count++;
            }
        }

        private int calculateHash(Graph G, int v, int depth) {
            marked[v] = true;
            final List<Integer> childHash = new ArrayList<>();
            G.adj(v).stream().filter(w -> !marked[w]).forEach(w -> {
                if (MARKED[s][w]) {
                    childHash.add(calculateHash(G, w, depth + 1));
                }
            });

            Collections.sort(childHash);
            int result = PRIMES.get(depth);
            for (Integer hash : childHash) {
                result = (result * PRIMES.get(depth + 1) + hash) % 1000000007;
            }

            return result;
        }

        private Set<Integer> findRoots(Graph graph, Set<Integer> vertices) {
            int r = vertices.size();
            Set<Integer> S = new HashSet<>();

            for (Integer vertex : vertices) {
                if (graph.centerDegree[vertex] <= 1) {
                    S.add(vertex);
                    r--;
                }
            }

            while (r > 0) {
                final Set<Integer> T = new HashSet<>();
                for (Integer v : S) {
                    for (Integer w : graph.adj(v)) {
                        graph.centerDegree[w]--;
                        if (graph.centerDegree[w] == 1) {
                            T.add(w);
                            r--;
                        }
                    }
                }
                S = T;
            }

            return S;
        }

        private void dfs(Graph G, Set<Integer> vertices, int v, int R, int depth) {
            MARKED[s][v] = true;
            vertices.add(v);
            G.adj(v).stream().filter(w -> !MARKED[s][w]).forEach(w -> {
                if (depth == R) {
                    G.centerDegree[v] = 1;
                } else {
                    G.centerDegree[v] = G.adj(v).size();
                    dfs(G, vertices, w, R, depth + 1);
                }
            });
        }
    }

    private static class Graph {
        private final int V;
        private List<Integer>[] adj;
        private int[] centerDegree;

        public Graph(int V) {
            this.V = V;
            //noinspection unchecked
            adj = (List<Integer>[]) new ArrayList[V];
            for (int v = 0; v < V; v++) {
                adj[v] = new ArrayList<>();
            }
            centerDegree = new int[V];
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

