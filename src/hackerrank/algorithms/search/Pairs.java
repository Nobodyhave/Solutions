package hackerrank.algorithms.search;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Aleksandr on 10/02/2017.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/pairs
 */
public class Pairs {
    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);

        final int N = in.nextInt();
        final int K = in.nextInt();

        final int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = in.nextInt();
        }

        Arrays.sort(arr);

        int start = 0, end = 1, count = 0;
        while (start < N) {
            //System.out.println("Start: " + start + " End: " + end + " Diff: " + (arr[end] - arr[start]));
            if (arr[end] - arr[start] < K) {
                if (end == N - 1) {
                    start++;
                } else {
                    end++;
                }
            } else if (arr[end] - arr[start] > K) {
                if (start == end) {
                    if (end == N - 1) {
                        break;
                    } else {
                        end++;
                    }
                } else {
                    start++;
                }
            } else {
                count++;
                if (end != N - 1) {
                    end++;
                } else {
                    start++;
                }
            }
        }

        System.out.println(count);
    }
}
