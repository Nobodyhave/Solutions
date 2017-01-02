package hackerrank.algorithms.game_theory;

import java.util.Scanner;

/**
 * Created by Aleksandr on 02/01/2017.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/tower-breakers-1
 */
public class TowerBreakers {
    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();

        for (int t = 0; t < T; t++) {
            final int N = in.nextInt();
            final int M = in.nextInt();
            int count = 1;
            if (M != 1) {
                double sqrt = Math.sqrt(M);
                while (Math.floor(sqrt) == Math.ceil(sqrt)) {
                    count++;
                    sqrt = Math.sqrt(sqrt);
                }
            }

            count = count * N;

            if (count % 2 == 0 && N % 2 == 0 || M == 1) {
                System.out.println(2);
            } else {
                System.out.println(1);
            }
        }
    }
}
