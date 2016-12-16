package hackerrank.java.strings;

import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/**
 * Created by Aleksandr on 13/12/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/pattern-syntax-checker
 */
public class PatternSyntaxChecker {
    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);
        final int T = Integer.parseInt(in.nextLine());
        while (T > 0) {
            final String pattern = in.nextLine();
            try {
                Pattern.compile(pattern);
                System.out.println("Valid");
            } catch (PatternSyntaxException e) {
                System.out.println("Invalid");
            }
        }
    }
}
