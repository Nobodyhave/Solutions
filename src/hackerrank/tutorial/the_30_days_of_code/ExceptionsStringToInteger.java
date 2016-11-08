package hackerrank.tutorial.the_30_days_of_code;

import java.util.Scanner;

/**
 * Created by Aleksandr on 04/11/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/30-exceptions-string-to-integer
 */
public class ExceptionsStringToInteger {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String S = in.next();

        try {
            System.out.println(Integer.parseInt(S));
        } catch (NumberFormatException e) {
            System.out.println("Bad String");
        }
    }
}
