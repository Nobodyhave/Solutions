package codechef;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

/**
 * Created by Aleksandr on 09/01/2018.
 * Project Solutions
 * <p>
 * https://www.codechef.com/JAN18/problems/STRMRG
 */
public class StringMerging {
    private static final Map<Key, Integer> CACHE = new HashMap<>();

    private static void generateTest() throws IOException {
        final FileWriter fw = new FileWriter("C:\\Projects\\Solutions\\src\\tests.txt");
        final Random rand = new Random();
        final int T = 1;
        fw.append(String.valueOf(T));
        fw.append("\n");
        for (int i = 0; i < T; i++) {
            final int N = 5000;//rand.nextInt(10) + 1;
            final int M = 5000;//rand.nextInt(10) + 1;
            fw.append(String.valueOf(N));
            fw.append(" ");
            fw.append(String.valueOf(M));
            fw.append("\n");

            for (int j = 0; j < N; j++) {
                int offset = rand.nextInt(26);
                fw.append(String.valueOf((char) ('a' + offset)));
            }
            fw.append("\n");
            for (int j = 0; j < M; j++) {
                int offset = rand.nextInt(26);
                fw.append(String.valueOf((char) ('a' + offset)));
            }
            fw.append("\n");
        }

        fw.flush();
        fw.close();
    }

    public static void main(String[] args) throws Exception {
        //generateTest();
        //final Scanner in = new Scanner(System.in);
        long t1 = System.currentTimeMillis();
        final Scanner in = new Scanner(new FileInputStream("C:\\Projects\\Solutions\\src\\tests.txt"));

        final int T = in.nextInt();
        for (int t = 0; t < T; t++) {
            CACHE.clear();
            final int N = in.nextInt();
            final int M = in.nextInt();

            final String A = in.next();
            final String B = in.next();

            System.out.println("Clever: " + clever(N, M, A, B));
            //System.out.println("Brute: " + brute(A, B));
            //System.out.println("-----------------------------");
        }
        long t2 = System.currentTimeMillis();
        System.out.println("Time: " + (t2 - t1));
    }

    private static int brute(String A, String B) {
        return dfs(A, B, new StringBuilder(), 0, 0);
    }

    private static int dfs(String A, String B, StringBuilder sb, int startA, int startB) {
        if (startA == A.length() && startB == B.length()) {
            return 1;
        }
        if (sb.length() != 0) {
            final Key key = new Key(startA, startB, sb.charAt(sb.length() - 1));
            if (CACHE.containsKey(key)) {
                return CACHE.get(key);
            }
        }

        int result = Integer.MAX_VALUE;
        if (sb.length() == 0) {
            sb.append(A.charAt(startA));
            result = Math.min(result, dfs(A, B, sb, startA + 1, startB));
            sb.deleteCharAt(sb.length() - 1);
            sb.append(B.charAt(startB));
            result = Math.min(result, dfs(A, B, sb, startA, startB + 1));
            sb.deleteCharAt(sb.length() - 1);
        } else {
            if (startA != A.length()) {
                sb.append(A.charAt(startA));
                result = Math.min(result, dfs(A, B, sb, startA + 1, startB) + (sb.charAt(sb.length() - 2) == sb.charAt(sb.length() - 1) ? 0 : 1));
                sb.deleteCharAt(sb.length() - 1);
            }
            if (startB != B.length()) {
                sb.append(B.charAt(startB));
                result = Math.min(result, dfs(A, B, sb, startA, startB + 1) + (sb.charAt(sb.length() - 2) == sb.charAt(sb.length() - 1) ? 0 : 1));
                sb.deleteCharAt(sb.length() - 1);
            }
        }
        if (sb.length() != 0) {
            final Key key = new Key(startA, startB, sb.charAt(sb.length() - 1));
            CACHE.put(key, result);
        }

        return result;
    }

    private static int clever(int N, int M, String A, String B) {
        final int INF = 100000;
        final int R = 26;
        int[][] prevRow = new int[M + 1][R];
        int[][] curRow = new int[M + 1][R];

        for (int i = 0; i <= M; i++) {
            for (int k = 0; k < R; k++) {
                prevRow[i][k] = INF;
                curRow[i][k] = INF;
            }
        }


        for (int i = 0; i < R; i++) {
            prevRow[0][i] = 0;
        }
        prevRow[1][B.charAt(0) - 'a'] = 1;

        for (int i = 2; i <= M; i++) {
            if (B.charAt(i - 1) == B.charAt(i - 2)) {
                prevRow[i][B.charAt(i - 1) - 'a'] = prevRow[i - 1][B.charAt(i - 2) - 'a'];
            } else {
                prevRow[i][B.charAt(i - 1) - 'a'] = prevRow[i - 1][B.charAt(i - 2) - 'a'] + 1;
            }
        }


        for (int i = 1; i <= N; i++) {
            if (i > 1) {
                if (A.charAt(i - 1) == A.charAt(i - 2)) {
                    curRow[0][A.charAt(i - 1) - 'a'] = prevRow[0][A.charAt(i - 2) - 'a'];
                } else {
                    curRow[0][A.charAt(i - 1) - 'a'] = prevRow[0][A.charAt(i - 2) - 'a'] + 1;
                }
            } else {
                curRow[0][A.charAt(0) - 'a'] = 1;
            }

            for (int j = 1; j <= M; j++) {
                curRow[j][A.charAt(i - 1) - 'a'] = Math.min(curRow[j][A.charAt(i - 1) - 'a'], prevRow[j][B.charAt(j - 1) - 'a'] + (B.charAt(j - 1) == A.charAt(i - 1) ? 0 : 1));
                if (i > 1) {
                    curRow[j][A.charAt(i - 1) - 'a'] = Math.min(curRow[j][A.charAt(i - 1) - 'a'], prevRow[j][A.charAt(i - 2) - 'a'] + ((A.charAt(i - 2)) == A.charAt(i - 1) ? 0 : 1));
                }

                curRow[j][B.charAt(j - 1) - 'a'] = Math.min(curRow[j][B.charAt(j - 1) - 'a'], curRow[j - 1][A.charAt(i - 1) - 'a'] + (A.charAt(i - 1) == B.charAt(j - 1) ? 0 : 1));
                if (j > 1) {
                    curRow[j][B.charAt(j - 1) - 'a'] = Math.min(curRow[j][B.charAt(j - 1) - 'a'], curRow[j - 1][B.charAt(j - 2) - 'a'] + (B.charAt(j - 2) == B.charAt(j - 1) ? 0 : 1));
                }
            }

            final int[][] temp = prevRow;
            prevRow = curRow;
            curRow = temp;
            for (int l = 0; l <= M; l++) {
                for (int k = 0; k < R; k++) {
                    curRow[l][k] = INF;
                }
            }
        }

        int min = Integer.MAX_VALUE;
        for (int num : prevRow[M]) {
            min = Math.min(min, num);
        }

        return min;
    }

    private static class Key {
        private int remainingA;
        private int remainingB;
        private char startingChar;

        Key(int remainingA, int remainingB, char startingChar) {
            this.remainingA = remainingA;
            this.remainingB = remainingB;
            this.startingChar = startingChar;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Key key = (Key) o;
            return remainingA == key.remainingA &&
                    remainingB == key.remainingB &&
                    startingChar == key.startingChar;
        }

        @Override
        public int hashCode() {
            return Objects.hash(remainingA, remainingB, startingChar);
        }
    }
}
