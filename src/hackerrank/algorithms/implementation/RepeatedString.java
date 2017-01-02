package hackerrank.algorithms.implementation;

import java.util.Scanner;

/**
 * Created by Aleksandr on 02/01/2017.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/repeated-string
 */
public class RepeatedString {
    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);
        final String s = in.next();
        final long n = in.nextLong();
        long count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'a') {
                count++;
            }
        }
        count = count * (n / s.length());
        final long remains = n % s.length();
        for (int i = 0; i < remains; i++) {
            if (s.charAt(i) == 'a') {
                count++;
            }
        }

        System.out.println(count);
    }
}
