package codechef;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.InputMismatchException;

/**
 * Created by Aleksandr on 12/10/2017.
 * Project Solutions
 * <p>
 * https://www.codechef.com/OCT17/problems/POINTCN
 */
public class ConnectingComputers {
    private static final Long[] S = new Long[2];

    private static Long xorShift128Plus() {
        Long x = S[0];
        final Long y = S[1];
        x ^= x << 23;
        S[1] = x ^ y ^ (x >>> 17) ^ (y >>> 26);
        return S[0] = y;
    }

    private static final int MX = 1000;
    private static final int[][] C = new int[MX][MX];
    private static final int[][] H = new int[MX][MX];

    public static void main(String[] args) throws IOException {
        //final InputReader in = new InputReader(System.in);
        //generateTest();
        //final long t1 = System.currentTimeMillis();
        final InputReader in = new InputReader(new FileInputStream("C:\\Projects\\Solutions\\src\\tests.txt"));
        final int T = in.readInt();
        for (int t = 0; t < T; t++) {
            final int N = in.readInt();
            final int maxC = in.readInt();
            final int maxH = in.readInt();
            for (int i = 0; i < N; i++) {
                C[i][i] = 0;
                final String seed1 = in.next();
                final String seed2 = in.next();
                S[0] = Long.parseUnsignedLong(seed1);
                S[1] = Long.parseUnsignedLong(seed2);
                for (int j = i + 1; j < N; j++) {
                    final Long value = Long.remainderUnsigned(xorShift128Plus(), maxC + 1);
                    C[i][j] = C[j][i] = Math.toIntExact(value);
                }
            }

            for (int i = 0; i < N; i++) {
                final String seed1 = in.next();
                final String seed2 = in.next();
                S[0] = Long.parseUnsignedLong(seed1);
                S[1] = Long.parseUnsignedLong(seed2);
                for (int j = 0; j < N; j++) {
                    final Long value = Long.remainderUnsigned(xorShift128Plus(), maxH + 1);
                    H[i][j] = Math.toIntExact(value);
                }
            }

            final int[] pathCheapestCables = new int[N];
            final long cheapestCablesCost = cheapestCablesCost(pathCheapestCables, N);
            final int[] pathCheapestLargestRouter = new int[N];
            final long cheapestLargestRouter = cheapestLargestRouter(pathCheapestLargestRouter, N);

            if(cheapestCablesCost < cheapestLargestRouter) {
                printResult(pathCheapestCables, N);
            } else {
                printResult(pathCheapestLargestRouter, N);
            }

        }
        //final long t2 = System.currentTimeMillis();
        //System.out.println("Time: " + (t2 - t1));
    }

    private static void printResult(int[] path, int N) {
        final StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (path[j] == i || path[i] == j) {
                    sb.append(1);
                } else {
                    sb.append(0);
                }
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }

    private static long cheapestLargestRouter(int[] path, int N) {
        Arrays.fill(path, -1);
        long minCost = Long.MAX_VALUE;
        int office = 0;
        for (int i = 0; i < N; i++) {
            if (H[i][N - 1] < minCost) {
                minCost = H[i][N - 1];
                office = i;
            }
        }

        for (int i = 0; i < N; i++) {
            if (i != office) {
                path[i] = office;
            }
        }

        long totalCost = H[office][N - 1];
        for (int i = 0; i < N; i++) {
            if (i != office) {
                totalCost += H[i][1];
                totalCost += C[i][office];
            }
        }

        return totalCost;
    }

    private static long cheapestCablesCost(int[] path, int N) {
        Arrays.fill(path, -1);
        final long[] cost = new long[N];
        final int[] count = new int[N];
        Arrays.fill(cost, Long.MAX_VALUE);

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (C[i][j] < cost[j]) {
                    cost[j] = C[i][j];
                    if (path[j] != -1) {
                        count[path[j]]--;
                    }
                    path[j] = i;
                    count[i]++;
                }
            }
        }

        long totalCost = 0;
        for (int i = 0; i < N; i++) {
            if (cost[i] != Long.MAX_VALUE) {
                totalCost += cost[i];
            }
            totalCost += H[i][count[i]];
        }

        return totalCost;
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
