package hackerrank.data_structures.stacks;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by Aleksandr on 06/02/2017.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/waiter
 */
public class Waiter {
    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);

        final int N = in.nextInt();
        final int Q = in.nextInt();

        final int[] primes = primes(Q);

        Stack<Integer> A = new Stack<>();
        for (int i = 0; i < N; i++) {
            A.push(in.nextInt());
        }

        final Stack<Integer>[] result = (Stack<Integer>[]) new Stack[Q + 2];
        for (int i = 1; i <= Q; i++) {
            final Stack<Integer> newA = new Stack<>();
            final Stack<Integer> B = new Stack<>();
            while (!A.isEmpty()) {
                final Integer num = A.pop();
                if (num % primes[i] == 0) {
                    B.push(num);
                } else {
                    newA.push(num);
                }
            }
            result[i] = B;
            A = newA;
        }
        result[Q + 1] = A;

        //System.out.println(Arrays.toString(primes));

        for (int i = 1; i <= Q + 1; i++) {
            while (!result[i].isEmpty()) {
                System.out.println(result[i].pop() + " ");
            }
        }
    }

    private static int[] primes(int Q) {
        boolean[] sieve = new boolean[Q * 10];
        int[] primes = new int[Q + 1];

        int count = 1;
        int i = 2;
        while (count < Q + 1) {
            if (!sieve[i]) {
                sieve[i] = true;
                primes[count] = i;
                count++;
                for (int j = i * i; j < sieve.length; j += i) {
                    sieve[j] = true;
                }
            }
            i++;
        }

        return primes;
    }
}
