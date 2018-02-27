package hackerrank.algorithms.implementation;

import java.util.Scanner;

/**
 * Created by Aleksandr on 10/02/2017.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/grading
 */
public class GradingStudents {
    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);
        final int n = in.nextInt();
        for (int a0 = 0; a0 < n; a0++) {
            final int grade = in.nextInt();

            if (grade < 38) {
                System.out.println(grade);
            } else if (grade % 5 >= 3) {
                System.out.println((grade / 5 + 1) * 5);
            } else {
                System.out.println(grade);
            }
        }
    }
}
