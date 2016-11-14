package hackerrank.tutorial.the_30_days_of_code;

/**
 * Created by Aleksandr on 14/11/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/30-running-time-and-complexity
 */

import java.util.Scanner;

public class RunningTimeAndComplexity {

    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);

        final int T = in.nextInt();
        for (int t = 0; t < T; t++) {
            final int N = in.nextInt();
            if (N == 1) {
                System.out.println("Not prime");
                continue;
            } else if (N == 2) {
                System.out.println("Prime");
                continue;
            } else if (N % 2 == 0) {
                System.out.println("Not prime");
                continue;
            }

            final int sqrt = (int) Math.sqrt(N) + 1;
            boolean isPrime = true;
            for (int i = 3; i < sqrt; i += 2) {
                if (N % i == 0) {
                    isPrime = false;
                    break;
                }
            }

            if (isPrime) {
                System.out.println("Prime");
            } else {
                System.out.println("Not prime");
            }
        }
    }
}
