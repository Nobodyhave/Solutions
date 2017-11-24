package codechef;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by Aleksandr on 03/11/2017.
 * Project Solutions
 * <p>
 * https://www.codechef.com/NOV17/problems/CLRL
 */
public class ChefGoesLeftRightLeft {
    public static void main(String[] args) throws FileNotFoundException {
        //final Scanner in = new Scanner(System.in);
        final Scanner in = new Scanner(new FileInputStream("C:\\Projects\\Solutions\\src\\tests.txt"));

        final int T = in.nextInt();
        outer:
        for (int t = 0; t < T; t++) {
            final int N = in.nextInt();
            final int R = in.nextInt();

            final int[] rating = new int[N];
            for (int i = 0; i < N; i++) {
                rating[i] = in.nextInt();
            }

            if (N == 1) {
                System.out.println("YES");
                continue;
            }

            boolean goingDown = rating[0] > rating[1];
            int min = goingDown ? Integer.MIN_VALUE : rating[0];
            int max = goingDown ? rating[0] : Integer.MAX_VALUE;

            for (int i = 2; i < N; i++) {
                if (rating[i] > max || rating[i] < min) {
                    System.out.println("NO");
                    continue outer;
                } else if (rating[i] > rating[i - 1]) {
                    min = rating[i - 1];
                } else if (rating[i] < rating[i - 1]) {
                    max = rating[i - 1];
                }
            }

            System.out.println("YES");
        }
    }
}
