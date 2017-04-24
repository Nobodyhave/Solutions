package hackerrank.algorithms.graph_theory;

/**
 * Created by Aleksandr on 01/11/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/dijkstrashortreach/submissions/code/29498861
 */

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class DijkstraShortestReach2 {

    public static void main(String[] args) throws IOException {
        final InputReader reader = new InputReader(System.in);

        final int T = reader.readInt();

        for (int t = 0; t < T; t++) {
            int N = reader.readInt();
            int M = reader.readInt();

            final List<WeightedEdge>[] vertices = (List<WeightedEdge>[]) new ArrayList[N + 1];
            for (int i = 0; i <= N; i++) {
                vertices[i] = new ArrayList<>(10000);
            }

            for (int i = 0; i < M; i++) {
                int from = reader.readInt();
                int to = reader.readInt();
                int weight = reader.readInt();
                vertices[from].add(new WeightedEdge(from, to, weight));
                vertices[to].add(new WeightedEdge(to, from, weight));
            }

            final int s = reader.readInt();

            final int[] distTo = new int[N + 1];
            Arrays.fill(distTo, -1);
            distTo[s] = 0;

            IndexMinPQ<Integer> queue = new IndexMinPQ<>(N + 1);
            queue.insert(s, distTo[s]);
            while (!queue.isEmpty()) {
                int v = queue.delMin();
                for (WeightedEdge edge : vertices[v]) {
                    int from = edge.from;
                    int to = edge.to;
                    int weight = edge.weight;
                    if (distTo[to] == -1 || (distTo[to] > distTo[from] + weight)) {
                        distTo[to] = distTo[from] + weight;
                        if (queue.contains(to)) {
                            queue.change(to, distTo[to]);
                        } else {
                            queue.insert(to, distTo[to]);
                        }
                    }
                }
            }

            for (int i = 1; i <= N; i++) {
                if (i != s) {
                    System.out.print(distTo[i] + " ");
                }
            }
            System.out.println();
        }
    }

    private static class WeightedEdge {
        int from;
        int to;
        int weight;

        public WeightedEdge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }

    private static class IndexMinPQ<Key extends Comparable<Key>> {
        private int maxN;
        private int N;
        private int[] pq;
        private int[] qp;
        private Key[] keys;

        public IndexMinPQ(int maxN) {
            if (maxN < 0) throw new IllegalArgumentException();
            this.maxN = maxN;
            keys = (Key[]) new Comparable[maxN + 1];
            pq = new int[maxN + 1];
            qp = new int[maxN + 1];
            for (int i = 0; i <= maxN; i++)
                qp[i] = -1;
        }

        public boolean isEmpty() {
            return N == 0;
        }

        public boolean contains(int i) {
            if (i < 0 || i >= maxN) throw new IndexOutOfBoundsException();
            return qp[i] != -1;
        }

        public void insert(int i, Key key) {
            if (i < 0 || i >= maxN) throw new IndexOutOfBoundsException();
            if (contains(i)) throw new IllegalArgumentException("index is already in the priority queue");
            N++;
            qp[i] = N;
            pq[N] = i;
            keys[i] = key;
            swim(N);
        }

        public int delMin() {
            if (N == 0) throw new NoSuchElementException("Priority queue underflow");
            int min = pq[1];
            exch(1, N--);
            sink(1);
            assert min == pq[N + 1];
            qp[min] = -1;        // delete
            keys[min] = null;    // to help with garbage collection
            pq[N + 1] = -1;        // not needed
            return min;
        }

        public void changeKey(int i, Key key) {
            if (i < 0 || i >= maxN) throw new IndexOutOfBoundsException();
            if (!contains(i)) throw new NoSuchElementException("index is not in the priority queue");
            keys[i] = key;
            swim(qp[i]);
            sink(qp[i]);
        }

        public void change(int i, Key key) {
            changeKey(i, key);
        }

        private boolean greater(int i, int j) {
            return keys[pq[i]].compareTo(keys[pq[j]]) > 0;
        }

        private void exch(int i, int j) {
            int swap = pq[i];
            pq[i] = pq[j];
            pq[j] = swap;
            qp[pq[i]] = i;
            qp[pq[j]] = j;
        }

        private void swim(int k) {
            while (k > 1 && greater(k / 2, k)) {
                exch(k, k / 2);
                k = k / 2;
            }
        }

        private void sink(int k) {
            while (2 * k <= N) {
                int j = 2 * k;
                if (j < N && greater(j, j + 1)) j++;
                if (!greater(k, j)) break;
                exch(k, j);
                k = j;
            }
        }
    }

    private static class InputReader {

        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;
        private SpaceCharFilter filter;

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        public int read() {
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

        public int readInt() {
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

        public String readString() {
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

        public boolean isSpaceChar(int c) {
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


