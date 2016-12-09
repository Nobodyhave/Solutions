package hackerrank.mathematics.number_theory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by Aleksandr on 09/12/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/help-mike
 */
public class HelpMike {
    public static void main(String[] args) throws FileNotFoundException {
        //final Scanner in = new Scanner(System.in);
        final Scanner in = new Scanner(new FileInputStream("C:\\Projects\\Solutions\\src\\tests.txt"));

        final int T = in.nextInt();
        for (int t = 0; t < T; t++) {
            final int N = in.nextInt();
            final int K = in.nextInt();

            int fullCycles = N / K;
            final int[] counts = new int[K];
            for (int i = 0; i < counts.length; i++) {
                counts[i] += fullCycles;
            }

            for (int i = fullCycles * K + 1; i <= N; i++) {
                counts[i % K]++;
            }

            long count = (long) counts[0] * (counts[0] - 1) / 2;
            int start = 1, end = K - 1;
            while (start <= end) {
                if (start != end) {
                    count += (long) counts[start] * counts[end];
                } else {
                    count += (long) counts[start] * (counts[start] - 1) / 2;
                }
                start++;
                end--;
            }

            System.out.println(count);
        }
    }
}
