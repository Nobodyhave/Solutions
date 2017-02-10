package hackerrank.algorithms.contests_unpublished;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Aleksandr on 10/02/2017.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/contests/hourrank-17/challenges/organizing-containers-of-balls
 */
public class OrganizingContainersOfBalls {
    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);
        final int q = in.nextInt();
        outer:
        for (int a0 = 0; a0 < q; a0++) {
            final int n = in.nextInt();
            final int[][] M = new int[n][n];
            final int[] countsBalls = new int[n];
            final int[] countsContainers = new int[n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    M[i][j] = in.nextInt();
                    countsContainers[i] += M[i][j];
                    countsBalls[j] += M[i][j];
                }
            }

            Arrays.sort(countsBalls);
            Arrays.sort(countsContainers);

            for (int i = 0; i < n; i++) {
                if (countsBalls[i] != countsContainers[i]) {
                    System.out.println("Impossible");
                    continue outer;
                }
            }
            System.out.println("Possible");

        }
    }
}
