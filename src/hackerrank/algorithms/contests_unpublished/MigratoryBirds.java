package hackerrank.algorithms.contests_unpublished;

import java.util.Scanner;

/**
 * Created by Aleksandr on 15/02/2017.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/contests/rookierank-2/challenges/migratory-birds
 */
public class MigratoryBirds {
    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);
        final int n = in.nextInt();
        final int[] types = new int[6];
        for (int types_i = 0; types_i < n; types_i++) {
            types[in.nextInt()]++;
        }

        int max = Integer.MIN_VALUE;
        int maxId = 1;
        for (int i = 1; i < 6; i++) {
            if (types[i] > max) {
                max = types[i];
                maxId = i;
            }
        }

        System.out.println(maxId);
    }
}
