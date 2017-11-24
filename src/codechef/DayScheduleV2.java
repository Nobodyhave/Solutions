package codechef;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * Created by Aleksandr on 03/11/2017.
 * Project Solutions
 * <p>
 * https://www.codechef.com/NOV17/problems/BINOMSUM
 */
public class DayScheduleV2 {
    private static int[] FACTORIALS;
    private static int[] FACTORIALS_PREFIX_SUM;
    private static final Map<Integer, Integer> CACHE = new HashMap<>();

    public static void main(String[] args) throws FileNotFoundException {
        //final Scanner in = new Scanner(System.in);
        final Scanner in = new Scanner(new FileInputStream("C:\\Projects\\Solutions\\src\\tests.txt"));

        final int K = in.nextInt();
        final int A = in.nextInt();
        final int P = in.nextInt();
        final int Q = in.nextInt();

        FACTORIALS = factorials(10000000, P);

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
        final long big = ((long) (FACTORIALS[D + T] * Math.E - 1)) % P;
        final long small = ((long) (FACTORIALS[D] * Math.E - 1)) % P;
        return ((long) (big - small) * modPowByExponent(A, T, P)) % P;
    }

    private static long calculate(int K, long A, int P, int L, int D, int T) {
        //long nCk = arrangement(D, D - L, P);
        long result = 0;
        for (int t = 0; t < T; t++) {
            final long allHours = (K - 1) / 2;
            final long activityHours = (K - 1 - allHours);
            long curDay = arrangement(D, L, P);
            if (allHours != 0) {
                curDay *= (A + D) % P;
                curDay %= P;
            }
            curDay *= (A * activityHours) % P;
            curDay %= P;

            result += curDay;
            result %= P;

            D++;
            //nCk = nextArrangement(nCk, D) % P;
        }

        return result;
    }

    private static int inverse(int a, int m) {
        Integer num = CACHE.get(a);
        if (num != null) {
            return num;
        } else {
            num = (int) power(a, m - 2, m);
            CACHE.put(a, num);
        }

        return num;
    }

    // To compute x^y under modulo m
    private static long power(int x, int y, long m) {
        if (y == 0) {
            return 1;
        }
        long p = power(x, y / 2, m) % m;
        p = (p * p) % m;

        return (y % 2 == 0) ? p : (x * p) % m;
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

    private static long nextArrangement(long nCk, long n) {
        return nCk * n;
    }

    private static int arrangement(int N, int K, int mod) {
        return (int) (((long) FACTORIALS[N] * (long) inverse(FACTORIALS[N - K], mod)) % mod);
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

    private static int[] factorials(int N, int P) {
        final int[] nums = new int[N + 1];
        nums[0] = 1;
        nums[1] = 1;

        FACTORIALS_PREFIX_SUM = new int[N + 2];
        FACTORIALS_PREFIX_SUM[0] = 0;
        FACTORIALS_PREFIX_SUM[1] = 1;
        FACTORIALS_PREFIX_SUM[2] = 2;

        int fact = 1;
        for (int i = 2; i <= N; i++) {
            fact = (int) (((long) fact * (long) i) % P);
            nums[i] = fact;
            FACTORIALS_PREFIX_SUM[i + 1] = (FACTORIALS_PREFIX_SUM[i] + fact) % P;
        }

        return nums;
    }
}
