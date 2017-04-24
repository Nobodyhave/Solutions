package hackerrank.algorithms.contests_unpublished;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;

/**
 * Created by Aleksandr on 13/04/2017.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/contests/w31/challenges/spanning-tree-fraction
 */
public class SpanningTreeFraction {
    public static void main(String[] args) throws FileNotFoundException {
        final InputReader in = new InputReader(System.in);
        final int n = in.readInt();
        final int m = in.readInt();

        final Edge[] graph = new Edge[m];
        for (int i = 0; i < m; i++) {
            graph[i] = new Edge(in.readInt(), in.readInt(), in.readInt(), in.readInt());
        }

        double start = 0, end = 100, count = 70, best = Double.NEGATIVE_INFINITY;
        KruskalMST bestResult = null;
        while (count > 0) {
            final double mid = start + (end - start) / 2;

            final KruskalMST kruskalMST = findSpecialValue(mid, graph);
            final int specialValue = Double.compare(kruskalMST.weight, 0);
            if (specialValue < 0) {
                end = mid;
            } else if (specialValue > 0) {
                if (mid > best) {
                    bestResult = kruskalMST;
                    best = mid;
                }
                start = mid;
            } else {
                bestResult = kruskalMST;
                break;
            }
            count--;
        }

        int sumA = 0;
        int sumB = 0;
        for (Edge edge : bestResult.mst) {
            sumA += edge.a;
            sumB += edge.b;
        }

        long gcm = gcm(sumA, sumB);

        System.out.println(sumA / gcm + "/" + sumB / gcm);
    }

    private static long gcm(int a, int b) {
        return b == 0 ? a : gcm(b, a % b);
    }

    private static KruskalMST findSpecialValue(double alpha, Edge[] edges) {
        for (Edge edge : edges) {
            edge.setWeight(edge.a - edge.b * alpha);
        }

        return new KruskalMST(edges);
    }

    private static class Edge {
        private int v;
        private int w;
        private int a;
        private int b;
        private double weight;

        Edge(int v, int w, int a, int b) {
            this.v = v;
            this.w = w;
            this.a = a;
            this.b = b;
        }

        void setWeight(double weight) {
            this.weight = weight;
        }
    }

    private static class KruskalMST {
        private double weight;
        private List<Edge> mst = new ArrayList<>(10000);

        KruskalMST(Edge[] G) {
            Arrays.sort(G, (o1, o2) -> {
                if (o2.weight > o1.weight) {
                    return 1;
                } else if (o2.weight < o1.weight) {
                    return -1;
                } else {
                    return 0;
                }
            });

            // run greedy algorithm
            int count = 0;
            UF uf = new UF(G.length);
            while (count < G.length && mst.size() < G.length - 1) {
                Edge e = G[count++];
                int v = e.v;
                int w = e.w;
                if (!uf.connected(v, w)) {
                    uf.union(v, w);
                    mst.add(e);
                    weight += e.weight;
                }
            }
        }
    }

    private static class UF {
        private int[] parent;
        private int[] size;
        private int count;

        UF(int n) {
            count = n;
            parent = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        public int count() {
            return count;
        }

        public int find(int p) {
            validate(p);
            int root = p;
            while (root != parent[root])
                root = parent[root];
            while (p != root) {
                int newp = parent[p];
                parent[p] = root;
                p = newp;
            }
            return root;
        }

        boolean connected(int p, int q) {
            return find(p) == find(q);
        }

        private void validate(int p) {
            int n = parent.length;
            if (p < 0 || p >= n) {
                throw new IndexOutOfBoundsException("index " + p + " is not between 0 and " + (n - 1));
            }
        }

        void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP == rootQ) return;

            // make smaller root point to larger one
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

    private static class InputReader {

        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;
        private SpaceCharFilter filter;

        InputReader(InputStream stream) {
            this.stream = stream;
        }

        int read() {
            if (numChars == -1)
                throw new InputMismatchException();
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (numChars <= 0)
                    return -1;
            }
            return buf[curChar++];
        }

        int readInt() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            int res = 0;
            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        String readString() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = read();
            } while (!isSpaceChar(c));
            return res.toString();
        }

        boolean isSpaceChar(int c) {
            if (filter != null)
                return filter.isSpaceChar(c);
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        public String next() {
            return readString();
        }

        public interface SpaceCharFilter {
            boolean isSpaceChar(int ch);
        }
    }
}
