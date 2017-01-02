package hackerrank.algorithms.implementation;

import java.util.Scanner;

/**
 * Created by Aleksandr on 02/01/2017.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/beautiful-triplets
 */
public class BeautifulTriplets {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        final int N = in.nextInt();
        final int d = in.nextInt();

        if (N < 3) {
            System.out.println(0);
            return;
        }

        final int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = in.nextInt();
        }
        int start = 0, mid = 1, end = 2, count = 0;
        while (true) {
            if (nums[mid] - nums[start] < d) {
                mid++;
                if (mid >= end) {
                    end++;
                }
            } else if (nums[mid] - nums[start] > d) {
                start++;
                if (start >= mid) {
                    mid++;
                }
                if (mid >= end) {
                    end++;
                }
            } else {
                if (nums[end] - nums[mid] < d) {
                    end++;
                } else if (nums[end] - nums[mid] > d) {
                    mid++;
                } else {
                    count++;
                    start++;
                    mid++;
                    end++;
                }
            }

            if (start >= N - 2 || mid >= N - 1 || end >= N) {
                break;
            }
        }
        System.out.println(count);
    }
}
