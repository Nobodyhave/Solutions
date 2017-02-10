package hackerrank.algorithms.sorting;

import java.util.Scanner;

/**
 * Created by Aleksandr on 10/02/2017.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/tutorial-intro
 */
public class IntroToTutorialChallenges {
    public static void main(String[] args) {
        final Scanner s = new Scanner(System.in);
        final int val = s.nextInt();
        final int size = s.nextInt();

        for (int i = 0; i < size; i++) {
            final int num = s.nextInt();
            if (val == num) {
                System.out.println(i);
                break;
            }
        }
    }
}
