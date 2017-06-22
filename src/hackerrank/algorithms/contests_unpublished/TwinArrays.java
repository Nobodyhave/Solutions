package hackerrank.algorithms.contests_unpublished;

import java.util.Scanner;

/**
 * Created by Aleksandr on 22/06/2017.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/contests/w33/challenges/twin-arrays
 */
public class TwinArrays {
    private static int twinArrays(int[] a1, int[] a2) {
        int minVal1 = Integer.MAX_VALUE, minVal2 = Integer.MAX_VALUE, minIndex1 = -1, minIndex2 = -1;
        for (int i = 0; i < a1.length; i++) {
            if (a1[i] < minVal1) {
                minVal1 = a1[i];
                minIndex1 = i;
            }
        }
        for (int i = 0; i < a2.length; i++) {
            if (a2[i] < minVal2) {
                minVal2 = a2[i];
                minIndex2 = i;
            }
        }

        if (minIndex1 != minIndex2) {
            return minVal1 + minVal2;
        } else {
            int minVal3 = Integer.MAX_VALUE, minVal4 = Integer.MAX_VALUE;
            for (int i = 0; i < a1.length; i++) {
                if (a1[i] <= minVal3 && minIndex1 != i) {
                    minVal3 = a1[i];
                }
            }
            for (int i = 0; i < a2.length; i++) {
                if (a2[i] <= minVal4 && minIndex2 != i) {
                    minVal4 = a2[i];

                }
            }

            return Math.min(minVal1 + minVal4, minVal2 + minVal3);
        }

    }

    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);
        final int n = in.nextInt();
        final int[] a1 = new int[n];
        for (int i = 0; i < n; i++) {
            a1[i] = in.nextInt();
        }
        int[] a2 = new int[n];
        for (int i = 0; i < n; i++) {
            a2[i] = in.nextInt();
        }
        System.out.println(twinArrays(a1, a2));
    }
}
