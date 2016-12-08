package hackerrank.mathematics.fundamentals;

/**
 * Created by Aleksandr on 01/12/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/leonardo-and-prime
 */

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
import java.util.Scanner;

public class LeonardosPrimeFactors {

    public static void main(String[] args) throws FileNotFoundException {
        //final Scanner in = new Scanner(System.in);
        final Scanner in = new Scanner(new FileInputStream("C:\\Projects\\Solutions\\src\\tests.txt"));

        final List<Integer> primes = sieveOfEratosthenes(1000000);

        final int Q = in.nextInt();
        for (int q = 0; q < Q; q++) {
            final long N = in.nextLong();

            BigInteger result = BigInteger.ONE;
            int count = 0;
            while (((result = result.multiply(BigInteger.valueOf(primes.get(count)))).compareTo(BigInteger.valueOf(N)) <= 0)) {
                count++;
            }

            System.out.println(count);
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
}
