package hackerrank.java.introduction;

import java.util.Scanner;

/**
 * Created by Aleksandr on 13/12/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/java-loops
 */
public class JavaLoopsII {
    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();
        for (int t = 0; t < T; t++) {
            final int a = in.nextInt();
            final int b = in.nextInt();
            final int n = in.nextInt();

            int sum = a;
            for (int i = 0; i < n; i++) {
                sum += (int) Math.pow(2, i) * b;
                System.out.format("%d ", sum);
            }
            System.out.println();
        }
        in.close();
    }
}
