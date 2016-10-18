package hackerrank.algorithms.implementation;

/**
 * Created by Aleksandr on 18/10/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/library-fine
 */

import java.util.Scanner;

public class LibraryFine {

    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);

        final int dayA = in.nextInt();
        final int monthA = in.nextInt();
        final int yearA = in.nextInt();

        final int dayE = in.nextInt();
        final int monthE = in.nextInt();
        final int yearE = in.nextInt();

        if (yearA > yearE) {
            System.out.println("10000");
        } else if (yearA == yearE && monthA > monthE) {
            System.out.println(500 * (monthA - monthE));
        } else if (yearA == yearE && monthA == monthE && dayA > dayE) {
            System.out.println(15 * (dayA - dayE));
        } else {
            System.out.println("0");
        }
    }
}
