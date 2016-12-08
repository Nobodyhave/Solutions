package hackerrank.mathematics.number_theory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Aleksandr on 08/12/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/identify-smith-numbers
 */
public class IdentifySmithNumbers {
    public static void main(String[] args) throws FileNotFoundException {
        //final Scanner in = new Scanner(System.in);
        final Scanner in = new Scanner(new FileInputStream("C:\\Projects\\Solutions\\src\\tests.txt"));

        final int N = in.nextInt();

        if (N < 4) {
            System.out.println(0);
            return;
        }

        final int sqrt = (int) Math.sqrt(N) + 2;
        final List<Integer> primes = sieveOfEratosthenes(sqrt);
        final List<Integer> primeDivisors = new ArrayList<>();
        trialDivisors(primeDivisors, N, primes);

        int sum = sumOfDigits(N);
        for (Integer div : primeDivisors) {
            sum -= sumOfDigits(div);
        }

        if (sum == 0) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }

    private static int sumOfDigits(int N) {
        final String s = String.valueOf(N);
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            sum += s.charAt(i) - '0';
        }

        return sum;
    }

    private static List<Integer> sieveOfEratosthenes(int N) {
        final BitSet prime = new BitSet(Math.max(3, N + 1));
        final List<Integer> primes = new ArrayList<>();
        prime.set(0, false);
        prime.set(1, false);
        prime.set(2, N + 1, true);
        final int m = (int) Math.sqrt(N) + 1;

        for (int i = 2; i <= m; i++) {
            if (prime.get(i)) {
                primes.add(i);
                for (int k = i * i; k <= N; k += i) {
                    prime.set(k, false);
                }
            }
        }

        for (int i = m + 1; i <= N; i++) {
            if (prime.get(i)) {
                primes.add(i);
            }
        }

        return primes;
    }


    private static void trialDivisors(List<Integer> primeDivisors, int N, List<Integer> primes) {
        if (N == 1) {
            return;
        }

        for (Integer prime : primes) {
            if (N % prime == 0) {
                primeDivisors.add(prime);
                trialDivisors(primeDivisors, N / prime, primes);
                return;
            }
        }

        primeDivisors.add(N);
    }
}
