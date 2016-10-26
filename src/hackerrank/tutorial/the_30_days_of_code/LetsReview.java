package hackerrank.tutorial.the_30_days_of_code;

/**
 * Created by Aleksandr on 25/10/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/30-review-loop
 */

import java.util.Scanner;

public class LetsReview {

    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);

        final int T = in.nextInt();
        for (int t = 0; t < T; t++) {
            final String str = in.next();
            final StringBuilder even = new StringBuilder();
            final StringBuilder odd = new StringBuilder();

            for (int i = 0; i < str.length(); i++) {
                if (i % 2 == 0) {
                    even.append(str.charAt(i));
                } else {
                    odd.append(str.charAt(i));
                }
            }
            System.out.println(even.toString() + " " + odd.toString());
        }
    }
}
