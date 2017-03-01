package hackerrank.algorithms.contests_unpublished;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by Aleksandr on 23/02/2017.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/contests/w29/challenges/megaprime-numbers
 */
public class MegaPrimeNumbers {
    private static final Set<Long> RESULT = new HashSet<>();
    private static final long[][] POWERS = new long[][]{
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {1, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000, 1000000000L, 10000000000L, 100000000000L, 1000000000000L, 10000000000000L, 100000000000000L},
            {3, 30, 300, 3000, 30000, 300000, 3000000, 30000000, 300000000, 3000000000L, 30000000000L, 300000000000L, 3000000000000L, 30000000000000L, 300000000000000L},
            {5, 50, 500, 5000, 50000, 500000, 5000000, 50000000, 500000000, 5000000000L, 50000000000L, 500000000000L, 5000000000000L, 50000000000000L, 500000000000000L}
    };
    private static long COUNT = 0;

    public static void main(String[] args) throws FileNotFoundException {
        //final Scanner in = new Scanner(System.in);
        long t1 = System.currentTimeMillis();
        final Scanner in = new Scanner(new FileInputStream("C:\\Projects\\Solutions\\src\\tests.txt"));

        final long first = in.nextLong();
        final long last = in.nextLong();
        final int firstLength = String.valueOf(first).length();
        final int lastLength = String.valueOf(last).length();

        for (int i = firstLength; i <= lastLength; i++) {
            StringBuilder sb = new StringBuilder();
            if (firstLength <= 10) {
                sb = new StringBuilder();
                for (int j = 0; j < i; j++) {
                    sb.append(2);
                }
            } else {
                sb = new StringBuilder(String.valueOf(first));
                for (int j = 0; j < 10; j++) {
                    sb.setCharAt(sb.length() - 1 - j, '2');
                }
            }

            if (isMegaPrime(sb)) {
                goDeeper(Long.parseLong(sb.toString()), 0, Math.min(sb.length(), 10), first, last);
            }
        }

        if (first <= 3 && last >= 2) {
            RESULT.add(2L);
        }
        if (first <= 3 && last >= 3) {
            RESULT.add(3L);
        }
        if (first <= 5 && last >= 5) {
            RESULT.add(5L);
        }
        if (first <= 7 && last >= 7) {
            RESULT.add(7L);
        }
        System.out.println(RESULT.size());
        long t2 = System.currentTimeMillis();
        //System.out.println("Time: " + (t2 - t1) + " Count: " + COUNT);
    }

    private static void goDeeper(long num, int start, int steps, long first, long last) {
        COUNT++;
        if (num > last) {
            return;
        }

        if (num >= first && num <= last
                && num % 2 != 0
                && num % 3 != 0
                && num % 5 != 0
                && num % 7 != 0
                && !RESULT.contains(num)
                && BigInteger.valueOf(num).isProbablePrime(10)) {
            RESULT.add(num);
        }

        if (steps > 0) {
            for (int i = 0; i < POWERS.length; i++) {
                num += POWERS[i][start];
                goDeeper(num, start + 1, steps - 1, first, last);
                num -= POWERS[i][start];
            }
        }
    }

    public static boolean isMegaPrime(StringBuilder sb) {
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) != '2' && sb.charAt(i) != '3' && sb.charAt(i) != '5' && sb.charAt(i) != '7') {
                return false;
            }
        }

        return true;
    }

    public static boolean isPrime(long n) {
        if (n == 2)
            return true;
        if (n == 3)
            return true;
        if (n % 2 == 0)
            return false;
        if (n % 3 == 0)
            return false;

        long i = 5;
        long w = 2;

        while (i * i <= n) {
            if (n % i == 0) {
                return false;
            }

            i += w;
            w = 6 - w;
        }

        return true;
    }
}
