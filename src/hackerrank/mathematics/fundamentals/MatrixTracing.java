package hackerrank.mathematics.fundamentals;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Aleksandr on 06/12/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/matrix-tracing
 */
public class MatrixTracing {
    public static void main(String[] args) throws FileNotFoundException {
        //final Scanner in = new Scanner(System.in);
        final Scanner in = new Scanner(new FileInputStream("C:\\Projects\\Solutions\\src\\tests.txt"));

        final List<Integer> primes = sieveOfEratosthenes(2000000);

        final int T = in.nextInt();
        for (int t = 0; t < T; t++) {
            final int m = in.nextInt() - 1;
            final int n = in.nextInt() - 1;

            System.out.println(binomial(m + n, Math.min(m, n), primes));
        }

    }

    private static List<Integer> sieveOfEratosthenes(int n) {
        final BitSet prime = new BitSet(Math.max(3, n + 1));
        final List<Integer> primes = new ArrayList<>();
        prime.set(0, false);
        prime.set(1, false);
        prime.set(2, n + 1, true);
        final int m = (int) Math.sqrt(n) + 1;

        for (int i = 2; i <= m; i++) {
            if (prime.get(i)) {
                primes.add(i);
                for (int k = i * i; k <= n; k += i) {
                    prime.set(k, false);
                }
            }
        }

        for (int i = m + 1; i <= n; i++) {
            if (prime.get(i)) {
                primes.add(i);
            }
        }

        return primes;
    }

    private static long binomial(int N, int K, List<Integer> primes) {
        int curPrime;
        long result = 1;
        int i = 0;
        while (primes.get(i) <= N) {
            curPrime = primes.get(i);
            final int powersOfPrime = powerOfPrimeInFactorial(N, curPrime)
                    - powerOfPrimeInFactorial(K, curPrime)
                    - powerOfPrimeInFactorial(N - K, curPrime);
            if (powersOfPrime > 0) {
                result = (result * (((long) Math.pow(curPrime, powersOfPrime)) % 1000000007)) % 1000000007;
            }
            i++;
        }

        return result;
    }

    private static int powerOfPrimeInFactorial(int N, int prime) {
        int result = 0;
        for (long p = prime; p <= N; p *= prime) {
            result = result + (int) (N / p);
        }

        return result;
    }
}
