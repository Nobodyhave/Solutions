package hackerrank.mathematics.number_theory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * Created by Aleksandr on 09/12/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/mehta-and-his-laziness
 */
public class MehtaAndHisLaziness {
    public static void main(String[] args) throws FileNotFoundException {
        //final Scanner in = new Scanner(System.in);
        final Scanner in = new Scanner(new FileInputStream("C:\\Projects\\Solutions\\src\\tests.txt"));

        final Set<Integer> squares = new HashSet<>();
        int i = 2;
        int square;
        while ((square = i * i) <= 1000000) {
            if (square % 2 == 0) {
                squares.add(square);
            }
            i++;
        }

        final int T = in.nextInt();
        for (int t = 0; t < T; t++) {
            final int N = in.nextInt();

            final List<Integer> divisors = trialDivisors(N);
            final int[] count = {0};
            divisors.stream().filter(squares::contains).forEach(div -> count[0]++);

            if (count[0] == 0) {
                System.out.println("0");
            } else {
                final int gcd = gcd(count[0], divisors.size());
                System.out.format("%d/%d\n", count[0] / gcd, divisors.size() / gcd);
            }
        }
    }

    private static List<Integer> trialDivisors(int N) {
        final int M = (int) Math.sqrt(N);
        final List<Integer> small = new ArrayList<>();
        final Stack<Integer> big = new Stack<>();

        for (int i = 1; i < M; i++) {
            if (N % i == 0) {
                small.add(i);
                big.push(N / i);
            }
        }

        if (N % M == 0) {
            small.add(M);
            if (N / M != M) {
                big.push(N / M);
            }
        }

        while (!big.isEmpty()) {
            small.add(big.pop());
        }

        small.remove(small.size() - 1);

        return small;
    }

    private static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
