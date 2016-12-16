package hackerrank.java.strings;

import java.util.Scanner;

/**
 * Created by Aleksandr on 13/12/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/java-substring
 */
public class JavaSubstring {
    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);
        final String S = in.next();
        final int start = in.nextInt();
        final int end = in.nextInt();

        System.out.println(S.substring(start, end));
    }
}
