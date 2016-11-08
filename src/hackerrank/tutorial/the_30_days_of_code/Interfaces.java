package hackerrank.tutorial.the_30_days_of_code;

import java.util.Scanner;

/**
 * Created by Aleksandr on 08/11/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/30-interfaces
 */
class Interfaces {

    public static void main(String[] args) {
        final Scanner scan = new Scanner(System.in);
        final int n = scan.nextInt();
        scan.close();

        final AdvancedArithmetic myCalculator = new Calculator();
        final int sum = myCalculator.divisorSum(n);
        System.out.println("I implemented: " + myCalculator.getClass().getInterfaces()[0].getName());
        System.out.println(sum);
    }

    private interface AdvancedArithmetic {
        int divisorSum(int n);
    }

    private static class Calculator implements AdvancedArithmetic {

        public int divisorSum(int n) {
            int sum = 0;
            for (int i = 1; i <= n; i++) {
                if (n % i == 0) {
                    sum += i;
                }
            }

            return sum;
        }
    }
}
