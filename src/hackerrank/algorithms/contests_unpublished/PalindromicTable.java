package hackerrank.algorithms.contests_unpublished;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.InputMismatchException;
import java.util.PriorityQueue;

/**
 * Created by Aleksandr on 15/06/2017.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/contests/w33/challenges/palindromic-table
 */
public class PalindromicTable {
    public static void main(String[] args) throws FileNotFoundException {
        //final InputReader in = new InputReader(System.in);
        final InputReader in = new InputReader(new FileInputStream("C:\\Projects\\Solutions\\src\\tests.txt"));

        final int n = in.readInt();
        final int m = in.readInt();
        final int[][] table = new int[n][m];
        boolean isNonZero = false;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                table[i][j] = in.readInt();
                if (table[i][j] != 0) {
                    isNonZero = true;
                }
            }
        }

        // Hack for worst case when all digits are 0
        if (!isNonZero) {
            System.out.format("%d\n%d %d %d %d", 1, 0, 0, 0, 0);
            return;
        }

        final int[][][] counts = new int[n + 1][m + 1][10];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                mergeCounts(counts[i][j], counts[i - 1][j], counts[i][j - 1], counts[i - 1][j - 1]);
                counts[i][j][table[i - 1][j - 1]]++;
            }
        }

        final PriorityQueue<Rect> rectangles = new PriorityQueue<>();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                rectangles.add(new Rect(i, j));
            }
        }

        while (!rectangles.isEmpty()) {
            final Rect rect = rectangles.poll();
            for (int y1 = 0; y1 <= n - rect.n; y1++) {
                for (int x1 = 0; x1 <= m - rect.m; x1++) {
                    final int area = calculateArea(counts, x1, y1, x1 + rect.m - 1, y1 + rect.n - 1);
                    if (area > 0) {
                        System.out.format("%d\n%d %d %d %d", area, y1, x1, y1 + rect.n - 1, x1 + rect.m - 1);
                        return;
                    }
                }
            }
        }

        System.out.format("%d\n%d %d %d %d", 1, 0, 0, 0, 0);
    }

    private static int calculateArea(int[][][] C, int x1, int y1, int x2, int y2) {
        final int[] result = new int[10];
        for (int i = 0; i < 10; i++) {
            result[i] = calculateDigitCount(C, x1, y1, x2, y2, i);
        }

        int oddCounter = 0;
        int zeroCounter = result[0];
        int totalCounter = 0;
        for (int i = 0; i < 10; i++) {
            totalCounter += result[i];
            if (result[i] % 2 != 0) {
                oddCounter++;
            }
        }

        if (totalCounter - zeroCounter < 2) {
            return -1;
        }

        if (oddCounter > 1) {
            return -1;
        }

        return (y2 - y1 + 1) * (x2 - x1 + 1);
    }

    private static int calculateDigitCount(int[][][] C, int x1, int y1, int x2, int y2, int i) {
        return -C[y1][x2 + 1][i] // Remove top bar
                - C[y2 + 1][x1][i] // Remove left bar
                + C[y1][x1][i] // Restore bars intersection as it was deleted twice
                + C[y2 + 1][x2 + 1][i]; // Restore bars intersection as it was deleted twice
    }

    private static void mergeCounts(int[] destination, int[] upperSource, int[] leftSource, int[] upperLeftSource) {
        for (int i = 0; i < 10; i++) {
            destination[i] = upperSource[i] + leftSource[i] - upperLeftSource[i];
        }
    }

    private static class Rect implements Comparable<Rect> {
        private final int area;
        private final int n;
        private final int m;

        Rect(int n, int m) {
            this.n = n;
            this.m = m;

            area = n * m;
        }

        @Override
        public int compareTo(Rect o) {
            return Integer.compare(o.area, area);
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
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        public String next() {
            return readString();
        }
    }
}
