package hackerrank.java.exception_handling;

import java.util.Scanner;

/**
 * Created by Aleksandr on 23/01/2017.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/java-exception-handling
 */
public class JavaExceptionHandlingII {
    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);

        while (in.hasNextInt()) {
            int n = in.nextInt();
            int p = in.nextInt();
            final MyCalculator my_calculator = new MyCalculator();
            try {
                System.out.println(my_calculator.power(n, p));
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    private static class MyCalculator {
        public int power(int n, int p) throws Exception {
            if (n < 0 || p < 0) {
                throw new Exception("n and p should be non-negative");
            }

            return (int) Math.pow(n, p);
        }
    }
}
