package hackerrank.algorithms.warmup;

/**
 * Created by Aleksandr on 08/11/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/solve-me-first/submissions/code/27462484
 */

import java.util.Scanner;

public class SolveMeFirst {

    static int solveMeFirst(int a, int b) {
        return a + b;

    }

    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);
        final int a = in.nextInt();
        final int b = in.nextInt();
        in.close();
        final int sum = solveMeFirst(a, b);
        System.out.println(sum);
    }
}

