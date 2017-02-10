package hackerrank.algorithms.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Aleksandr on 10/02/2017.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/closest-numbers
 */
public class ClosestNumbers {
    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);

        final int N = in.nextInt();

        final int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = in.nextInt();
        }

        Arrays.sort(nums);

        final List<Integer> p1 = new ArrayList<>();
        final List<Integer> p2 = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < N; i++) {
            if (nums[i] - nums[i - 1] < min) {
                min = nums[i] - nums[i - 1];
            }
        }

        //System.out.println("Min: " + min);
        for (int i = 1; i < N; i++) {
            if (nums[i] - nums[i - 1] == min) {
                p1.add(nums[i - 1]);
                p2.add(nums[i]);
            }
        }

        for (int i = 0; i < p1.size(); i++) {
            System.out.print(p1.get(i) + " " + p2.get(i) + " ");
        }
    }
}
