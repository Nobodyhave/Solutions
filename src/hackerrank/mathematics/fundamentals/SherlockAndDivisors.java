package hackerrank.mathematics.fundamentals;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by Aleksandr on 05/12/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/sherlock-and-divisors
 */
public class SherlockAndDivisors {
    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);

        final int T = in.nextInt();
        for (int t = 0; t < T; t++) {
            int N = in.nextInt();

            int count = 0;
            List<Integer> divisors = trialDivisors(N);

            for (Integer div : divisors) {
                if (div % 2 == 0) {
                    count++;
                }
            }

            System.out.println(count);
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
