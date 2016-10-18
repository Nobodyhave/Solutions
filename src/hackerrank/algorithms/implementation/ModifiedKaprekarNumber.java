package hackerrank.algorithms.implementation;

/**
 * Created by Aleksandr on 18/10/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/kaprekar-numbers
 */

import java.io.FileNotFoundException;
import java.util.Scanner;

public class ModifiedKaprekarNumber {

    public static void main(String[] args) throws FileNotFoundException {
        final Scanner in = new Scanner(System.in);

        final int p = in.nextInt();
        final int q = in.nextInt();

        boolean isFound = false;
        for (int i = p; i <= q; i++) {
            final int d = digitsCount(i);
            long square = (long) Math.pow(i, 2);

            long right = square % getDivider(d);
            long left = square / getDivider(d);

            if (left + right == i) {
                isFound = true;
                System.out.print(i + " ");
            }
        }

        if (!isFound) {
            System.out.println("INVALID RANGE");
        }
    }

    private static int digitsCount(int num) {
        if (num >= 0 && num <= 9) {
            return 1;
        } else if (num >= 10 && num <= 99) {
            return 2;
        } else if (num >= 100 && num <= 999) {
            return 3;
        } else if (num >= 1000 && num <= 9999) {
            return 4;
        } else if (num >= 10000 && num <= 99999) {
            return 5;
        } else if (num >= 100000 && num <= 999999) {
            return 6;
        } else {
            throw new IllegalArgumentException("Unsupported range");
        }
    }

    private static int getDivider(int digitsCount) {
        return (int) Math.pow(10, digitsCount);
    }
}
