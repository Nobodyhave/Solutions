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
 * Created by Aleksandr on 10/01/2018.
 * Project Solutions
 * <p>
 * https://www.codechef.com/JAN18/problems/MONSTER
 */
public class KillingMonsters {
    private static final int[] MASKS = new int[]{
            0,
            0b1,
            0b11,
            0b111,
            0b1111,
            0b11111,
            0b111111,
            0b1111111,
            0b11111111,
            0b111111111,
            0b1111111111,
            0b11111111111,
            0b111111111111,
            0b1111111111111,
            0b11111111111111,
            0b111111111111111,
            0b1111111111111111,
            0b11111111111111111,
            0b111111111111111111,};
    private static final int MAX_DAMAGE = -1000000000;

    private static void generateTest() throws IOException {
        final FileWriter fw = new FileWriter("C:\\Projects\\Solutions\\src\\tests.txt");
        final Random rand = new Random();
        final int T = 1;
        //fw.append(String.valueOf(T));
        //fw.append("\n");
        for (int t = 0; t < T; t++) {
            final int N = (int) Math.pow(2, 17) + 1;
            fw.append(String.valueOf(N));
            fw.append("\n");

            for (int i = 0; i < N; i++) {
                int h = rand.nextInt(1000000000) + 1;
                fw.append(String.valueOf(h));
                fw.append(" ");
            }
            fw.append("\n");

            final int Q = (int) Math.pow(2, 18) + 1;
            fw.append(String.valueOf(Q));
            fw.append("\n");
            for (int q = 0; q < Q; q++) {
                int x = rand.nextInt(1000000000 + 1);
                int y = 1;//rand.nextInt(1000000000) + 1;
                fw.append(String.valueOf(x));
                fw.append(" ");
                fw.append(String.valueOf(y));
                fw.append("\n");
            }
        }

        fw.flush();
        fw.close();
    }

    public static void main(String[] args) throws Exception {
        //generateTest();
        //final InputReader in = new InputReader(System.in);
        long t1 = System.currentTimeMillis();
        final InputReader in = new InputReader(new FileInputStream("C:\\Projects\\Solutions\\src\\tests.txt"));

        final int N = in.readInt();
        final int[] health = new int[N];
        for (int i = 0; i < N; i++) {
            health[i] = in.readInt();
        }

        final int Q = in.readInt();
        final int[][] queries = new int[Q][2];
        for (int q = 0; q < Q; q++) {
            queries[q][0] = in.readInt();
            queries[q][1] = in.readInt();
        }

        //brute(health.clone(), queries);
        //System.out.println("--------------------------");
        clever(health, queries);
        long t2 = System.currentTimeMillis();
        System.out.println("Time: " + (t2 - t1));
    }

    private static void clever(int[] monsters, int[][] queries) {
        final SegmentTree st = new SegmentTree(monsters);
        //System.out.println("Start: " + Arrays.toString(st.minimums));

        final StringBuilder sb = new StringBuilder();
        for (int[] query : queries) {
            final int shot = query[0] & 0x1FFFF;
            final int damage = query[1];
            st.update(shot, -damage);
            //System.out.println(Arrays.toString(st.minimums));
            sb.append(st.rangeQuery()).append('\n');
        }
        System.out.println(sb);
    }

    private static class SegmentTree {
        private static int R = 17;
        private int[] input;
        private long[] minimums;
        private long[] alive;
        private Map<Integer, Integer>[] lazyValues;

        public SegmentTree(int[] input) {
            this.input = input;
            final int segTreeSize = (int) Math.pow(2, R + 1) - 1;
            minimums = new long[segTreeSize];
            alive = new long[segTreeSize];
            createSegmentTree(0, R, 0);
            lazyValues = new Map[segTreeSize];
            for (int i = 0; i < segTreeSize; i++) {
                lazyValues[i] = new HashMap<>();
            }
        }

        void createSegmentTree(int idx, int digit, int present) {
            if (digit < 0 || idx >= input.length) {
                return;
            } else if (digit == 0) {
                minimums[present] = input[idx];
                alive[present] = 1;
            } else {
                createSegmentTree(idx * 2, digit - 1, present * 2 + 1);
                createSegmentTree(idx * 2 + 1, digit - 1, present * 2 + 2);
                if (minimums[present * 2 + 1] != 0 && minimums[present * 2 + 2] != 0) {
                    minimums[present] = Math.min(minimums[present * 2 + 1], minimums[present * 2 + 2]);
                } else if (minimums[present * 2 + 1] != 0) {
                    minimums[present] = minimums[present * 2 + 1];
                } else if (minimums[present * 2 + 2] != 0) {
                    minimums[present] = minimums[present * 2 + 2];
                } else {
                    minimums[present] = 0;
                }
                alive[present] = alive[present * 2 + 1] + alive[present * 2 + 2];
            }
        }

        long rangeQuery() {
            return alive[0];
            //return rangeQuery(0, input.length - 1, 0, input.length - 1, 0);
        }

        void update(int query, int x) {
            lazyUpdate(query, R - 1, 0, x);
        }

        private void lazyUpdate(int query, int digit, int current, int val) {
            // If all are dead in underlying leaves
            if (minimums[current] == 0) {
                alive[current] = 0;
                return;
            }

            // Apply collected lazy damage
            if (!lazyValues[current].isEmpty()) {
                for (Map.Entry<Integer, Integer> entry : lazyValues[current].entrySet()) {
                    minimums[current] = Math.max(minimums[current] + entry.getValue(), 0);
                    if (digit >= 0) {
                        final int key = entry.getKey() & MASKS[digit];
                        if (lazyValues[current * 2 + 1].containsKey(key)) {
                            lazyValues[current * 2 + 1].compute(key, (k, v) -> Math.max(MAX_DAMAGE, v + entry.getValue()));
                        } else {
                            lazyValues[current * 2 + 1].put(key, entry.getValue());
                        }
                        if (((entry.getKey() >> digit) & 1) != 0) {
                            if (lazyValues[current * 2 + 2].containsKey(key)) {
                                lazyValues[current * 2 + 2].compute(key, (k, v) -> Math.max(MAX_DAMAGE, v + entry.getValue()));
                            } else {
                                lazyValues[current * 2 + 2].put(key, entry.getValue());
                            }
                        }
                    }
                }
                lazyValues[current].clear();
            }

            // If all are dead in underlying leaves
            if (minimums[current] == 0) {
                alive[current] = 0;
                return;
            } else if (val == 0) {
                return;
            }

            // If we hit the leaf
            if (digit == -1) {
                minimums[current] = Math.max(minimums[current] + val, 0);
                if (minimums[current] == 0) {
                    alive[current] = 0;
                }
            } else if (digit != 0 && minimums[current] + val > 0) {
                minimums[current] = Math.max(minimums[current] + val, 0);
                final int key = query & MASKS[digit];
                if (lazyValues[current * 2 + 1].containsKey(key)) {
                    lazyValues[current * 2 + 1].compute(key, (k, v) -> Math.max(MAX_DAMAGE, v + val));
                } else {
                    lazyValues[current * 2 + 1].put(key, val);
                }
                if (((query >> digit) & 1) != 0) {
                    if (lazyValues[current * 2 + 2].containsKey(key)) {
                        lazyValues[current * 2 + 2].compute(key, (k, v) -> Math.max(MAX_DAMAGE, v + val));
                    } else {
                        lazyValues[current * 2 + 2].put(key, val);
                    }
                }
            } else {
                lazyUpdate(query, digit - 1, current * 2 + 1, val);
                if (((query >> digit) & 1) != 0) {
                    lazyUpdate(query, digit - 1, current * 2 + 2, val);
                } else {
                    lazyUpdate(query, digit - 1, current * 2 + 2, 0);
                }
                if (minimums[current * 2 + 1] != 0 && minimums[current * 2 + 2] != 0) {
                    minimums[current] = Math.max(Math.min(minimums[current * 2 + 1], minimums[current * 2 + 2]), 0);
                } else if (minimums[current * 2 + 1] != 0) {
                    minimums[current] = Math.max(minimums[current * 2 + 1], 0);
                } else if (minimums[current * 2 + 2] != 0) {
                    minimums[current] = Math.max(minimums[current * 2 + 2], 0);
                } else {
                    minimums[current] = 0;
                }
                if (minimums[current] == 0) {
                    alive[current] = 0;
                } else {
                    alive[current] = alive[current * 2 + 1] + alive[current * 2 + 2];
                }
            }
        }
    }

    private static void brute(int[] health, int[][] queries) {
        for (int[] query : queries) {
            final int x = query[0];
            final int y = query[1];

            int alive = 0;
            for (int i = 0; i < health.length; i++) {
                if (health[i] > 0 && (i & x) == i) {
                    health[i] -= y;
                }
                if (health[i] > 0) {
                    alive++;
                }
            }
            System.out.println(alive);
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
