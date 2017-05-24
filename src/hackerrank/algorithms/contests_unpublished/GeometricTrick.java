package hackerrank.algorithms.contests_unpublished;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

/**
 * Created by Aleksandr on 18/05/2017.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/contests/w32/challenges/geometric-trick
 */
public class GeometricTrick {
    private static int geometricTrick(String s) {
        final Set<Triplet> result = new HashSet<>();
        final int[] primes = sieve(s.length());

        for (int j = 1; j < s.length(); j++) {
            if (s.charAt(j - 1) != 'b') {
                continue;
            }

            final List<Integer> divisors = calculateDivisors(j, primes);
            Collections.sort(divisors);

            for (int i = divisors.size() - 1; i > 0; i--) {
                for (int k = i - 1; k >= 0; k--) {
                    final long iV = (long) j * divisors.get(k) / divisors.get(i);
                    final long kV = (long) j * divisors.get(i) / divisors.get(k);

                    if (iV <= s.length() && kV <= s.length()) {
                        if (checkString(s, (int) iV - 1, j - 1, (int) kV - 1)) {
                            result.add(new Triplet((int) iV - 1, j - 1, (int) kV - 1));
                        } else if (checkString(s, (int) kV - 1, j - 1, (int) iV - 1)) {
                            result.add(new Triplet((int) kV - 1, j - 1, (int) iV - 1));
                        }
                    } else {
                        break;
                    }
                }
            }
        }

        return result.size();
    }

    private static List<Integer> calculateDivisors(int N, int[] primes) {
        final List<Integer> localPrimes = getFactorization(N, primes);

        final Set<Integer> dividers = new HashSet<>(50);
        dividers.add(1);
        calculateDivisors(dividers, localPrimes, 0, 1, N);

        return new ArrayList<>(dividers);
    }

    private static void calculateDivisors(
            Set<Integer> dividers, List<Integer> primeDivisors, int currentDivisor, int currentResult, int N) {
        if (currentResult > N) {
            return;
        } else if (N % currentResult == 0) {
            dividers.add(currentResult);
        } else if (currentDivisor == primeDivisors.size()) {
            return;
        }

        for (int i = currentDivisor; i < primeDivisors.size(); ++i) {
            calculateDivisors(dividers, primeDivisors, i + 1, currentResult * primeDivisors.get(i), N);
        }
    }

    private static boolean checkString(String s, int i, int j, int k) {
        return s.charAt(i) == 'a' && s.charAt(j) == 'b' && s.charAt(k) == 'c';
    }

    private static void generateTest() throws IOException {
        final Random rand = new Random();
        final StringBuilder sb = new StringBuilder();
        final int n = 500000;
        sb.append(n).append('\n');
        for (int i = 0; i < n; i++) {
            final int probability = rand.nextInt(100);
            if (probability < 10) {
                sb.append('b');
            } else if (probability < 65) {
                sb.append('a');
            } else {
                sb.append('c');
            }
        }

        final FileWriter fw = new FileWriter("C:\\Projects\\Algos\\test_data.txt");
        fw.write(sb.toString());
        fw.flush();
        fw.close();
    }

    public static void main(String[] args) throws IOException {
        final Scanner in = new Scanner(System.in);
        //generateTest();
        //final Scanner in = new Scanner(new FileInputStream("C:\\Projects\\Algos\\test_data.txt"));
        in.nextInt();
        final String s = in.next();

        System.out.println(geometricTrick(s));
    }

    private static int[] sieve(int N) {
        final int[] spf = new int[N + 1];
        spf[1] = 1;
        for (int i = 2; i < N; i++)

            // marking smallest prime factor for every
            // number to be itself.
            spf[i] = i;

        // separately marking spf for every even
        // number as 2
        for (int i = 4; i < N; i += 2)
            spf[i] = 2;

        for (int i = 3; i * i < N; i++) {
            // checking if i is prime
            if (spf[i] == i) {
                // marking SPF for all numbers divisible by i
                for (int j = i * i; j < N; j += i)

                    // marking spf[j] if it is not
                    // previously marked
                    if (spf[j] == j)
                        spf[j] = i;
            }
        }

        return spf;
    }

    private static List<Integer> getFactorization(int x, int[] spf) {
        List<Integer> ret = new ArrayList<>();
        while (x != 1) {
            ret.add(spf[x]);
            x = x / spf[x];
        }
        return ret;
    }

    private static class Triplet {
        private int a;
        private int b;
        private int c;

        Triplet(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Triplet triplet = (Triplet) o;

            return a == triplet.a && b == triplet.b && c == triplet.c;
        }

        @Override
        public int hashCode() {
            int result = a;
            result = 31 * result + b;
            result = 31 * result + c;
            return result;
        }
    }
}