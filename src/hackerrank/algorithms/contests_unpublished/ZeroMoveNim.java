package hackerrank.algorithms.contests_unpublished;

import java.util.Scanner;

/**
 * Created by Aleksandr on 30/12/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/contests/w27/challenges/zero-move-nim
 */

public class ZeroMoveNim {
    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);
        final int g = in.nextInt();
        for (int a0 = 0; a0 < g; a0++) {
            final int n = in.nextInt();
            final int[] p = new int[n];
            int xor = 0;
            for (int p_i = 0; p_i < n; p_i++) {
                p[p_i] = in.nextInt();
                if (p[p_i] % 2 == 0) {
                    xor ^= p[p_i] - 1;
                } else {
                    xor ^= p[p_i] + 1;
                }
            }

            if (xor != 0) {
                System.out.println("W");
            } else {
                System.out.println("L");
            }
        }
    }
}
