package hackerrank.tutorial.the_30_days_of_code;

/**
 * Created by Aleksandr on 24/10/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/30-loops
 */

import java.util.Scanner;

public class Loops {

    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);
        final int n = in.nextInt();

        for (int i = 1; i <= 10; i++) {
            System.out.format("%d x %d = %d\n", n, i, n * i);
        }
    }
}

