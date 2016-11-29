package hackerrank.algorithms.graph_theory;

/**
 * Created by Aleksandr on 28/11/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/clique
 */

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Clique {

    public static void main(String[] args) throws FileNotFoundException {
        //final Scanner in = new Scanner(System.in);
        final Scanner in = new Scanner(new FileInputStream("C:\\Projects\\Solutions\\src\\tests.txt"));

        final int T = in.nextInt();
        for (int i = 0; i < T; i++) {
            final int N = in.nextInt();
            final int M = in.nextInt();

            int start = 2, end = N, mid;
            int max = 2;
            while (start <= end) {
                mid = start + (end - start) / 2;

                if (calculateTuran(mid, N) < M) {
                    start = mid + 1;
                    if (mid > max) {
                        max = mid;
                    }
                } else if (calculateTuran(mid, N) >= M) {
                    end = mid - 1;
                }
            }

            System.out.println(max);
        }
    }

    public static int calculateTuran(int cliqueSize, int N) {
        int r = cliqueSize - 1;

        return (int) ((Math.pow(N, 2) - (N % r) * Math.pow(Math.ceil((double) N / r), 2) - (r - (N % r)) * Math.pow(Math.floor((double) N / r), 2)) / 2);
    }
}
