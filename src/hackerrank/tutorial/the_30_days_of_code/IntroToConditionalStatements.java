package hackerrank.tutorial.the_30_days_of_code;

/**
 * Created by Aleksandr on 24/10/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/30-conditional-statements
 */

import java.util.Scanner;

public class IntroToConditionalStatements {

    public static void main(String[] args) {
        final Scanner scan = new Scanner(System.in);
        final int n = scan.nextInt();
        scan.close();
        String ans = "";

        if (n % 2 == 1) {
            ans = "Weird";
        } else {
            if (n >= 2 && n <= 5) {
                ans = "Not Weird";
            } else if (n >= 6 && n <= 20) {
                ans = "Weird";
            } else {
                ans = "Not Weird";
            }
        }

        System.out.println(ans);
    }
}

