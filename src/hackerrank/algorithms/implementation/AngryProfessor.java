package hackerrank.algorithms.implementation;

/**
 * Created by Aleksandr on 25/11/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/angry-professor
 */

import java.util.Scanner;

public class AngryProfessor {

    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();
        for (int t = 0; t < T; t++) {
            final int students = in.nextInt();
            final int threshold = in.nextInt();
            int count = 0;
            for (int i = 0; i < students; i++) {
                if (in.nextInt() <= 0) {
                    count++;
                }
            }
            if (count < threshold) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
