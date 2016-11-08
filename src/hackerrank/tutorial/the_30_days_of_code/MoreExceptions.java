package hackerrank.tutorial.the_30_days_of_code;

import java.util.Scanner;

/**
 * Created by Aleksandr on 08/11/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/30-more-exceptions
 */
class MoreExceptions {

    public static void main(String[] argh) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        while (T-- > 0) {
            int n = in.nextInt();
            int p = in.nextInt();
            Calculator myCalculator = new Calculator();
            try {
                int ans = myCalculator.power(n, p);
                System.out.println(ans);

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static class Calculator {

        public int power(int n, int p) {
            if (n < 0 || p < 0) {
                throw new IllegalArgumentException("n and p should be non-negative");
            } else {
                return (int) Math.pow(n, p);
            }
        }

    }
}

