package codechef;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Random;

/**
 * Created by Aleksandr on 06/11/2017.
 * Project Solutions
 * <p>
 * https://www.codechef.com/NOV17/problems/SEGPROD
 */
public class ProductOnSegmentByModulo {
    private static void generateTest() throws IOException {
        final FileWriter fw = new FileWriter("C:\\Projects\\Solutions\\src\\tests.txt");
        final Random rand = new Random();
        final int T = 10;
        fw.append(String.valueOf(T));
        fw.append("\n");
        for (int i = 0; i < T; i++) {
            final int N = 100000;
            final int P = 123678123;
            final int Q = 2000000;
            fw.append(String.valueOf(N));
            fw.append(" ");
            fw.append(String.valueOf(P));
            fw.append(" ");
            fw.append(String.valueOf(Q));
            fw.append("\n");

            for (int j = 0; j < N; j++) {
                fw.append(String.valueOf(rand.nextInt(1000)));
                fw.append(" ");
            }
            fw.append("\n");

            for (int j = 0; j < Q / 64 + 2; j++) {
                fw.append(String.valueOf(rand.nextInt(N)));
                fw.append(" ");
            }
            fw.append("\n");
        }

        fw.flush();
        fw.close();
    }

    public static void main(String[] args) throws IOException {
        final InputReader in = new InputReader(System.in);
        //generateTest();
        //final InputReader in = new InputReader(new FileInputStream("C:\\Projects\\Solutions\\src\\tests.txt"));

        final int T = in.readInt();
        for (int t = 0; t < T; t++) {
            final Map<Integer, Integer> cache = new HashMap<>();

            final int N = in.readInt();
            final int P = in.readInt();
            final int Q = in.readInt();
            final int phi = phi(P);

            final int[] A = new int[N];
            for (int i = 0; i < N; i++) {
                A[i] = in.readInt();
            }

            final int[] product = new int[N];
            product[0] = A[0] % P;
            for (int i = 1; i < N; i++) {
                product[i] = (int) (((long) product[i - 1] * (A[i] % P)) % P);
            }

            final int[] B = new int[Q / 64 + 2];
            for (int i = 0; i < B.length; i++) {
                B[i] = in.readInt();
            }
            //System.out.println(Arrays.toString(product));

            int L = 0, R = 0;
            int x = 0;
            for (int q = 0; q < Q; q++) {
                if (q % 64 == 0) {
                    L = (B[q / 64] + x) % N;
                    R = (B[q / 64 + 1] + x) % N;
                } else {
                    L = (L + x) % N;
                    R = (R + x) % N;
                }

                if (L > R) {
                    final int temp = L;
                    L = R;
                    R = temp;
                }

                if (L == 0) {
                    x = (product[R] + 1) % P;
                } else {
                    //System.out.format("Number: %d Inverse: %d\n", product[L - 1], inverse(product[L - 1], P));
                    x = (int) (((long) product[R] * (long) inverse(cache, product[L - 1], phi - 1, P) + 1) % (long) P);
                }
            }
            System.out.println(x);
        }
    }

    private static int inverse(Map<Integer, Integer> cache, int a, int phi, int m) {
        Integer num = cache.get(a);
        if (num != null) {
            return num;
        } else {
            num = (int) power(a, phi, m);
            cache.put(a, num);
        }

        return num;
    }

    // To compute x^y under modulo m
    private static long power(int x, int y, long m) {
        if (y == 0) {
            return 1;
        }
        long p = power(x, y / 2, m) % m;
        p = (p * p) % m;

        return (y % 2 == 0) ? p : (x * p) % m;
    }

    private static int phi(long n) {
        long result = n;   // Initialize result as n

        for (long p = 2; p * p <= n; ++p) {
            if (n % p == 0) {
                while (n % p == 0)
                    n /= p;
                result -= result / p;
            }
        }
        if (n > 1) {
            result -= result / n;
        }

        return (int) result;
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
