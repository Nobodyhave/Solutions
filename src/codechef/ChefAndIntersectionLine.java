package codechef;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.InputMismatchException;
import java.util.Random;

/**
 * Created by Aleksandr on 07/11/2017.
 * Project Solutions
 * <p>
 * https://www.codechef.com/NOV17/problems/CHEFNIL
 */
public class ChefAndIntersectionLine {
    private static final int SHORT = 50;
    private static final int LONG = 500;

    private static void generateTest() throws IOException {
        final FileWriter fw = new FileWriter("C:\\Projects\\Solutions\\src\\tests.txt");
        final Random rand = new Random();
        final int N = 50;
        final int M = 50;
        fw.append(String.valueOf(N));
        fw.append(" ");
        fw.append(String.valueOf(M));
        fw.append("\n");

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    fw.append(String.valueOf(rand.nextInt(100) + 1));
                    fw.append(" ");
                }
                fw.append("\n");
            }
            fw.append("\n");
        }

        fw.flush();
        fw.close();
    }

    public static void main(String[] args) throws IOException {
        //final InputReader in = new InputReader(System.in);
        generateTest();
        long t1 = System.currentTimeMillis();
        final InputReader in = new InputReader(new FileInputStream("C:\\Projects\\Solutions\\src\\tests.txt"));

        final int N = in.readInt();
        final int M = in.readInt();

        final int[][][] A = new int[M][N][N];
        for (int m = 0; m < M; m++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    A[m][i][j] = in.readInt();
                }
            }
        }

        if (M == SHORT) {
            traverseShort(A, N);
        } else {
            traverseLong(A, N);
        }
        long t2 = System.currentTimeMillis();
        System.out.println("Time: " + (t2 - t1));
    }

    private static void traverseShort(int[][][] A, int N) {
        final int T = 800000;
        int bestResult = Integer.MIN_VALUE;
        int[][] bestPath = new int[SHORT][2];
        final Random rand = new Random();
        for (int t = 0; t < T; t++) {
            int result;
            final int[][] path = new int[SHORT][2];
            final int side = rand.nextInt(4);
            int row, col;
            switch (side) {
                case 0: // Start from up
                    row = 0;
                    col = rand.nextInt(N);
                    break;
                case 1: // Start from right
                    row = rand.nextInt(N);
                    col = N - 1;
                    break;
                case 2: // Start from bottom
                    row = N - 1;
                    col = rand.nextInt(N);
                    break;
                default: // Start from left
                    row = rand.nextInt(N);
                    col = 0;
                    break;
            }

            result = A[0][row][col];
            path[0][0] = row + 1;
            path[0][1] = col + 1;
            for (int i = 1; i < SHORT; i++) {
                switch (side) {
                    case 0: // Start from up
                        row += 1;
                        col = rand.nextInt(N);//getShortStep(rand, N, col);
                        break;
                    case 1: // Start from right
                        row = rand.nextInt(N);//getShortStep(rand, N, row);
                        col -= 1;
                        break;
                    case 2: // Start from bottom
                        row -= 1;
                        col = rand.nextInt(N);//getShortStep(rand, N, col);
                        break;
                    default: // Start from left
                        row = rand.nextInt(N);//getShortStep(rand, N, row);
                        col += 1;
                        break;
                }
                result += A[i][row][col];
                path[i][0] = row + 1;
                path[i][1] = col + 1;
            }

            if (result > bestResult) {
                bestResult = result;
                bestPath = path;
            }
        }

        for (int i = 0; i < SHORT; i++) {
            if (bestPath[i][0] == 0 && bestPath[i][1] == 0) {
                System.out.format("%d %d\n", -1, -1);
                break;
            } else {
                System.out.format("%d %d\n", bestPath[i][0], bestPath[i][1]);
            }
        }
    }

    private static void traverseLong(int[][][] A, int N) {
        final int T = 90000;
        int bestResult = Integer.MIN_VALUE;
        int[][] bestPath = new int[LONG][2];
        final Random rand = new Random();
        for (int t = 0; t < T; t++) {
            int result;
            final int[][] path = new int[LONG][2];
            final int dirHor = rand.nextInt(2); // 0 up, 1 down
            final int dirVer = rand.nextInt(2); // 0 left, 1 right
            int row = rand.nextInt(N);
            int col = rand.nextInt(N);

            result = A[0][row][col];
            path[0][0] = row + 1;
            path[0][1] = col + 1;

            for (int i = 1; i < LONG; i++) {
                if (dirVer == 0) {
                    row--;
                    if (row < 0) {
                        row = N - 1;
                        if (dirHor == 0) {
                            col--;
                        } else {
                            col++;
                        }
                        if (col < 0 || col >= N) {
                            break;
                        }
                    }
                } else {
                    row++;
                    if (row >= N) {
                        row = 0;
                    }
                    if (dirHor == 0) {
                        col--;
                    } else {
                        col++;
                    }
                    if (col < 0 || col >= N) {
                        break;
                    }
                }
                result += A[i][row][col];
                path[i][0] = row + 1;
                path[i][1] = col + 1;
            }

            if (result > bestResult) {
                bestResult = result;
                bestPath = path;
            }
        }

        for (int i = 0; i < LONG; i++) {
            if (bestPath[i][0] == 0 && bestPath[i][1] == 0) {
                System.out.format("%d %d\n", -1, -1);
                break;
            } else {
                System.out.format("%d %d\n", bestPath[i][0], bestPath[i][1]);
            }
        }
    }

    private static int getShortStep(Random rand, int N, int cur) {
        if (cur == 0) {
            return rand.nextInt(2);
        } else if (cur == N - 1) {
            return rand.nextInt(2) - 1;
        } else {
            return rand.nextInt(3) - 1;
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
