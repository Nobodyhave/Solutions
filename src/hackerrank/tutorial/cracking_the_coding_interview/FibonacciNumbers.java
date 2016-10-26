package hackerrank.tutorial.cracking_the_coding_interview;

/**
 * Created by Aleksandr on 25/10/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/ctci-fibonacci-numbers
 */

import java.util.Scanner;

public class FibonacciNumbers {

    public static int fibonacci(int n) {
        if (n == 1 || n == 2) {
            return 1;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();
        System.out.println(fibonacci(n));
    }
}

