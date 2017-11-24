package codechef;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Aleksandr on 03/11/2017.
 * Project Solutions
 * <p>
 * https://www.codechef.com/NOV17/problems/BINOMSUM
 */
public class DaySchedule {
    private static final List<Integer> PRIMES = sieveOfEratosthenes(1000000);

    public static void main(String[] args) throws FileNotFoundException {
        //final Scanner in = new Scanner(System.in);
        final Scanner in = new Scanner(new FileInputStream("C:\\Projects\\Solutions\\src\\tests.txt"));

        final int K = in.nextInt();
        final int A = in.nextInt();
        final int P = in.nextInt();
        final int Q = in.nextInt();

        for (int q = 0; q < Q; q++) {
            final int L = in.nextInt();
            int D = in.nextInt();
            final int T = in.nextInt();


            if (K == 2) {
                System.out.println(calculateCase2(K, A, P, L, D, T));
            } else {
                System.out.println(calculate(K, A, P, L, D, T));
            }
        }
    }

    private static long calculateCase2(int K, int A, int P, int L, int D, int T) {
        long small = binomial(D, L + 1, P, PRIMES);
        long big = binomial(D + T + 1, L + 1, P, PRIMES);

        return ((big - small) * modPowByExponent(A, T, P)) % P;
    }

    private static long calculate(int K, int A, int P, int L, int D, int T) {
        long result = 0;
        long nCk = binomial(D, L, P, PRIMES);
        for (int t = 0; t < T; t++) {
            final int allHours = (K - 1) / 2;
            final int activityHours = (K - 1 - allHours);
            result += (((((((nCk * (A + D)) % P) * allHours) % P) * A) % P) * activityHours) % P;
            result %= P;

            nCk = nextBinomial(nCk, D, L) % P;
            D++;
        }

        return result;
    }

    private static long modPowByExponent(long x, long exp, long mod) {
        if (mod == 0) {
            return 0;
        }

        long result = 1;
        long base = x % mod;

        while (exp > 0) {
            if (exp % 2 == 1) {
                result = (result * base) % mod;
            }
            exp = exp >> 1;
            base = (base * base) % mod;
        }

        return result;
    }

    private static long nextBinomial(long nCk, long n, long k) {
        return nCk + (nCk * k) / (n + 1 - k);
    }

    private static int arrangement(int N, int K, int mod, List<Integer> primes) {
        int i = 0;
        int curPrime;
        int result = 1;
        while (i < primes.size() && primes.get(i) <= N) {
            curPrime = primes.get(i);
            final int powersOfPrime = powerOfPrimeInFactorial(N, curPrime)
                    //- powerOfPrimeInFactorial(K, curPrime)
                    - powerOfPrimeInFactorial(N - K, curPrime);

            if (powersOfPrime > 0) {
                result = (int) (((long) result * (long) Math.pow(curPrime, powersOfPrime)) % mod);
            }
            i++;
        }

        return result;
    }

    private static int binomial(int N, int K, int mod, List<Integer> primes) {
        int i = 0;
        int curPrime;
        int result = 1;
        while (i < primes.size() && primes.get(i) <= N) {
            curPrime = primes.get(i);
            final int powersOfPrime = powerOfPrimeInFactorial(N, curPrime)
                    - powerOfPrimeInFactorial(K, curPrime)
                    - powerOfPrimeInFactorial(N - K, curPrime);

            if (powersOfPrime > 0) {
                result = (int) (((long) result * (long) Math.pow(curPrime, powersOfPrime)) % mod);
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

    public static List<Integer> sieveOfEratosthenes(int N) {
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
