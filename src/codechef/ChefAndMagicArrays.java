package codechef;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.InputMismatchException;

/**
 * Created by Aleksandr on 11/10/2017.
 * Project Solutions
 * <p>
 * https://www.codechef.com/OCT17/problems/MARRAYS
 */
public class ChefAndMagicArrays {
    public static void main(String[] args) throws IOException {
        //final InputReader in = new InputReader(System.in);
        //final long t1 = System.currentTimeMillis();
        final InputReader in = new InputReader(new FileInputStream("C:\\Projects\\Solutions\\src\\tests.txt"));

        final int T = in.readInt();
        for (int t = 0; t < T; t++) {
            final int N = in.readInt();
            final int[][] dishes = new int[N][];
            final long[][] quality = new long[N][];
            final int[][] path = new int[N][];
            for (int n = 0; n < N; n++) {
                final int M = in.readInt();
                dishes[n] = new int[M];
                quality[n] = new long[M];
                path[n] = new int[M];
                Arrays.fill(path[n], -1);

                for (int m = 0; m < M; m++) {
                    dishes[n][m] = in.readInt();
                }
            }

            long maxSum, maxDiff, maxDishTastiness, minDishTastiness;
            for (int dishIndex = N - 2; dishIndex >= 0; dishIndex--) {
                maxSum = Long.MIN_VALUE;
                maxDiff = Long.MIN_VALUE;
                maxDishTastiness = -1;
                minDishTastiness = -1;
                for (int i = 0; i < dishes[dishIndex + 1].length; i++) {
                    long prevDishIngredient = dishes[dishIndex + 1][i];
                    long sum = quality[dishIndex + 1][i] + prevDishIngredient * (dishIndex + 1);
                    long diff = quality[dishIndex + 1][i] - prevDishIngredient * (dishIndex + 1);
                    if (sum > maxSum) {
                        maxSum = sum;
                        maxDishTastiness = prevDishIngredient;
                    }
                    if (diff > maxDiff) {
                        maxDiff = diff;
                        minDishTastiness = prevDishIngredient;
                    }
                }

                System.out.println();

                for (int i = 0; i < dishes[dishIndex].length; i++) {
                    final long oppositeTastiness = last(dishes[dishIndex], dishes[dishIndex].length, i);
                    final long qualityWithSum = oppositeTastiness < maxDishTastiness ? maxSum - oppositeTastiness * (dishIndex + 1) : Long.MIN_VALUE;
                    final long qualityWithDiff = oppositeTastiness >= minDishTastiness ? maxDiff + oppositeTastiness * (dishIndex + 1) : Long.MIN_VALUE;
                    quality[dishIndex][i] = Math.max(qualityWithSum, qualityWithDiff);
                }

                System.out.println();
            }

            Arrays.stream(quality[0]).max().ifPresent(System.out::println);
        }
    }

    private static int last(int[] a, int m, int i) {
        return a[(i - 1 + m) % m];
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
