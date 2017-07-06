package hackerrank.algorithms.contests_unpublished;

import java.util.*;

/**
 * Created by Aleksandr on 03/07/2017.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/contests/hourrank-22/challenges/super-mancunian
 */
public class SuperMancunian {
    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);
        final int n = in.nextInt();
        final int m = in.nextInt();

        if (n == 1) {
            System.out.format("%d %d", 0, 0);
            return;
        }

        final Graph graph = new Graph(n + 1);
        for (int i = 0; i < m; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            int w = in.nextInt();

            graph.addEdge(a, b, w);
        }

        final KruskalMST kruskal = new KruskalMST(graph);
        final long pathSum = kruskal.weight;

        final List<Edge> mst = kruskal.mst;
        Collections.sort(mst);
        final long longestEdge = mst.get(mst.size() - 1).weight;
        final UnionFind uf = new UnionFind(n + 1);

        mst.stream().filter(edge -> edge.weight < longestEdge).forEach(edge -> uf.union(edge.v, edge.w));

        final long pathCount = graph.edges().stream().filter(edge -> edge.weight >= longestEdge && !uf.connected(edge.v, edge.w)).count();

        System.out.format("%d %d", pathSum - longestEdge, pathCount);
    }

    private static class Edge implements Comparable<Edge> {
        private final int v;
        private final int w;
        private final long weight;

        Edge(int v, int w, long weight) {
            this.v = v;
            this.w = w;
            this.weight = weight;
        }

        long weight() {
            return weight;
        }

        int either() {
            return v;
        }

        int other(int vertex) {
            if (vertex == v) return w;
            else if (vertex == w) return v;
            else throw new IllegalArgumentException("Illegal endpoint");
        }

        @Override
        public int compareTo(Edge that) {
            if (this.weight() < that.weight()) return -1;
            else if (this.weight() > that.weight()) return +1;
            else return 0;
        }
    }

    private static class Graph {
        private final int V;
        private int E;
        private List<Edge>[] adj;

        public Graph(int V) {
            this.V = V;
            this.E = 0;
            //noinspection unchecked
            adj = (List<Edge>[]) new ArrayList[V];
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

        public void addEdge(int u, int v, int w) {
            E++;
            adj[u].add(new Edge(u, v, w));
            adj[v].add(new Edge(v, u, w));
        }

        public List<Edge> adj(int v) {
            return adj[v];
        }

        List<Edge> edges() {
            List<Edge> list = new ArrayList<>();
            for (int v = 0; v < V; v++) {
                int selfLoops = 0;
                for (Edge e : adj(v)) {
                    if (e.other(v) > v) {
                        list.add(e);
                    }
                    // only add one copy of each self loop (self loops will be consecutive)
                    else if (e.other(v) == v) {
                        if (selfLoops % 2 == 0) list.add(e);
                        selfLoops++;
                    }
                }
            }
            return list;
        }
    }

    private static class KruskalMST {
        private long weight;
        private List<Edge> mst = new ArrayList<>();

        KruskalMST(Graph G) {
            PriorityQueue<Edge> pq = new PriorityQueue<>();
            pq.addAll(G.edges());

            final UnionFind uf = new UnionFind(G.size());
            while (!pq.isEmpty() && mst.size() < G.size() - 1) {
                Edge e = pq.poll();
                int v = e.either();
                int w = e.other(v);
                if (!uf.connected(v, w)) { // v-w does not create a cycle
                    uf.union(v, w);  // merge v and w components
                    mst.add(e);  // add edge e to mst
                    weight += e.weight();
                }
            }
        }
    }

    private static class UnionFind {
        private final int[] parent;
        private final int[] size;
        private int count;

        UnionFind(int N) {
            count = N;
            parent = new int[N];
            size = new int[N];
            for (int i = 0; i < N; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        public int count() {
            return count;
        }

        public int find(int p) {
            while (p != parent[p]) {
                p = parent[p];
            }

            return p;
        }

        boolean connected(int p, int q) {
            return find(p) == find(q);
        }

        void union(int p, int q) {
            final int rootP = find(p);
            final int rootQ = find(q);
            if (rootP == rootQ) return;

            // Make smaller root point to larger one
            if (size[rootP] < size[rootQ]) {
                parent[rootP] = rootQ;
                size[rootQ] += size[rootP];
            } else {
                parent[rootQ] = rootP;
                size[rootP] += size[rootQ];
            }
            count--;
        }
    }
}
