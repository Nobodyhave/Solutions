package hackerrank.java.data_structures;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by Aleksandr on 19/01/2017.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/java-1d-array
 */
public class Java1dArrayPart2 {
    public static void main(String[] args) throws FileNotFoundException {
        //final Scanner in = new Scanner(System.in);
        final Scanner in = new Scanner(new FileInputStream("C:\\Projects\\Solutions\\src\\tests.txt"));
        final int T = in.nextInt();

        for (int t = 0; t < T; t++) {
            final int N = in.nextInt();
            final int M = in.nextInt();
            final int[] a = new int[N];
            final boolean[] marked = new boolean[N + 1];
            for (int i = 0; i < N; i++) {
                a[i] = in.nextInt();
            }


            dfs(a, marked, 0, M);
            System.out.println(marked[N] ? "YES" : "NO");
        }
    }

    private static void dfs(int[] a, boolean[] marked, int pos, int M) {
        if (pos < 0) {
            return;
        } else if (pos >= a.length) {
            marked[marked.length - 1] = true;
            return;
        } else if (marked[pos]) {
            return;
        } else {
            marked[pos] = true;
        }

        if (a[pos] == 0) {
            dfs(a, marked, pos - 1, M);
            dfs(a, marked, pos + 1, M);
            dfs(a, marked, pos + M, M);
        }
    }
}
