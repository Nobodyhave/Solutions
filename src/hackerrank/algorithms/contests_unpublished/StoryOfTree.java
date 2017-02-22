package hackerrank.algorithms.contests_unpublished;

import java.io.FileNotFoundException;
import java.util.*;

/**
 * Created by Aleksandr on 22/02/2017.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/contests/university-codesprint-2/challenges/the-story-of-a-tree
 */
public class StoryOfTree {
    public static void main(String[] args) throws FileNotFoundException {
        final Scanner in = new Scanner(System.in);
        //final Scanner in = new Scanner(new FileInputStream("C:\\Projects\\Algos\\test_data.txt"));

        int Q = in.nextInt();
        for (int q = 0; q < Q; q++) {
            final int n = in.nextInt();
            final Graph tree = new Graph(n + 1);
            for (int a1 = 0; a1 < n - 1; a1++) {
                int u = in.nextInt();
                int v = in.nextInt();
                tree.addEdge(u, v);
            }
            int g = in.nextInt();
            int k = in.nextInt();

            final Set<Integer>[] guesses = new HashSet[n + 1];
            for (int v = 0; v <= n; v++) {
                guesses[v] = new HashSet<>();
            }
            for (int a1 = 0; a1 < g; a1++) {
                int u = in.nextInt();
                int v = in.nextInt();
                guesses[u].add(v);
            }

            int count = 0, start = 0;
            for (int i = 1; i <= n; i++) {
                if (tree.adj(i).size() == 1) {
                    start = i;
                    break;
                }
            }
            DepthFirstSearch dfs = new DepthFirstSearch(tree, start, guesses, true, 0, k);
            if (dfs.correctGuesses >= k) {
                count++;
            }
            dfs = new DepthFirstSearch(tree, start, guesses, false, dfs.correctGuesses, k);
            count += dfs.count;

            int gcd = gcd(count, n);

            System.out.println(count / gcd + "/" + n / gcd);
        }
    }

    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
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

    private static class DepthFirstSearch {
        private final int s;
        private boolean[] marked;
        private int[] edgeTo;
        private boolean first;
        private int correctGuesses;
        private int k;
        private int count;

        public DepthFirstSearch(Graph G, int s, Set<Integer>[] guesses, boolean first, int correctGuesses, int k) {
            this.s = s;
            edgeTo = new int[G.size()];
            marked = new boolean[G.size()];
            this.first = first;
            this.correctGuesses = correctGuesses;
            this.k = k;
            dfs(G, s, guesses);
        }

        private void dfs(Graph G, int v, Set<Integer>[] guesses) {
            marked[v] = true;
            G.adj(v).stream().filter(w -> !marked[w]).forEach(w -> {
                edgeTo[w] = v;
                if (first) {
                    if (guesses[v].contains(w)) {
                        correctGuesses++;
                    }
                } else {
                    if (guesses[v].contains(w)) {
                        correctGuesses--;
                    }
                    if (guesses[w].contains(v)) {
                        correctGuesses++;
                    }
                    if (correctGuesses >= k) {
                        count++;
                    }
                }
                dfs(G, w, guesses);
                if (first) {
                    /*if (guesses[v].contains(w)) {
                        correctGuesses++;
                    }*/
                } else {
                    if (guesses[v].contains(w)) {
                        correctGuesses++;
                    }
                    if (guesses[w].contains(v)) {
                        correctGuesses--;
                    }
                }
            });
        }
    }
}
