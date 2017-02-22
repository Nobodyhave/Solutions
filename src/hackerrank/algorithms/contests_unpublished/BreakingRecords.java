package hackerrank.algorithms.contests_unpublished;

import java.util.Scanner;

/**
 * Created by Aleksandr on 22/02/2017.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/contests/university-codesprint-2/challenges/breaking-best-and-worst-records
 */
public class BreakingRecords {
    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);
        final int n = in.nextInt();
        final int[] score = new int[n];
        for (int i = 0; i < n; i++) {
            score[i] = in.nextInt();
        }

        int min = score[0];
        int max = score[0];
        int minBreaks = 0;
        int maxBreaks = 0;

        for (int i = 1; i < n; i++) {
            if (score[i] > max) {
                max = score[i];
                maxBreaks++;
            }
            if (score[i] < min) {
                min = score[i];
                minBreaks++;
            }
        }

        System.out.println(maxBreaks + " " + minBreaks);
    }
}
