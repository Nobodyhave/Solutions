package hackerrank.algorithms.contests_unpublished;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * Created by Aleksandr on 16/06/2017.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/contests/w33/challenges/bonnie-and-clyde
 */
public class BonnieAndClyde {
    public static void main(String[] args) throws FileNotFoundException {
        //final Scanner in = new Scanner(System.in);
        final Scanner in = new Scanner(new FileInputStream("C:\\Projects\\Solutions\\src\\tests.txt"));
        int N = in.nextInt();
        int M = in.nextInt();
        int Q = in.nextInt();

        final Graph graph = new Graph(N);
        for (int m = 0; m < M; m++) {
            int u = in.nextInt();
            int v = in.nextInt();

            graph.addEdge(u - 1, v - 1);
        }

        graph.BCC();

        for (int q = 0; q < Q; q++) {
            final int uV = in.nextInt() - 1;
            final int vV = in.nextInt() - 1;
            final int wV = in.nextInt() - 1;

            final Set<Integer> U = graph.bcc.get(uV);
            final Set<Integer> V = graph.bcc.get(vV);
            final Set<Integer> W = graph.bcc.get(wV);

            final Set<Integer> uvwUnion = new HashSet<>(U);
            uvwUnion.retainAll(V);
            uvwUnion.retainAll(W);
            if (uvwUnion.size() >= 1) {
                // All 3 vertices are in one BCC
                System.out.println("YES");
                continue;
            } else {
                // Sink is in different BCC from both sources
                final DepthFirstSearch dfs = new DepthFirstSearch(graph, uV, wV);
                if (!dfs.hasPathTo(vV)) {
                    System.out.println("YES");
                    continue;
                }
            }

            final Set<Integer> uwUnion = new HashSet<>(U);
            uwUnion.retainAll(W);
            if (uwUnion.size() >= 1) {
                // Sink and one source are in same BCC
                final DepthFirstSearch dfs = new DepthFirstSearch(graph, vV, uV);
                if (dfs.hasPathTo(wV)) {
                    System.out.println("YES");
                    continue;
                }
            }

            final Set<Integer> vwUnion = new HashSet<>(V);
            vwUnion.retainAll(W);
            if (vwUnion.size() >= 1) {
                // Sink and one source are in same BCC
                final DepthFirstSearch dfs = new DepthFirstSearch(graph, uV, vV);
                if (dfs.hasPathTo(wV)) {
                    System.out.println("YES");
                    continue;
                }
            }

            System.out.println("NO");
        }
    }

    private static class DepthFirstSearch {
        private boolean[] marked;
        private int[] edgeTo;
        private final int s;

        public DepthFirstSearch(Graph G, int s, int t) {
            this.s = s;
            edgeTo = new int[G.V];
            marked = new boolean[G.V];
            dfs(G, s, t);
        }

        private void dfs(Graph G, int v, int t) {
            marked[v] = true;
            G.adj(v).stream().filter(w -> !marked[w] && w != t).forEach(w -> {
                edgeTo[w] = v;
                dfs(G, w, t);
            });
        }

        public boolean hasPathTo(int v) {
            return marked[v];
        }

        public Stack<Integer> pathTo(int v) {
            if (!hasPathTo(v)) return null;
            Stack<Integer> path = new Stack<>();
            for (int x = v; x != s; x = edgeTo[x]) {
                path.push(x);
            }
            path.push(s);
            return path;
        }
    }

    private static class Edge {
        private int u;
        private int v;

        Edge(int u, int v) {
            this.u = u;
            this.v = v;
        }
    }

    private static class Graph {
        private int V, E;
        private List<Integer> adj[];
        private Map<Integer, Set<Integer>> bcc = new HashMap<>();
        private boolean[] articulation;

        private int count = 0, time = 0;

        Graph(int v) {
            V = v;
            E = 0;
            adj = new ArrayList[v];
            for (int i = 0; i < v; ++i) {
                adj[i] = new ArrayList<>();
                bcc.put(i, new HashSet<>());
            }
            articulation = new boolean[V];
        }

        void addEdge(int v, int w) {
            adj[v].add(w);
            adj[w].add(v);
            E++;
        }

        List<Integer> adj(int u) {
            return adj[u];
        }

        private void BCCUtil(int u, int disc[], int low[], LinkedList<Edge> st, int parent[]) {
            // Initialize discovery time and low value
            disc[u] = low[u] = ++time;
            int children = 0;

            // Go through all vertices adjacent to this
            for (Integer v : adj[u]) {
                // If v is not visited yet, then recur for it
                if (disc[v] == -1) {
                    children++;
                    parent[v] = u;

                    // store the edge in stack
                    st.add(new Edge(u, v));
                    BCCUtil(v, disc, low, st, parent);

                    // Check if the subtree rooted with 'v' has a
                    // connection to one of the ancestors of 'u'
                    // Case 1 -- per Strongly Connected Components Article
                    if (low[u] > low[v]) {
                        low[u] = low[v];
                    }

                    // If u is an articulation point,
                    // pop all edges from stack till u -- v
                    if ((disc[u] == 1 && children > 1) || (disc[u] > 1 && low[v] >= disc[u])) {
                        articulation[u] = true;

                        while (st.getLast().u != u || st.getLast().v != v) {
                            bcc.get(st.getLast().u).add(count);
                            bcc.get(st.getLast().v).add(count);
                            st.removeLast();
                        }
                        bcc.get(st.getLast().u).add(count);
                        bcc.get(st.getLast().v).add(count);
                        st.removeLast();

                        count++;
                    }
                }

                // Update low value of 'u' only of 'v' is still in stack
                // (i.e. it's a back edge, not cross edge).
                // Case 2 -- per Strongly Connected Components Article
                else if (v != parent[u] && disc[v] < low[u]) {
                    if (low[u] > disc[v]) {
                        low[u] = disc[v];
                    }
                    st.add(new Edge(u, v));
                }
            }
        }

        // The function to do DFS traversal. It uses BCCUtil()
        void BCC() {
            final int disc[] = new int[V];
            final int low[] = new int[V];
            final int parent[] = new int[V];
            final LinkedList<Edge> st = new LinkedList<Edge>();

            // Initialize disc and low, and parent arrays
            for (int i = 0; i < V; i++) {
                disc[i] = -1;
                low[i] = -1;
                parent[i] = -1;
            }

            for (int i = 0; i < V; i++) {
                if (disc[i] == -1) {
                    BCCUtil(i, disc, low, st, parent);
                }

                // If stack is not empty, pop all edges from stack
                if (!st.isEmpty()) {
                    final HashSet<Integer> component = new HashSet<>();
                    while (st.size() > 0) {
                        bcc.get(st.getLast().u).add(count);
                        bcc.get(st.getLast().v).add(count);
                        st.removeLast();
                    }
                    count++;
                }
            }
        }
    }
}
