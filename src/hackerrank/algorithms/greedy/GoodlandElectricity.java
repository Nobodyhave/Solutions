package hackerrank.algorithms.greedy;

/**
 * Created by Aleksandr on 02/11/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/pylons
 */

import java.io.FileNotFoundException;
import java.util.Scanner;

public class GoodlandElectricity {

    public static void main(String[] args) throws FileNotFoundException {
        final Scanner in = new Scanner(System.in);

        final int N = in.nextInt();
        final int k = in.nextInt();
        final int[] towers = new int[N];
        for (int i = 0; i < N; i++) {
            towers[i] = in.nextInt();
        }

        int start = k - 1;
        while (start >= 0 && towers[start] != 1) {
            start--;
        }

        if (start == -1) {
            System.out.println(-1);
            return;
        }

        int count = 1;
        while (start < (N - k - 1)) {
            int newStart = start + 2 * (k - 1) + 1;
            if (newStart >= N) {
                newStart = N - 1;
            }
            if (towers[newStart] != 1) {
                while (newStart > start && towers[newStart] != 1) {
                    newStart--;
                }
                if (start == newStart) {
                    System.out.println(-1);
                    return;
                } else {
                    start = newStart;
                    count++;
                }
            } else {
                start = newStart;
                count++;
            }
        }

        System.out.println(count);
    }
}
