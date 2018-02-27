package hackerrank.algorithms.implementation;

import java.util.Scanner;

/**
 * Created by Aleksandr on 28/02/2017.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/day-of-the-programmer
 */
public class DayOfProgrammer {
    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);
        final int y = in.nextInt();

        if (y == 1918) {
            System.out.println("26.09." + y);
        } else if (y < 1918) {
            if (y % 4 == 0) {
                System.out.println("12.09." + y);
            } else {
                System.out.println("13.09." + y);
            }
        } else {
            if ((y % 400 == 0) || (y % 4 == 0 && y % 100 != 0)) {
                System.out.println("12.09." + y);
            } else {
                System.out.println("13.09." + y);
            }
        }
    }
}
