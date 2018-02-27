package codechef;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by Aleksandr on 05/01/2018.
 * Project Solutions
 * <p>
 * https://www.codechef.com/JAN18/problems/KCON
 */
public class KConcatenation {
    private static void generateTest() throws IOException {
        final FileWriter fw = new FileWriter("C:\\Projects\\Solutions\\src\\tests.txt");
        final Random rand = new Random();
        final int T = 100;
        fw.append(String.valueOf(T));
        fw.append("\n");
        for (int i = 0; i < T; i++) {
            final int N = rand.nextInt(100000) + 1;
            final int K = rand.nextInt(100000) + 3;
            fw.append(String.valueOf(N));
            fw.append(" ");
            fw.append(String.valueOf(K));
            fw.append("\n");

            for (int j = 0; j < N; j++) {
                int num = rand.nextInt(1000000);
                int sign = rand.nextInt(2);
                fw.append(String.valueOf(num * (sign == 0 ? -1 : 1)));
                fw.append(" ");
            }
            fw.append("\n");
        }

        fw.flush();
        fw.close();
    }

    public static void main(String[] args) throws Exception {
        generateTest();
        //final Scanner in = new Scanner(System.in);
        final Scanner in = new Scanner(new FileInputStream("C:\\Projects\\Solutions\\src\\tests.txt"));

        final int T = in.nextInt();
        for (int t = 0; t < T; t++) {
            final int N = in.nextInt();
            final int K = in.nextInt();

            final int[] A = new int[N];
            for (int i = 0; i < N; i++) {
                A[i] = in.nextInt();
            }

            //brute(A, N, K);
            clever(A, N, K);
            System.out.println("-------------");
        }
    }

    private static void brute(int[] A, int N, int K) {
        final int[] fullA = new int[N * K];
        for (int i = 0; i < K; i++) {
            System.arraycopy(A, 0, fullA, i * N, N);
        }

        System.out.println(maxSubArraySum(fullA));
    }

    private static void clever(int[] A, int N, int K) {
        long sum = 0;
        for (int i = 0; i < N; i++) {
            sum += A[i];
        }

        if (K == 1) {
            System.out.println(maxSubArraySum(A));
        } else
        if (sum >= 0) {
            long leftSum = 0, leftMax = 0;
            for (int i = N - 1; i >= 0; i--) {
                leftSum += A[i];
                leftMax = Math.max(leftMax, leftSum);
            }
            long rightSum = 0, rightMax = 0;
            for (int i = 0; i < N; i++) {
                rightSum += A[i];
                rightMax = Math.max(rightMax, rightSum);
            }

            System.out.println((K - 2) * sum + leftMax + rightMax);
        } else {
            final int[] doubleA = new int[N * 2];
            System.arraycopy(A, 0, doubleA, 0, N);
            System.arraycopy(A, 0, doubleA, N, N);

            System.out.println(maxSubArraySum(doubleA));
        }
    }

    private static long maxSubArraySum(int nums[]) {
        long maxSoFar = Integer.MIN_VALUE, maxEndingHere = 0;

        for (int num : nums) {
            maxEndingHere = maxEndingHere + num;
            if (maxSoFar < maxEndingHere) {
                maxSoFar = maxEndingHere;
            }
            if (maxEndingHere < 0) {
                maxEndingHere = 0;
            }
        }
        return maxSoFar;
    }
}
