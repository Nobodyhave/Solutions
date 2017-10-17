package codechef;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.InputMismatchException;

/**
 * Created by Aleksandr on 12/10/2017.
 * Project Solutions
 * <p>
 * https://www.codechef.com/OCT17/problems/SHTARR
 */
public class ShootingOnArray {
    public static void main(String[] args) throws IOException {
        //final InputReader in = new InputReader(System.in);
        //generateTest();
        //final long t1 = System.currentTimeMillis();
        final InputReader in = new InputReader(new FileInputStream("C:\\Projects\\Solutions\\src\\tests.txt"));

        final int T = in.readInt();
        for (int t = 0; t < T; t++) {
            final int N = in.readInt();
            final int Q = in.readInt();
            final int[] A = new int[N];
            for (int n = 0; n < N; n++) {
                A[n] = in.readInt();
            }
            final SegmentTree segmentTree = new SegmentTree(A);
            for (int q = 0; q < Q; q++) {
                final String[] split = in.next().split(" ");
                if (split[0].equals("+")) {
                    int index = Integer.parseInt(split[1]);
                    int value = Integer.parseInt(split[2]);
                    segmentTree.update(index - 1, index - 1, value);
                } else {
                    int i = Integer.parseInt(split[1]);
                    int L = Integer.parseInt(split[2]);
                    int R = Integer.parseInt(split[3]);
                    int startX = i - 1;
                    int minY = L;
                    int maxY = R;
                }
            }
        }
        //final long t2 = System.currentTimeMillis();
        //System.out.println("Time: " + (t2 - t1));
    }

    private static class SegmentTree {
        private int[] input;
        private long[] values;
        private long[] lazyValues;

        public SegmentTree(int[] input) {
            this.input = input;
            final int segTreeSize = (int) Math.pow(2, (int) Math.ceil(Math.log(input.length) / Math.log(2))) * 2 - 1;
            values = new long[segTreeSize];
            createSegmentTree(0, input.length - 1, 0); //low,high,present
            lazyValues = new long[segTreeSize];
        }

        void createSegmentTree(int low, int high, int present) {
            if (low == high) {
                values[present] = input[low];
            } else {
                final int mid = (high + low) / 2;
                createSegmentTree(low, mid, present * 2 + 1);
                createSegmentTree(mid + 1, high, present * 2 + 2);
                values[present] = Math.max(values[present * 2 + 1], values[present * 2 + 2]);
            }
        }

        public long rangeQuery(int low, int high) {
            return rangeQuery(0, input.length - 1, low, high, 0);
        }

        long rangeQuery(int low, int high, int qLow, int qHigh, int present) {
            if (qHigh < low || qLow > high) {
                return Integer.MIN_VALUE;
            }
            if (lazyValues[present] != 0) {
                values[present] += lazyValues[present];
                if (low != high) {
                    lazyValues[present * 2 + 1] += lazyValues[present];
                    lazyValues[present * 2 + 2] += lazyValues[present];
                }
                lazyValues[present] = 0;
            }
            if (low >= qLow && high <= qHigh) {
                return values[present];
            }
            final int mid = (low + high) / 2;

            return Math.max(
                    rangeQuery(low, mid, qLow, qHigh, present * 2 + 1),
                    rangeQuery(mid + 1, high, qLow, qHigh, present * 2 + 2));
        }

        public void update(int low, int high, int x) {
            lazyUpdate(0, input.length - 1, low, high, 0, x);
        }

        private void lazyUpdate(int low, int high, int qLow, int qHigh, int current, int val) {
            if (lazyValues[current] != 0) {
                values[current] += lazyValues[current];
                if (low != high) {
                    lazyValues[current * 2 + 1] += lazyValues[current];
                    lazyValues[current * 2 + 2] += lazyValues[current];
                }
                lazyValues[current] = 0;
            }
            if (qLow > high || qHigh < low) {
            } else if (qLow <= low && qHigh >= high) {
                values[current] += val;
                if (high != low) {
                    lazyValues[current * 2 + 1] += val;
                    lazyValues[current * 2 + 2] += val;
                }
            } else {
                final int mid = (low + high) / 2;
                lazyUpdate(low, mid, qLow, qHigh, current * 2 + 1, val);
                lazyUpdate(mid + 1, high, qLow, qHigh, current * 2 + 2, val);
                values[current] = Math.max(values[current * 2 + 1], values[current * 2 + 2]);
            }
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
