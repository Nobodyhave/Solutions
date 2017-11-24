package codechef;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by Aleksandr on 07/11/2017.
 * Project Solutions
 * <p>
 * https://www.codechef.com/NOV17/problems/LVGFT
 */
public class LoversGift {
    private static void generateTest() throws IOException {
        final FileWriter fw = new FileWriter("C:\\Projects\\Solutions\\src\\tests.txt");
        final Random rand = new Random();
        final int T = 5;
        fw.append(String.valueOf(T));
        fw.append("\n");
        for (int i = 0; i < T; i++) {
            final int N = rand.nextInt(1000) + 1;
            final int M = rand.nextInt(1000) + 1;
            fw.append(String.valueOf(N));
            fw.append(" ");
            fw.append(String.valueOf(M));
            fw.append("\n");

            final int[] vertices = new int[N];
            for (int j = 0; j < N; j++) {
                vertices[j] = j + 1;
            }
            shuffleArray(vertices);

            for (int j = 1; j < N; j++) {
                int u = vertices[j];
                int v = vertices[rand.nextInt(j)];
                fw.append(String.valueOf(u));
                fw.append(" ");
                fw.append(String.valueOf(v));
                fw.append("\n");
            }

            for (int j = 0; j < M; j++) {
                final int type = rand.nextInt(2) + 1;
                fw.append(String.valueOf(type));
                fw.append(" ");
                final int C = rand.nextInt(N) + 1;
                fw.append(String.valueOf(C));
                fw.append("\n");
            }
        }

        fw.flush();
        fw.close();
    }

    private static void shuffleArray(int[] a) {
        final Random rnd = ThreadLocalRandom.current();
        for (int i = a.length - 1; i > 0; i--) {
            int index = rnd.nextInt(i + 1);
            swap(a, i, index);
        }
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) throws IOException {
        //final InputReader in = new InputReader(System.in);
        final InputReader in = new InputReader(new FileInputStream("C:\\Projects\\Solutions\\src\\tests.txt"));

        final int T = in.readInt();
        for (int t = 0; t < T; t++) {
            final int N = in.readInt();
            final int M = in.readInt();

            final Graph graph = new Graph(2 * N);
            for (int i = 0; i < N - 1; i++) {
                graph.addEdge(in.readInt(), in.readInt());
            }
            final boolean[] banks = new boolean[2 * N];
            for (int i = 0; i < M; i++) {
                final int type = in.readInt();
                if (type == 1) {
                    banks[in.readInt()] = true;
                } else {
                    System.out.println(buyGift(graph, banks, in.readInt()));
                }
            }
        }
    }

    private static int buyGift(Graph graph, boolean[] banks, int city) {
        final PriorityQueue<Integer> pq = new DepthFirstSearch(graph, banks, city).pq;
        if (pq.size() < 2) {
            return -1;
        } else {
            pq.poll();
            return pq.poll();
        }
    }

    private static class DepthFirstSearch {
        private boolean[] marked;
        private PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> Integer.compare(b, a));

        DepthFirstSearch(Graph G, boolean[] banks, int s) {
            marked = new boolean[G.size()];
            dfs(G, banks, s, banks[s]);
        }

        private void dfs(Graph G, boolean[] banks, int v, boolean bankVisited) {
            marked[v] = true;
            if (bankVisited) {
                pq.add(v);
            }
            for (Integer w : G.adj(v)) {
                if (w != null && !marked[w]) {
                    dfs(G, banks, w, bankVisited || banks[w]);
                }
            }
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

    private static class InputReader {
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;

        InputReader(InputStream stream) {
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
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        public String next() {
            return readString();
        }
    }
}
