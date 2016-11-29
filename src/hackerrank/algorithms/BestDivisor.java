package hackerrank.algorithms;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Aleksandr on 29/11/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/contests/w26/challenges/best-divisor
 */
public class BestDivisor {
    private static final Map<Integer, Set<Integer>> DIVISORS = new HashMap<>();

    public static void main(String[] args) throws FileNotFoundException {
        //final Scanner in = new Scanner(System.in);
        final Scanner in = new Scanner(new FileInputStream("C:\\Projects\\Solutions\\src\\tests.txt"));
        final int n = in.nextInt();

        if (n == 0) {
            System.out.println("0");
            return;
        }

        final Set<Integer> divisors = getDivisors(n, sieveOfEratosthenes(n));
        final List<String> divisorsS = divisors.stream().map(String::valueOf).collect(Collectors.toList());

        Collections.sort(divisorsS, new DivisorsComparator());

        System.out.println(divisorsS.get(0));
    }

    private static Set<Integer> getDivisors(int N, List<Integer> primes) {
        if (!DIVISORS.containsKey(N)) {
            final List<Integer> localPrimes = new ArrayList<>();
            for (Integer prime : primes) {
                if (prime > N) {
                    break;
                } else if (N % prime == 0) {
                    localPrimes.add(prime);
                }
            }

            final Set<Integer> divisors = new TreeSet<>();
            divisors.add(1);
            divisors.add(N);
            calculateDivisors(divisors, localPrimes, 0, N, (int) Math.sqrt(N) + 1, 1);

            DIVISORS.put(N, divisors);
        }

        return DIVISORS.get(N);
    }

    private static void calculateDivisors(Set<Integer> divisors, List<Integer> primes, int start, int target, int sqrt, int cur) {
        if (target % cur == 0 && cur != 1) {
            divisors.add(cur);
            divisors.add(target / cur);
        } else if (cur > target || start > primes.size()) {
            return;
        } else if (target == 1) {
            return;
        }

        int current = cur;
        for (int i = start; i < primes.size(); i++) {
            if (current == 1 || current == cur) {
                calculateDivisors(divisors, primes, i + 1, target, sqrt, current);
            }
            while ((current *= primes.get(i)) <= sqrt) {
                calculateDivisors(divisors, primes, i + 1, target, sqrt, current);
            }
        }
    }

    private static List<Integer> sieveOfEratosthenes(int n) {
        final boolean[] prime = new boolean[Math.max(3, n + 1)];
        final List<Integer> primes = new ArrayList<>();
        Arrays.fill(prime, true);
        prime[0] = false;
        prime[1] = false;
        final int m = (int) Math.sqrt(n) + 1;

        for (int i = 2; i <= m; i++) {
            if (prime[i]) {
                primes.add(i);
                for (int k = i * i; k <= n; k += i) {
                    prime[k] = false;
                }
            }
        }
        return primes;
    }

    private static class DivisorsComparator implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            int sum1 = 0;
            for (int i = 0; i < o1.length(); i++) {
                sum1 += o1.charAt(i) - '0';
            }

            int sum2 = 0;
            for (int i = 0; i < o2.length(); i++) {
                sum2 += o2.charAt(i) - '0';
            }

            if (sum1 != sum2) {
                return Integer.compare(sum2, sum1);
            }

            int maxLength = Math.max(o1.length(), o2.length());

            if (o1.length() != maxLength) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < maxLength - o1.length(); i++) {
                    sb.append(0);
                }
                sb.append(o1);
                o1 = sb.toString();
            }

            if (o2.length() != maxLength) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < maxLength - o2.length(); i++) {
                    sb.append(0);
                }
                sb.append(o2);
                o2 = sb.toString();
            }

            return o1.compareTo(o2);
        }
    }
}
