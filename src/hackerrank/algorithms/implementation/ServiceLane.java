package hackerrank.algorithms.implementation;

import java.util.Scanner;

/**
 * Created by Aleksandr on 02/01/2017.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/service-lane
 */
public class ServiceLane {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        final int N = scanner.nextInt();
        final int T = scanner.nextInt();
        final int[] road = new int[N];
        for (int n = 0; n < N; n++) {
            road[n] = scanner.nextInt();
        }


        for (int t = 0; t < T; t++) {
            final int i = scanner.nextInt();
            final int j = scanner.nextInt();

            int min = Integer.MAX_VALUE;
            for (int k = i; k <= j; k++) {
                if (road[k] < min) {
                    min = road[k];
                }
                if (min == 1) {
                    break;
                }
            }
            System.out.println(min);
        }
    }
}
