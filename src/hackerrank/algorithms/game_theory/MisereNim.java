package hackerrank.algorithms.game_theory;

import java.util.Scanner;

/**
 * Created by Aleksandr on 02/01/2017.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/misere-nim-1
 */
public class MisereNim {
    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);

        final int T = in.nextInt();

        for (int t = 0; t < T; t++) {
            final int N = in.nextInt();
            final int[] s = new int[N];

            int xor = 0;
            boolean isSomeMore1 = false;
            for (int i = 0; i < N; i++) {
                int num = in.nextInt();
                xor ^= num;
                if (num > 1) {
                    isSomeMore1 = true;
                }
            }

            if (isSomeMore1 && xor == 0 || !isSomeMore1 && xor == 1) {
                System.out.println("Second");
            } else {
                System.out.println("First");
            }
        }
    }
}
