package hackerrank.algorithms.contests_unpublished;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Aleksandr on 03/05/2017.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/contests/hourrank-20/challenges/p-string
 */
public class CountingPerfectSubsequences {
    private static final long MOD = 1000000007;
    private static final List<Integer> PRIMES = sieveOfEratosthenes(1000000);

    private static long countSubs(String s) {
        final int[] count = new int[4];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }

        int minAB = Math.min(count[0], count[1]);
        int maxAB = Math.max(count[0], count[1]);
        int minCD = Math.min(count[2], count[3]);
        int maxCD = Math.max(count[2], count[3]);

        return (binomial(minAB + maxAB, maxAB, PRIMES)
                .multiply(binomial(minCD + maxCD, maxCD, PRIMES)))
                .mod(BigInteger.valueOf(MOD)).longValue() - 1;
    }

    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);
        // Return the number of non-empty perfect subsequences mod 1000000007
        final int Q = in.nextInt();
        for (int q = 0; q < Q; q++) {
            final String s = in.next();
            final long result = countSubs(s);
            System.out.println(result);
        }
    }

    private static BigInteger binomial(int N, int K, List<Integer> primes) {
        int i = 0;
        int curPrime;
        BigInteger result = BigInteger.ONE;
        while (i < primes.size() && primes.get(i) <= N) {
            curPrime = primes.get(i);
            final BigInteger powersOfPrime = (powerOfPrimeInFactorial(N, curPrime)
                    .subtract(powerOfPrimeInFactorial(K, curPrime)))
                    .subtract(powerOfPrimeInFactorial(N - K, curPrime));
            if (powersOfPrime.compareTo(BigInteger.ZERO) > 0) {
                result = result.multiply(BigInteger.valueOf(curPrime).pow(powersOfPrime.intValue()));
            }
            i++;
        }

        return result;
    }

    private static BigInteger powerOfPrimeInFactorial(int N, int prime) {
        int result = 0;
        for (long p = prime; p <= N; p *= prime) {
            result = result + (int) (N / p);
        }

        return BigInteger.valueOf(result);
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
}

