package hackerrank.algorithms.contests_unpublished;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by Aleksandr on 17/05/2017.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/contests/w32/challenges/circular-walk
 */
public class CircularWalk {
    private static int circularWalk(int n, int s, int t, int r_0, int g, int seed, int p) {
        if (s == t) {
            return 0;
        }

        final long[] R = new long[n];
        R[0] = r_0;
        for (int i = 1; i < n; i++) {
            R[i] = (R[i - 1] * g + seed) % p;
        }

        long curDistLeft = 0, curDistRight = 0, maxDistLeft = R[s], maxDistRight = R[s];
        long targetDist = Math.min(Math.max(s, t) - Math.min(s, t), Math.min(s, t) + n - Math.max(s, t));

        for (int i = 1; i < n; i++) {
            if (targetDist <= maxDistLeft || targetDist <= maxDistRight) {
                return i;
            }

            long borderL = maxDistLeft, borderR = maxDistRight;
            for (long j = curDistLeft; j <= borderL; j++) {
                int v = (int) (s - j + n) % n;
                maxDistLeft = Math.max(maxDistLeft, Math.min(j + R[v], n));
                maxDistRight = Math.max(maxDistRight, Math.min(R[v] - j, n));
            }

            for (long j = curDistRight; j <= borderR; j++) {
                int v = (int) (s + j) % n;
                maxDistLeft = Math.max(maxDistLeft, Math.min(R[v] - j, n));
                maxDistRight = Math.max(maxDistRight, Math.min(R[v] + j, n));
            }

            curDistLeft = borderL + 1;
            curDistRight = borderR + 1;
        }

        return -1;
    }

    public static void main(String[] args) throws IOException {
        final Scanner in = new Scanner(new FileInputStream("C:\\Projects\\Solutions\\src\\tests.txt"));
        final int n = in.nextInt();
        final int s = in.nextInt();
        final int t = in.nextInt();
        final int r_0 = in.nextInt();
        final int g = in.nextInt();
        final int seed = in.nextInt();
        final int p = in.nextInt();

        System.out.println(circularWalk(n, s, t, r_0, g, seed, p));
    }
}
