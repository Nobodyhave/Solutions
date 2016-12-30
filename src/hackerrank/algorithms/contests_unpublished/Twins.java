package hackerrank.algorithms.contests_unpublished;

import java.io.FileNotFoundException;
import java.util.*;

/**
 * Created by Aleksandr on 30/11/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/contests/w26/challenges/twins
 */
public class Twins {
    public static void main(String[] args) throws FileNotFoundException {
        final Scanner in = new Scanner(System.in);
        //Scanner in = new Scanner(new FileInputStream("C:\\Projects\\Solutions\\src\\tests.txt"));

        final int N = in.nextInt();
        final int M = in.nextInt();

        final List<Integer> primes = segmentSieve(N, M);

        int count = 0;
        for (int i = 0; i < primes.size(); i++) {
            final int primeI = primes.get(i);
            for (int j = i + 1; j < primes.size(); j++) {
                final int primeJ = primes.get(j);
                if (primeJ - primeI == 2) {
                    count++;
                } else if (primeJ - primeI > 2) {
                    break;
                }
            }
        }

        System.out.println(count);
    }

    private static List<Integer> segmentSieve(int N, int M) {
        if (N >= M) {
            return new ArrayList<>();
        }

        final List<Integer> lessPrimes = sieveOfEratosthenes((int) Math.sqrt(M) + 1);

        final boolean[] primes = new boolean[M - N + 1];
        Arrays.fill(primes, true);

        if (N == 0) {
            primes[0] = false;
            if (M > 0) {
                primes[1] = false;
            }
        } else if (N == 1) {
            primes[0] = false;
        }

        for (Integer prime : lessPrimes) {
            final int start = (int) Math.ceil((double) N / prime) * prime;
            for (int i = start - N; i <= M - N; i += prime) {
                if (i != prime - N) {
                    primes[i] = false;
                }
            }
        }

        final List<Integer> primesList = new ArrayList<>();
        for (int i = 0; i <= M - N; i++) {
            if (primes[i]) {
                primesList.add(i + N);
            }
        }

        return primesList;
    }

    private static List<Integer> sieveOfEratosthenes(int n) {
        final BitSet prime = new BitSet(Math.max(3, n + 1));
        final List<Integer> primes = new ArrayList<>();
        prime.set(0, false);
        prime.set(1, false);
        prime.set(2, n + 1, true);

        for (int i = 2; i <= n; i++) {
            if (prime.get(i)) {
                primes.add(i);
                for (int k = i * i; k <= n; k += i) {
                    prime.set(k, false);
                }
            }
        }
        return primes;
    }
}
