package hackerrank.algorithms.greedy;

/**
 * Created by Aleksandr on 10/11/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/sherlock-and-minimax
 */

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SherlockAndMinimax {

    public static void main(String[] args) throws FileNotFoundException {
        //final Scanner in = new Scanner(System.in);
        final Scanner in = new Scanner(new FileInputStream("C:\\Projects\\Solutions\\src\\tests.txt"));

        final int n = in.nextInt();
        final int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }

        final int P = in.nextInt();
        final int Q = in.nextInt();

        Arrays.sort(a);

        System.out.println(Arrays.toString(a));
        System.out.println("P = " + P + " Q = " + Q);

        if (P < a[0] && Q < a[0]) {
            System.out.println(P);
        } else if (P < a[0] && Q <= a[n - 1]) {
            int[] minDiff = getMinDiffNum(a, a[0], Q);
            if (minDiff[1] <= a[0] - P) {
                System.out.println(P);
            } else {
                System.out.println(minDiff[0]);
            }

        } else if (P < a[0] && Q > a[n - 1]) {
            int[] minDiff = getMinDiffNum(a, a[0], a[n - 1]);
            if (minDiff[1] > a[0] - P && minDiff[1] >= Q - a[n - 1]) {
                System.out.println(minDiff[0]);
            } else if (a[0] - P >= Q - a[n - 1]) {
                System.out.println(P);
            } else {
                System.out.println(Q);
            }
        } else if (P >= a[0] && Q <= a[n - 1]) {
            int[] minDiff = getMinDiffNum(a, P, Q);
            System.out.println(minDiff[0]);
        } else if (P >= a[0] && Q > a[n - 1]) {
            int[] minDiff = getMinDiffNum(a, P, a[n - 1]);
            if (minDiff[1] >= Q - a[n - 1]) {
                System.out.println(minDiff[0]);
            } else {
                System.out.println(Q);
            }
        } else {
            System.out.println(Q);
        }
    }

    private static int[] getMinDiffNum(int[] a, int left, int right) {
        int maxDiff = Integer.MIN_VALUE;
        int maxDiffNum = Integer.MAX_VALUE;

        List<Integer> candidates = new ArrayList<>();
        candidates.add(left);
        for (int i = 1; i < a.length; i++) {
            int mid = (a[i - 1] + a[i]) / 2;
            if (mid - 1 >= left && mid - 1 <= right) {
                candidates.add(mid - 1);
            }
            if (mid >= left && mid <= right) {
                candidates.add(mid);
            }
            if (mid + 1 >= left && mid + 1 <= right) {
                candidates.add(mid + 1);
            }
        }
        candidates.add(right);

        for (Integer candidate : candidates) {
            int localDiff = getMinDiff(a, candidate);
            if (localDiff > maxDiff) {
                maxDiff = localDiff;
                maxDiffNum = candidate;
            }
        }

        return new int[]{maxDiffNum, maxDiff};
    }

    private static int getMinDiff(int[] a, int num) {
        int ind = Arrays.binarySearch(a, num);

        if (ind >= 0) {
            return 0;
        } else if (ind == -1) {
            return a[0] - num;
        } else if (ind == -(a.length + 1)) {
            return num - a[a.length - 1];
        } else {
            int indL = -(ind + 1) - 1;
            int indR = -(ind + 1);
            return Math.min(num - a[indL], a[indR] - num);
        }
    }
}
