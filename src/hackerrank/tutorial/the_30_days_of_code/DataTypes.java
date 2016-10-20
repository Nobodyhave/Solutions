package hackerrank.tutorial.the_30_days_of_code;

import java.util.Scanner;

/**
 * Created by Aleksandr on 20/10/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/30-data-types
 */
public class DataTypes {
    public static void main(String[] args) {
        final int i = 4;
        final double d = 4.0;
        final String s = "HackerRank ";

        final Scanner scan = new Scanner(System.in);

        /* Declare second integer, double, and String variables. */
        /* Read and save an integer, double, and String to your variables.*/
        final int i2 = scan.nextInt();
        final double d2 = scan.nextDouble();
        final String s2 = scan.next() + scan.nextLine();

        /* Print the sum of both integer variables on a new line. */
        System.out.println(i + i2);
        /* Print the sum of the double variables on a new line. */
        System.out.println(d + d2);
        /* Concatenate and print the String variables on a new line;
            the 's' variable above should be printed first. */
        System.out.println(s + s2);
    }
}
