package hackerrank.algorithms.implementation;

/**
 * Created by Aleksandr on 18/10/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/strange-advertising
 */

import java.util.Scanner;

public class ViralAdvertising {

    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);

        int n = in.nextInt();

        int people = 2;
        int likes = 2;
        for (int i = 1; i < n; i++) {
            people = people * 3 / 2;
            likes += people;
        }

        System.out.println(likes);
    }
}
