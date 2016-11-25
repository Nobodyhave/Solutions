package hackerrank.data_structures.queue;

/**
 * Created by Aleksandr on 18/11/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/down-to-zero-ii
 */

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;

public class DownToZeroII {
    private static final Map<Integer, List<Integer>> DIVISORS = new HashMap<>();

    public static void main(String[] args) throws FileNotFoundException {
        //Scanner in = new Scanner(System.in);
        final Scanner in = new Scanner(new FileInputStream("C:\\Projects\\Solutions\\src\\tests.txt"));

        final List<Integer> primes = sieveOfEratosthenes(1000000);

        final int Q = in.nextInt();
        for (int q = 0; q < Q; q++) {
            final int X = in.nextInt();
            final boolean[] marked = new boolean[X + 1];
            final PriorityQueue<State> pq = new PriorityQueue<>();

            pq.add(new State(X, 0));
            marked[X] = true;

            while (!pq.isEmpty()) {
                final State state = pq.poll();

                if (state.isSolved()) {
                    System.out.println(state.moves);
                    break;
                }

                if (!marked[state.num - 1]) {
                    marked[state.num - 1] = true;
                    pq.add(new State(state.num - 1, state.moves + 1));
                }

                pq.addAll(getDivisors(state.num, primes)
                        .stream()
                        .filter(divisor -> !marked[divisor])
                        .map((divisor) -> {
                            marked[divisor] = true;
                            return new State(divisor, state.moves + 1);
                        })
                        .collect(Collectors.toList()));

            }
        }
    }

    private static List<Integer> getDivisors(int N, List<Integer> primes) {
        if (!DIVISORS.containsKey(N)) {
            final List<Integer> localPrimes = new ArrayList<>();
            for (Integer prime : primes) {
                if (prime > N) {
                    break;
                } else if (N % prime == 0) {
                    localPrimes.add(prime);
                }
            }

            final List<Integer> divisors = new ArrayList<>();
            divisors.add(1);
            divisors.add(N);
            calculateDivisors(divisors, localPrimes, 0, N, (int) Math.sqrt(N) + 1, 1);

            Collections.sort(divisors);
            DIVISORS.put(N, divisors.subList(divisors.size() / 2, divisors.size()));
        }

        return DIVISORS.get(N);
    }

    private static void calculateDivisors(List<Integer> divisors, List<Integer> primes, int start, int target, int sqrt, int cur) {
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
        final boolean[] prime = new boolean[n + 1];
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

    private static class State implements Comparable<State> {
        private int num;
        private int moves;

        State() {
        }

        State(int num, int moves) {
            this();
            this.num = num;
            this.moves = moves;
        }

        boolean isSolved() {
            return num == 0;
        }

        @Override
        public int compareTo(State o) {
            return moves - o.moves;
        }
    }
}
