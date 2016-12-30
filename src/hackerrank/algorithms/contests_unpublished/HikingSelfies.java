package hackerrank.algorithms.contests_unpublished;

import java.util.Scanner;

/**
 * Created by Aleksandr on 30/12/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/contests/walmart-codesprint-algo/challenges/emma-and-her-camera
 */
public class HikingSelfies {
    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);

        final int n = in.nextInt();
        final int x = in.nextInt();

        final int[] factorials = factorials(10);

        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += factorials[n] / (factorials[i] * factorials[n - i]);
        }

        System.out.println(Math.abs(x - sum));
    }

    private static int[] factorials(int n) {
        final int[] nums = new int[n + 1];
        nums[0] = 1;
        nums[1] = 1;

        int fact = 1;
        for (int i = 2; i <= n; i++) {
            fact *= i;
            nums[i] = fact;
        }

        return nums;
    }
}
