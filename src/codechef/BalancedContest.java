package codechef;

import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by Aleksandr on 09/10/2017.
 * Project Solutions
 * <p>
 * https://www.codechef.com/OCT17/problems/PERFCONT
 */
public class BalancedContest {
    public static void main(String[] args) throws FileNotFoundException {
        final Scanner in = new Scanner(System.in);

        final int T = in.nextInt();
        for (int t = 0; t < T; t++) {
            final int N = in.nextInt();
            final int P = in.nextInt();
            int cakeWalk = 0, hard = 0;
            for (int i = 0; i < N; i++) {
                int p = in.nextInt();
                if (p >= P / 2) {
                    cakeWalk++;
                }
                if (p <= P / 10) {
                    hard++;
                }
            }

            System.out.println(cakeWalk == 1 && hard == 2 ? "yes" : "no");
        }
    }
}
