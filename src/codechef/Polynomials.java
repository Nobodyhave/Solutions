package codechef;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Random;

/**
 * Created by Aleksandr on 08/11/2017.
 * Project Solutions
 * <p>
 * https://www.codechef.com/NOV17/problems/POLY
 */
public class Polynomials {
    private static final long[][] POWERS = new long[100001][4];
    private static final Map<Integer, Long> CACHE = new HashMap<>();

    private static void generateTest() throws IOException {
        final FileWriter fw = new FileWriter("C:\\Projects\\Solutions\\src\\tests.txt");
        final Random rand = new Random();
        final int T = 5;
        fw.append(String.valueOf(T));
        fw.append("\n");
        for (int t = 0; t < T; t++) {
            final int N = rand.nextInt(1001);
            fw.append(String.valueOf(N));
            fw.append("\n");

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < 4; j++) {
                    if (j != 3) {
                        //fw.append(String.valueOf(rand.nextInt(100001)));
                        fw.append(String.valueOf(100000));
                    } else {
                        //fw.append(String.valueOf(rand.nextInt(1001)));
                        fw.append(String.valueOf(1000));
                    }
                    fw.append(" ");
                }
                fw.append("\n");
            }

            final int Q = rand.nextInt(1001);
            fw.append(String.valueOf(Q));
            fw.append("\n");

            for (int q = 0; q < Q; q++) {
                //fw.append(String.valueOf(rand.nextInt(100001)));
                fw.append(String.valueOf(100000));
                fw.append("\n");
            }
        }
        fw.flush();
        fw.close();
    }

    public static void main(String[] args) throws IOException {
        //final InputReader in = new InputReader(System.in);
        generateTest();
        final InputReader in = new InputReader(new FileInputStream("C:\\Projects\\Solutions\\src\\tests.txt"));

        for (int i = 0; i <= 100000; i++) {
            for (int j = 0; j <= 3; j++) {
                POWERS[i][j] = (long) Math.pow(i, j);
            }
        }

        final int T = in.readInt();
        for (int t = 0; t < T; t++) {
            CACHE.clear();
            final int N = in.readInt();
            final int[][] polynomials = new int[N][4];
            boolean case2 = true;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < 4; j++) {
                    polynomials[i][j] = in.readInt();
                    if (i >= 2 && polynomials[i][j] != 0) {
                        case2 = false;
                    }
                }
            }

            final int Q = in.readInt();
            for (int q = 0; q < Q; q++) {
                final int x = in.readInt();
                if(!case2) {
                    System.out.println(findMin(polynomials, x));
                } else {
                    System.out.println(findMin(polynomials, x));
                }
            }
        }
    }

    private static long findMin(int[][] polynomials, int x) {
        if (CACHE.containsKey(x)) {
            return CACHE.get(x);
        }

        long min = Long.MAX_VALUE;
        for (int[] polynomial : polynomials) {
            long result = 0;
            for (int j = 0; j < 4; j++) {
                result += (long) polynomial[j] * POWERS[x][j];
            }
            min = Math.min(min, result);
        }
        CACHE.put(x, min);

        return min;
    }

    private static long findMinCase2(int[][] polynomials, int x) {
        if (CACHE.containsKey(x)) {
            return CACHE.get(x);
        }

        long min = Long.MAX_VALUE;
        for (int[] polynomial : polynomials) {
            long result = 0;
            for (int j = 0; j < 4; j++) {
                result += (long) polynomial[j] * POWERS[x][j];
            }
            min = Math.min(min, result);
        }
        CACHE.put(x, min);

        return min;
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
