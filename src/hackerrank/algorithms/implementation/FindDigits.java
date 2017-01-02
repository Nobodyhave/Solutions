package hackerrank.algorithms.implementation;

import java.util.Scanner;

/**
 * Created by Aleksandr on 02/01/2017.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/find-digits
 */
public class FindDigits {
    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);
        final int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            final int n = in.nextInt();

            final String str = String.valueOf(n);
            int count = 0;
            for (int i = 0; i < str.length(); i++) {
                int digit = str.charAt(i) - '0';

                if (digit != 0 && n % digit == 0) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}
