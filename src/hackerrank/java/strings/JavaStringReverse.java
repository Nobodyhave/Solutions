package hackerrank.java.strings;

import java.util.Scanner;

/**
 * Created by Aleksandr on 13/12/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/java-string-reverse
 */
public class JavaStringReverse {
    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);
        final String A = in.next();

        int start = 0, end = A.length() - 1;
        while (start < end) {
            if (A.charAt(start) != A.charAt(end)) {
                System.out.println("No");
                return;
            }
            start++;
            end--;
        }
        System.out.println("Yes");
    }
}
