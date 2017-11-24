package hackerrank.algorithms.contests_unpublished;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.InputMismatchException;
import java.util.Random;

/**
 * Created by Aleksandr on 16/11/2017.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/contests/w35/challenges/matrix-land
 */
public class MatrixLand {
    private static int[] prefixLtoR;
    private static int[] maxLtoR;
    private static int[] prefixRtoL;
    private static int[] maxRtoL;
    private static int[] prefixLtoRFull;
    private static int[] prefixRtoLFull;
    private static int[] maxLtoRFull;
    private static int[] maxRtoLFull;

    private static void generateTest() throws IOException {
        final FileWriter fw = new FileWriter("C:\\Projects\\Solutions\\src\\tests.txt");
        final Random rand = new Random();

        final int N = 10;
        final int M = 10;
        fw.append(String.valueOf(N));
        fw.append(" ");
        fw.append(String.valueOf(M));
        fw.append("\n");

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                final int num = rand.nextInt(250) + 1 - 125;
                fw.append(String.valueOf(num));
                fw.append(" ");
            }
            fw.append("\n");
        }

        fw.flush();
        fw.close();
    }

    private static int matrixLand(int[][] A, int n, int m) {
        final int[][] dp = new int[n][m];
        prefixLtoR = new int[m];
        prefixRtoL = new int[m];
        maxLtoR = new int[m];
        maxRtoL = new int[m];
        prefixLtoRFull = new int[m];
        prefixRtoLFull = new int[m];
        maxLtoRFull = new int[m];
        maxRtoLFull = new int[m];
        for (int i = 0; i < n; i++) {
            calculateRow(A, dp, m, i);
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < m; i++) {
            max = Math.max(max, dp[n - 1][i]);
        }

        return max;
    }

    private static void calculateRow(int[][] A, int[][] dp, int m, int row) {
        prefixLtoR[0] = A[row][0];
        for (int i = 1; i < m; i++) {
            prefixLtoR[i] = prefixLtoR[i - 1] + A[row][i];
        }
        prefixRtoL[m - 1] = A[row][m - 1];
        for (int i = m - 2; i >= 0; i--) {
            prefixRtoL[i] = prefixRtoL[i + 1] + A[row][i];
        }

        maxLtoR[m - 1] = prefixLtoR[m - 1];
        for (int i = m - 2; i >= 0; i--) {
            maxLtoR[i] = Math.max(prefixLtoR[i], maxLtoR[i + 1]);
        }
        maxRtoL[0] = prefixRtoL[0];
        for (int i = 1; i < m; i++) {
            maxRtoL[i] = Math.max(prefixRtoL[i], maxRtoL[i - 1]);
        }

        for (int i = 0; i < m; i++) {
            prefixLtoRFull[i] = prefixLtoR[i] + (row != 0 ? dp[row - 1][i] : 0) + calculateRightRun(maxLtoR, prefixLtoR, i);
        }
        for (int i = m - 1; i >= 0; i--) {
            prefixRtoLFull[i] = prefixRtoL[i] + (row != 0 ? dp[row - 1][i] : 0) + calculateLeftRun(maxRtoL, prefixRtoL, i);
        }

        maxLtoRFull[m - 1] = prefixLtoRFull[m - 1];
        for (int i = m - 2; i >= 0; i--) {
            maxLtoRFull[i] = Math.max(prefixLtoRFull[i], maxLtoRFull[i + 1]);
        }
        maxRtoLFull[0] = prefixRtoLFull[0];
        for (int i = 1; i < m; i++) {
            maxRtoLFull[i] = Math.max(prefixRtoLFull[i], maxRtoLFull[i - 1]);
        }

        for (int i = 0; i < m; i++) {
            int length = Integer.MIN_VALUE;

            length = Math.max(length,
                    (row != 0 ? dp[row - 1][i] : 0)
                            + A[row][i]
                            + calculateLeftRun(maxRtoL, prefixRtoL, i)
                            + calculateRightRun(maxLtoR, prefixLtoR, i));

            length = Math.max(length,
                    maxLtoRFull[i]
                            + calculateLeftRun(maxRtoL, prefixRtoL, i)
                            - (i != 0 ? prefixLtoR[i - 1] : 0));
            length = Math.max(length,
                    maxRtoLFull[i]
                            + calculateRightRun(maxLtoR, prefixLtoR, i)
                            - (i != m - 1 ? prefixRtoL[i + 1] : 0));
            dp[row][i] = length;
        }
    }

    private static int calculateLeftRun(int[] max, int[] prefix, int x) {
        if (x - 1 < 0 || x - 1 >= prefix.length - 1) {
            return 0;
        }

        int run = max[x - 1];
        if (run != Integer.MIN_VALUE) {
            run = run - prefix[x];
        }

        return Math.max(run, 0);
    }

    private static int calculateRightRun(int[] max, int[] prefix, int x) {
        if (x + 1 < 0 || x + 1 >= prefix.length - 1) {
            return 0;
        }

        int run = max[x + 1];
        if (run != Integer.MIN_VALUE) {
            run = run - prefix[x];
        }

        return Math.max(run, 0);
    }

    public static void main(String[] args) throws IOException {
        //final InputReader in = new InputReader(System.in);
        generateTest();
        long t1 = System.currentTimeMillis();
        final InputReader in = new InputReader(new FileInputStream("C:\\Projects\\Solutions\\src\\tests.txt"));
        final int n = in.readInt();
        final int m = in.readInt();
        final int[][] A = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                A[i][j] = in.readInt();
            }
        }
        int result = matrixLand(A, n, m);
        System.out.println(result);
        long t2 = System.currentTimeMillis();
        System.out.println("Time: " + (t2 - t1));
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
