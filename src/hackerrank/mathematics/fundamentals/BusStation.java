package hackerrank.mathematics.fundamentals;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by Aleksandr on 08/12/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/bus-station
 */
public class BusStation {
    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);

        final int N = in.nextInt();
        final int[] a = new int[N];
        int sum = 0;
        for (int i = 0; i < N; i++) {
            a[i] = in.nextInt();
            sum += a[i];
        }

        final List<Integer> divisors = trialDivisors(sum);
        outer:
        for (Integer div : divisors) {
            int busSum = 0;
            for (int i = 0; i < N; i++) {
                busSum += a[i];
                if (busSum == div) {
                    busSum = 0;
                } else if (busSum > div) {
                    continue outer;
                }
            }
            System.out.print(div + " ");
        }
    }

    private static List<Integer> trialDivisors(int N) {
        final int M = (int) Math.sqrt(N);
        final List<Integer> small = new ArrayList<>();
        final Stack<Integer> big = new Stack<>();

        for (int i = 1; i < M; i++) {
            if (N % i == 0) {
                small.add(i);
                big.push(N / i);
            }
        }

        if (N % M == 0) {
            small.add(M);
            if (N / M != M) {
                big.push(N / M);
            }
        }

        while (!big.isEmpty()) {
            small.add(big.pop());
        }

        return small;
    }
}
