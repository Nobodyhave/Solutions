package hackerrank.java.strings;

import java.util.Scanner;

/**
 * Created by Aleksandr on 13/12/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/java-strings-introduction
 */
public class JavaStringsIntroduction {
    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);
        final String A = in.next();
        final String B = in.next();

        System.out.println(A.length() + B.length());
        if (A.compareTo(B) > 0) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
        System.out.println(capitalize(A) + " " + capitalize(B));
    }

    private static String capitalize(final String line) {
        return Character.toUpperCase(line.charAt(0)) + line.substring(1);
    }
}
