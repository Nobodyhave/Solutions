package codechef;

import java.util.Scanner;

/**
 * Created by Aleksandr on 09/10/2017.
 * Project Solutions
 * <p>
 * https://www.codechef.com/OCT17/problems/MEX
 */
public class MaxMex {
    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);

        final int T = in.nextInt();
        for (int t = 0; t < T; t++) {
            final int N = in.nextInt();
            final int K = in.nextInt();
            final boolean[] used = new boolean[200001];
            for (int i = 0; i < N; i++) {
                used[in.nextInt()] = true;
            }

            System.out.println(findMex(used, K));
        }
    }

    private static int findMex(boolean[] used, int k) {
        int maxUsed = -1;
        for (int i = 0; i < used.length && k >= 0; i++) {
            if (!used[i]) {
                if (k == 0) {
                    return i;
                } else {
                    k--;
                }
            } else {
                maxUsed = i;
            }
        }

        return maxUsed + 1;
    }
}
