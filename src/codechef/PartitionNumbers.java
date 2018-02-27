package codechef;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Aleksandr on 08/01/2018.
 * Project Solutions
 * <p>
 * https://www.codechef.com/JAN18/problems/PRTITION
 */
public class PartitionNumbers {
    public static void main(String[] args) throws Exception {
        //generateTest();
        final Scanner in = new Scanner(System.in);
        //final Scanner in = new Scanner(new FileInputStream("C:\\Projects\\Solutions\\src\\tests.txt"));

        final int T = in.nextInt();
        final StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            final int x = in.nextInt();
            final int N = in.nextInt();
            long sum = 0;
            for (long i = 1; i <= N; i++) {
                sum += i;
            }
            sum -= (long) x;
            if (sum % 2 != 0 || N <= 2) {
                sb.append("impossible").append("\n");
            } else {
                sb.append(partition(x, N, sum / 2)).append("\n");
            }
        }

        System.out.println(sb);
        System.out.flush();
    }

    private static String partition(int x, int N, long sum) {
        long sumP = sum;
        char[] chars = new char[N + 1];
        Arrays.fill(chars, '0');
        chars[x] = '2';
        int p = N;
        while (sumP != 0 && p >= 1) {
            if (p == x) {
                p--;
            } else if (p <= sumP) {
                chars[p] = '1';
                sumP -= p;
                p--;
            } else {
                p = (int) sumP;
            }
        }

        if (sumP != 0) {
            sumP = sum;
            chars = new char[N + 1];
            Arrays.fill(chars, '0');
            chars[x] = '2';
            p = N - 1;
            while (sumP != 0 && p >= 1) {
                if (p == x) {
                    p--;
                } else if (p <= sumP) {
                    chars[p] = '1';
                    sumP -= p;
                    p--;
                } else {
                    p = (int) sumP;
                }
            }
        }

        return sumP == 0 ? new String(chars, 1, N) : "impossible";
    }
}
