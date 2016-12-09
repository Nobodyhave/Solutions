package hackerrank.mathematics.number_theory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Aleksandr on 09/12/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/fibonacci-finding-easy
 */
public class FibonacciFinding {
    public static void main(String[] args) throws FileNotFoundException {
        //final Scanner in = new Scanner(System.in);
        final Scanner in = new Scanner(new FileInputStream("C:\\Projects\\Solutions\\src\\tests.txt"));

        final int T = in.nextInt();
        for (int t = 0; t < T; t++) {
            final int A = in.nextInt();
            final int B = in.nextInt();
            final int N = in.nextInt();
            final int mod = 1000000007;

            System.out.println(calculateFibonacci(A, B, N, mod));
        }
    }

    private static long calculateFibonacci(int A, int B, int N, int mod) {
        if (N == 0) {
            return A;
        } else if (N == 1) {
            return B;
        }

        long[][] fib = {{1, 1}, {1, 0}};
        long[][] result = {{1, 0}, {0, 1}};
        long[][] tmp = {{0, 0}, {0, 0}};
        int i, j, k;
        while (N > 0) {
            if ((N & 1) == 1) {
                Arrays.fill(tmp[0], 0);
                Arrays.fill(tmp[1], 0);
                for (i = 0; i < 2; i++) {
                    for (j = 0; j < 2; j++) {
                        for (k = 0; k < 2; k++) {
                            tmp[i][j] = (tmp[i][j] + result[i][k] * fib[k][j]);
                        }
                    }
                }
                for (i = 0; i < 2; i++) {
                    for (j = 0; j < 2; j++) {
                        result[i][j] = tmp[i][j] % mod;
                    }
                }
            }

            Arrays.fill(tmp[0], 0);
            Arrays.fill(tmp[1], 0);
            for (i = 0; i < 2; i++) {
                for (j = 0; j < 2; j++) {
                    for (k = 0; k < 2; k++) {
                        tmp[i][j] = (tmp[i][j] + fib[i][k] * fib[k][j]);
                    }
                }
            }
            for (i = 0; i < 2; i++) {
                for (j = 0; j < 2; j++) {
                    fib[i][j] = tmp[i][j] % mod;
                }
            }
            N >>= 1;
        }
        return (result[1][0] * B + result[1][1] * A) % mod;
    }
}
