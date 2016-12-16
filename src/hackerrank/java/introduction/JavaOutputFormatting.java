package hackerrank.java.introduction;

import java.util.Scanner;

/**
 * Created by Aleksandr on 13/12/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/java-output-formatting
 */
public class JavaOutputFormatting {
    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);
        System.out.println("================================");
        for (int i = 0; i < 3; i++) {
            final String s = in.next();
            final int x = in.nextInt();
            System.out.format("%-15s%03d\n", s, x);
        }
        System.out.println("================================");

    }
}
