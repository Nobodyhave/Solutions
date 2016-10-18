package hackerrank.algorithms.greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Created by Aleksandr on 18/10/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/two-arrays
 */
public class PermutingTwoArrays {
    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);

        final int Q = in.nextInt();
        for (int q = 0; q < Q; q++) {
            final int N = in.nextInt();
            final int k = in.nextInt();

            final Integer[] A = new Integer[N];
            for (int i = 0; i < N; i++) {
                A[i] = in.nextInt();
            }

            final Integer[] B = new Integer[N];
            for (int i = 0; i < N; i++) {
                B[i] = in.nextInt();
            }

            Arrays.sort(A);
            Arrays.sort(B, new ReverseComparator());

            boolean permutable = true;
            for (int i = 0; i < N; i++) {
                if (A[i] + B[i] < k) {
                    permutable = false;
                    break;
                }
            }

            if (permutable) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    private static class ReverseComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer i1, Integer i2) {
            return i2.compareTo(i1);
        }
    }
}
