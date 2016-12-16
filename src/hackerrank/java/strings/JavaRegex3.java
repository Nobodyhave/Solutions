package hackerrank.java.strings;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Aleksandr on 13/12/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/valid-username-checker
 */
public class JavaRegex3 {
    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);
        int T = Integer.parseInt(in.nextLine());
        while (T > 0) {
            final String username = in.nextLine();
            final String s = "^[A-Za-z][A-Za-z0-9_]{7,29}$";
            final Pattern pattern = Pattern.compile(s);
            final Matcher m = pattern.matcher(username);

            if (m.find()) {
                System.out.println("Valid");
            } else {
                System.out.println("Invalid");
            }
            T--;
        }
    }
}
