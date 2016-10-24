package hackerrank.tutorial.cracking_the_coding_interview;

/**
 * Created by Aleksandr on 24/10/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/ctci-big-o
 */

import java.util.Scanner;

public class Primality {

    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);
        final int p = in.nextInt();
        for (int i = 0; i < p; i++) {
            int n = in.nextInt();

            System.out.println(isPrime(n) ? "Prime" : "Not prime");
        }
    }

    private static boolean isPrime(int n) {
        if (n == 2) {
            return true;
        } else if (n == 1 || n % 2 == 0) {
            return false;
        }

        final int sqrt = (int) Math.sqrt(n) + 1;
        for (int i = 3; i < sqrt; i += 2) {
            if (n % i == 0 && n / i != 1) {
                return false;
            }
        }

        return true;
    }
}

