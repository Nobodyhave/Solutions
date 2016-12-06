package hackerrank.mathematics.fundamentals;

import java.util.Scanner;

/**
 * Created by Aleksandr on 06/12/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/filling-jars
 */
public class FillingJars {
    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);

        final int N = in.nextInt();
        final int M = in.nextInt();
        long result = 0;
        for (int m = 0; m < M; m++) {
            final int a = in.nextInt();
            final int b = in.nextInt();
            final int k = in.nextInt();

            result += (b - a + 1) * (long) k;
        }

        System.out.println(result / N);
    }
}
