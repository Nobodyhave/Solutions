package codechef;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by Aleksandr on 01/12/2017.
 * Project Solutions
 * <p>
 * https://www.codechef.com/DEC17/problems/CHEFHAM
 */
public class ChefAndHammindDistanceOfArrays {
    public static void main(String[] args) throws IOException {
        //final Scanner in = new Scanner(System.in);
        final Scanner in = new Scanner(new FileInputStream("C:\\Projects\\Solutions\\src\\tests.txt"));

        final int T = in.nextInt();
        for (int t = 0; t < T; t++) {
            final int N = in.nextInt();
            final int[] A = new int[N];
            final int[] counts = new int[100001];
            for (int i = 0; i < N; i++) {
                A[i] = in.nextInt();
                counts[A[i]]++;
            }

            if (N == 1) {
                System.out.println(0);
                System.out.println(A[0]);
                continue;
            } else if (N == 2) {
                System.out.println(A[0] == A[1] ? 0 : 2);
                System.out.println(A[1] + " " + A[0]);
                continue;
            } else if (N == 3) {
                if (A[0] == A[1] || A[0] == A[2] || A[1] == A[2]) {
                    System.out.println(2);
                } else {
                    System.out.println(3);
                }
                System.out.println(A[1] + " " + A[2] + " " + A[0]);
                continue;
            }

            final StringBuilder sb = new StringBuilder();

            outer:
            for (int shift = 2; shift <= N; shift++) {
                final int[] B = new int[N];
                System.arraycopy(A, 0, B, 0, N);
                rotateArrayLeft(B, N / shift);

                int start = 0, end = N - 1;
                while (start < end) {
                    while (start < end && A[start] != B[start]) {
                        start++;
                    }
                    while (start < end && A[end] != B[end]) {
                        start++;
                    }
                    if (start >= end) {
                        break;
                    }
                    swap(B, start, end);
                    if (A[start] == B[start] || A[end] == B[end]) {
                        continue outer;
                    }
                    start++;
                    end++;
                }

                for (int b : B) {
                    sb.append(b).append(" ");
                }
                break;
            }

            System.out.println(N);
            System.out.println(sb.toString());
        }
    }

    private static void rotateArrayLeft(int[] a, int steps) {
        reverseArray(a, 0, steps - 1);
        reverseArray(a, steps, a.length - 1);
        reverseArray(a, 0, a.length - 1);
    }

    private static void reverseArray(int[] a, int left, int right) {
        while (left < right) {
            swap(a, left, right);
            left++;
            right--;
        }
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
