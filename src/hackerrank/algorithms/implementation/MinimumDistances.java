package hackerrank.algorithms.implementation;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Aleksandr on 02/01/2017.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/minimum-distances
 */
public class MinimumDistances {
    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);
        final int n = in.nextInt();
        final int A[] = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = in.nextInt();
        }

        final int[] start = new int[100000 + 1];
        final int[] dist = new int[100000 + 1];

        Arrays.fill(start, -1);
        Arrays.fill(dist, Integer.MAX_VALUE);

        for (int i = 0; i < n; i++) {
            if (start[A[i]] != -1) {
                int curDist = Math.abs(start[A[i]] - i);
                if (curDist < dist[A[i]]) {
                    dist[A[i]] = curDist;
                }
            }
            start[A[i]] = i;
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < dist.length; i++) {
            if (dist[i] < min) {
                min = dist[i];
            }
        }

        if (min != Integer.MAX_VALUE) {
            System.out.println(min);
        } else {
            System.out.println(-1);
        }
    }
}
