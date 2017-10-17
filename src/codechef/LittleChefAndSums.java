package codechef;

import java.util.Scanner;

/**
 * Created by Aleksandr on 09/10/2017.
 * Project Solutions
 * <p>
 * https://www.codechef.com/status/CHEFSUM
 */
public class LittleChefAndSums {
    public static void main(String[] args) throws java.lang.Exception {
        final Scanner in = new Scanner(System.in);

        final int T = in.nextInt();
        for (int t = 0; t < T; t++) {
            final int N = in.nextInt();
            int min = Integer.MAX_VALUE, minIndex = -1;
            for (int i = 0; i < N; i++) {
                int a = in.nextInt();
                if (a < min) {
                    min = a;
                    minIndex = i;
                }
            }

            System.out.println(minIndex + 1);
        }
    }
}
