package hackerrank.algorithms.contests_unpublished;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.InputMismatchException;

/**
 * Created by Aleksandr on 24/04/2017.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/contests/w31/challenges/nominating-group-leaders
 */
public class NominatingGroupLeaders {
    private static int sz;
    private static int[] votesForStudents;
    private static int[][] freqOfFreq;

    public static void main(String[] args) throws IOException {
        //final InputReader in = new InputReader(System.in);
        final InputReader in = new InputReader(new FileInputStream("C:\\Projects\\Solutions\\src\\tests.txt"));
        final int T = in.readInt();
        final StringBuilder sb = new StringBuilder(100000);
        for (int t = 0; t < T; t++) {
            final int n = in.readInt();
            sz = (int) Math.sqrt(n);

            votesForStudents = new int[n + 1];
            freqOfFreq = new int[sz + 1][n + 1];

            final int[] votes = new int[n];
            for (int i = 0; i < n; i++) {
                votes[i] = in.readInt();
            }

            final int G = in.readInt();
            final Query[] queries = new Query[G];
            final int[] ans = new int[G];
            for (int g = 0; g < G; g++) {
                int l = in.readInt();
                int r = in.readInt();
                int x = in.readInt();
                queries[g] = new Query(l, r, x, g);
            }

            Arrays.sort(queries);

            for (int i = queries[0].l; i <= queries[0].r; i++) {
                update(votes[i]);
            }
            ans[queries[0].index] = getResult(queries[0]);
            int l = queries[0].l, r = queries[0].r;

            for (int i = 1; i < queries.length; i++) {
                Query query = queries[i];
                if (r < query.r) {
                    while (r < query.r) {
                        r++;
                        update(votes[r]);
                    }
                } else if (r > query.r) {
                    while (r > query.r) {
                        remove(votes[r]);
                        r--;
                    }
                }
                r = query.r;

                if (l < query.l) {
                    while (l < query.l) {
                        remove(votes[l]);
                        l++;
                    }
                } else if (l > query.l) {
                    while (l > query.l) {
                        l--;
                        update(votes[l]);
                    }
                }
                l = query.l;


                ans[query.index] = getResult(query);
            }

            for (int an : ans) {
                sb.append(an).append("\n");
            }
        }
        System.out.println(sb.toString());
    }

    private static int getResult(Query query) {
        int res = -1;
        for (int i = 0; i < freqOfFreq.length; i++) {
            if (freqOfFreq[i][query.x] != 0) {
                int start = i * freqOfFreq.length;
                int end = Math.min(start + freqOfFreq.length, votesForStudents.length);

                for (int j = start; j < end; j++) {
                    if (votesForStudents[j] == query.x) {
                        return j;
                    }
                }
            }
        }

        return res;
    }

    private static void update(int i) {
        final int block = i / freqOfFreq.length;
        freqOfFreq[block][votesForStudents[i]]--;
        votesForStudents[i]++;
        freqOfFreq[block][votesForStudents[i]]++;
    }

    private static void remove(int i) {
        final int block = i / freqOfFreq.length;
        freqOfFreq[block][votesForStudents[i]]--;
        votesForStudents[i]--;
        freqOfFreq[block][votesForStudents[i]]++;
    }

    private static class Query implements Comparable<Query> {
        int l, r, x, index;

        Query(int l, int r, int x, int index) {
            this.l = l;
            this.r = r;
            this.x = x;
            this.index = index;
        }

        @Override
        public int compareTo(Query o) {
            if ((l) / sz != (o.l) / sz)
                return (l) / sz - (o.l) / sz;
            return r - o.r;
        }
    }

    private static class InputReader {
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;
        private SpaceCharFilter filter;

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
            if (filter != null)
                return filter.isSpaceChar(c);
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        public String next() {
            return readString();
        }

        public interface SpaceCharFilter {
            boolean isSpaceChar(int ch);
        }
    }
}
