package hackerrank.algorithms.implementation;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Aleksandr on 02/01/2017.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/cut-the-sticks
 */
public class CutTheSticks {
    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);
        final int N = in.nextInt();
        final int[] nums = new int[N];

        for (int i = 0; i < N; i++) {
            nums[i] = in.nextInt();
        }

        Arrays.sort(nums);
        int start = 0;
        while (nums[nums.length - 1] != 0) {
            int cut = 0;
            boolean isFound = false;
            for (int i = start; i < N; i++) {
                if (i == start) {
                    cut = nums[start];
                    System.out.println(N - start);
                }
                nums[i] -= cut;
                if (nums[i] != 0 && !isFound) {
                    start = i;
                    isFound = true;
                }
            }
        }
    }
}
