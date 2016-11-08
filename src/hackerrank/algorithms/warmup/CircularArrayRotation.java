package hackerrank.algorithms.warmup;

/**
 * Created by Aleksandr on 08/11/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/circular-array-rotation
 */

import java.util.Scanner;

public class CircularArrayRotation {

    public static void main(String[] args) {
        final Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        int K = s.nextInt();
        int Q = s.nextInt();

        final int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            final int num = s.nextInt();
            final int index = (i + K) % N;
            nums[index] = num;
        }

        for (int i = 0; i < Q; i++) {
            final int question = s.nextInt();
            System.out.println(nums[question]);
        }
        s.close();
    }
}
