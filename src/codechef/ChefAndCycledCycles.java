package codechef;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.InputMismatchException;
import java.util.Random;

/**
 * Created by Aleksandr on 10/10/2017.
 * Project Solutions
 * <p>
 * https://www.codechef.com/OCT17/problems/CHEFCCYL
 */
public class ChefAndCycledCycles {
    private static void generateTest() throws IOException {
        final Random rand = new Random();
        final StringBuilder sb = new StringBuilder();
        final int T = 1;
        sb.append(T).append("\n");
        for (int t = 0; t < T; t++) {
            final int N = rand.nextInt(10) + 1;
            final int Q = rand.nextInt(10) + 1;
            final int[] sizes = new int[N];
            sb.append(N).append(" ").append(Q).append("\n");
            for (int n = 0; n < N; n++) {
                final int A = rand.nextInt(10) + 1;
                sizes[n] = A;
                sb.append(A).append(" ");
                for (int a = 0; a < A; a++) {
                    sb.append(rand.nextInt(1000) + 1).append(" ");
                }
                sb.append("\n");
            }
            for (int n = 0; n < N; n++) {
                final int v1 = rand.nextInt(sizes[n]) + 1;
                final int v2 = rand.nextInt(sizes[(n + 1) % N]) + 1;
                final int w = rand.nextInt(1000) + 1;
                sb.append(v1).append(" ").append(v2).append(" ").append(w).append("\n");
            }
            for (int q = 0; q < Q; q++) {
                final int c1 = rand.nextInt(N) + 1;
                final int v1 = rand.nextInt(sizes[c1 - 1]) + 1;
                final int c2 = rand.nextInt(N) + 1;
                final int v2 = rand.nextInt(sizes[c2 - 1]) + 1;
                sb.append(v1).append(" ").append(c1).append(" ").append(v2).append(" ").append(c2).append("\n");
            }
        }

        final FileWriter fw = new FileWriter("C:\\Projects\\Solutions\\src\\tests.txt");
        fw.write(sb.toString());
        fw.flush();
        fw.close();
    }

    public static void main(String[] args) throws IOException {
        //final InputReader in = new InputReader(System.in);
        //generateTest();
        final InputReader in = new InputReader(new FileInputStream("C:\\Projects\\Solutions\\src\\tests.txt"));

        final int T = in.readInt();
        for (int t = 0; t < T; t++) {
            final int N = in.readInt();
            final int Q = in.readInt();

            final long[][] cycles = new long[N][];
            for (int i = 0; i < N; i++) {
                final int A = in.readInt();
                cycles[i] = new long[A + 1];
                cycles[i][0] = 0;
                for (int j = 1; j <= A; j++) {
                    cycles[i][j] = cycles[i][j - 1] + in.readInt();
                }
            }

            final Edge[] connections = new Edge[N];
            for (int i = 0; i < N; i++) {
                connections[i] = new Edge(in.readInt() - 1, in.readInt() - 1, in.readInt());
            }

            final int size = 2 * N;
            final long[] dist = new long[size];
            for (int i = 0; i < N; i++) {
                dist[2 * i] = minDistInCycle(cycles[i], Math.min(connections[(i - 1 + N) % N].v, connections[i].u), Math.max(connections[(i - 1 + N) % N].v, connections[i].u));
                dist[(2 * i + 1) % size] = connections[i].w;
            }

            final long[] prefix = new long[size];
            prefix[0] = dist[0];
            for (int i = 1; i < size; i++) {
                prefix[i] = prefix[i - 1] + dist[i];
            }

            for (int q = 0; q < Q; q++) {
                int v1 = in.readInt() - 1;
                final int c1 = in.readInt() - 1;
                int v2 = in.readInt() - 1;
                final int c2 = in.readInt() - 1;

                if (c1 == c2) {
                    System.out.println(dist[2 * c1]);
                    continue;
                }

                int minC;
                int maxC;
                if (c1 < c2) {
                    minC = c1;
                    maxC = c2;
                } else {
                    minC = c2;
                    maxC = c1;
                    int temp = v1;
                    v1 = v2;
                    v2 = temp;
                }
                int start = 2 * minC + 1;
                int end = 2 * maxC - 1;

                long forwardOuter = forward(prefix, start - 1, end);
                long forwardPathC1 = minDistInCycle(cycles[minC], Math.min(v1, connections[minC].u), Math.max(v1, connections[minC].u));
                long forwardPathC2 = minDistInCycle(cycles[maxC], Math.min(connections[maxC - 1].v, v2), Math.max(connections[maxC - 1].v, v2));
                long forwardPath = forwardPathC1 + forwardOuter + forwardPathC2;
                start = (2 * minC - 1 + size) % size;
                end = (2 * maxC + 1) % size;
                long backwardOuter;
                if (start >= end) {
                    backwardOuter = forward(prefix, end - 1, start);
                } else {
                    backwardOuter = backward(prefix, start, end - 1);
                }

                long backwardPathC1 = minDistInCycle(cycles[minC], Math.min(v1, connections[(minC - 1 + N) % N].v), Math.max(v1, connections[(minC - 1 + N) % N].v));
                long backwardPathC2 = minDistInCycle(cycles[maxC], Math.min(connections[maxC].u, v2), Math.max(connections[maxC].u, v2));
                long backwardPath = backwardPathC1 + backwardOuter + backwardPathC2;

                System.out.println(Math.min(forwardPath, backwardPath));
            }
        }
    }

    private static long forward(long[] dist, int start, int end) {
        return dist[end] - dist[start];
    }

    private static long backward(long[] dist, int start, int end) {
        return dist[start] + (dist[dist.length - 1] - dist[end]);
    }

    private static long minDistInCycle(long[] dist, int start, int end) {
        return Math.min(forward(dist, start, end), backward(dist, start, end));
    }

    private static class Edge {
        private int u;
        private int v;
        private long w;

        Edge(int u, int v, long w) {
            this.u = u;
            this.v = v;
            this.w = w;
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
