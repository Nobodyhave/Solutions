package hackerrank.mathematics.fundamentals;

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
 * https://www.hackerrank.com/challenges/jim-and-the-jokes
 */
public class JimAndJokes {
    public static void main(String[] args) throws FileNotFoundException {
        //final Scanner in = new Scanner(System.in);
        final Scanner in = new Scanner(new FileInputStream("C:\\Projects\\Solutions\\src\\tests.txt"));

        final int N = in.nextInt();
        int[] dates = new int[Integer.parseInt("31", 12)+1];
        for (int i = 0; i < N; i++) {
            try {
                int radix = in.nextInt();
                String value = in.next();
                if (radix != 10) {
                    dates[Integer.parseInt(value, radix)]++;
                } else {
                    dates[Integer.parseInt(value)]++;
                }
            } catch (NumberFormatException e) {
                // Do nothing
            }
        }

        List<Integer> primes = sieveOfEratosthenes(100000);

        long count = 0;
        for (int date : dates) {
            if (date > 1) {
                count += binomial(date, 2, primes);
            }
        }

        System.out.println(count);
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

    private static long binomial(int N, int K, List<Integer> primes) {
        int i = 0;
        int curPrime;
        long result = 1;
        while (i < primes.size() && primes.get(i) <= N) {
            curPrime = primes.get(i);
            final long powersOfPrime = powerOfPrimeInFactorial(N, curPrime)
                    - powerOfPrimeInFactorial(K, curPrime)
                    - powerOfPrimeInFactorial(N - K, curPrime);
            if (powersOfPrime > 0) {
                result = result * ((long) Math.pow(curPrime, powersOfPrime));
            }
            i++;
        }

        return result;
    }

    private static long powerOfPrimeInFactorial(int N, int prime) {
        long result = 0;
        for (long p = prime; p <= N; p *= prime) {
            result = result + (int) (N / p);
        }

        return result;
    }
}
