package hackerrank.java.data_structures;

import java.util.Scanner;

/**
 * Created by Aleksandr on 19/01/2017.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/java-negative-subarray
 */
public class JavaSubarray {
    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);

        final int N = in.nextInt();
        final int[] a = new int[N];
        for (int i = 0; i < N; i++) {
            a[i] = in.nextInt();
        }

        int count = 0;
        for (int length = 1; length <= N; length++) {
            for (int start = 0; start < N - length + 1; start++) {
                int sum = 0;
                for (int i = start; i < start + length; i++) {
                    sum += a[i];
                }
                if (sum < 0) {
                    count++;
                }
            }
        }

        System.out.println(count);
    }
}
