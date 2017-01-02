package hackerrank.algorithms.implementation;

import java.util.Scanner;

/**
 * Created by Aleksandr on 02/01/2017.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/fair-rations
 */
public class FairRations {
    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);
        final int N = in.nextInt();
        final int B[] = new int[N];
        for (int i = 0; i < N; i++) {
            B[i] = in.nextInt();
        }

        int count = 0;
        for (int i = 0; i < N - 1; i++) {
            if (B[i] % 2 != 0) {
                B[i]++;
                B[i + 1]++;
                count += 2;
            }
        }

        if (B[N - 1] % 2 != 0) {
            System.out.println("NO");
        } else {
            System.out.println(count);
        }
    }
}
