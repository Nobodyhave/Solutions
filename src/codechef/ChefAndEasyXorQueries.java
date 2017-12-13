package codechef;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by Aleksandr on 04/12/2017.
 * Project Solutions
 * <p>
 * https://www.codechef.com/DEC17/problems/CHEFEXQ
 */
public class ChefAndEasyXorQueries {
    public static void main(String[] args) throws IOException {
        //final Scanner in = new Scanner(System.in);
        final Scanner in = new Scanner(new FileInputStream("C:\\Projects\\Solutions\\src\\tests.txt"));

        final int N = in.nextInt();
        final int Q = in.nextInt();

        final int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = in.nextInt();
        }

        for (int q = 0; q < Q; q++) {
            final int type = in.nextInt();
            if (type == 1) {
                final int i = in.nextInt();
                final int x = in.nextInt();

                bruteUpdate(A, i, x);
            } else {
                final int i = in.nextInt();
                final int k = in.nextInt();

                System.out.println(bruteQuery(A, i, k));
            }
        }
    }

    private static void bruteUpdate(int[] A, int i, int x) {
        A[i - 1] = x;
    }

    private static int bruteQuery(int[] A, int i, int k) {
        int xor = 0, count = 0;
        for (int j = 0; j < i; j++) {
            xor ^= A[j];
            if (xor == k) {
                count++;
            }
        }

        return count;
    }
}
