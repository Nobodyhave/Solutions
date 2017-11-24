package codechef;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by Aleksandr on 06/11/2017.
 * Project Solutions
 * <p>
 * https://www.codechef.com/NOV17/problems/PERPALIN
 */
public class PeriodicPalindromeConstruction {
    public static void main(String[] args) throws FileNotFoundException {
        //final Scanner in = new Scanner(System.in);
        final Scanner in = new Scanner(new FileInputStream("C:\\Projects\\Solutions\\src\\tests.txt"));

        final int T = in.nextInt();
        for (int t = 0; t < T; t++) {
            final int N = in.nextInt();
            final int P = in.nextInt();

            final int count = N / P;
            final StringBuilder sb = new StringBuilder();
            boolean hasA = false;
            if (P % 2 != 0) {
                for (int i = 0; i < P / 2; i++) {
                    hasA = true;
                    sb.append('a');
                }
                sb.append('b');
                for (int i = 0; i < P / 2; i++) {
                    sb.append('a');
                }
            } else {
                for (int i = 0; i < P / 2 - 1; i++) {
                    hasA = true;
                    sb.append('a');
                }
                sb.append('b');
                sb.append('b');
                for (int i = 0; i < P / 2 - 1; i++) {
                    sb.append('a');
                }
            }

            if (!hasA) {
                System.out.println("impossible");
                continue;
            }

            final StringBuilder result = new StringBuilder(N);
            for (int i = 0; i < count; i++) {
                result.append(sb);
            }

            System.out.println(result);
        }
    }
}
