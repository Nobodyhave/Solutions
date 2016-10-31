package hackerrank.algorithms.implementation;

/**
 * Created by Aleksandr on 31/10/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/the-grid-search
 */

import java.io.FileNotFoundException;
import java.util.Scanner;

public class TheGridSearch {

    public static void main(String[] args) throws FileNotFoundException {
        final Scanner in = new Scanner(System.in);

        final int T = in.nextInt();
        for (int t = 0; t < T; t++) {
            final int R = in.nextInt();
            final int C = in.nextInt();
            final char[][] grid = new char[R][C];
            for (int i = 0; i < R; i++) {
                grid[i] = in.next().toCharArray();
            }

            final int r = in.nextInt();
            final int c = in.nextInt();
            final char[][] pattern = new char[r][c];
            for (int i = 0; i < r; i++) {
                pattern[i] = in.next().toCharArray();
            }

            boolean matches = false;
            outer:
            for (int i = 0; i < R - r + 1; i++) {
                inner:
                for (int j = 0; j < C - c + 1; j++) {
                    if (grid[i][j] == pattern[0][0] && grid[i + r - 1][j + c - 1] == pattern[r - 1][c - 1]) {
                        for (int k = 0; k < r; k++) {
                            for (int l = 0; l < c; l++) {
                                if (grid[i + k][j + l] != pattern[k][l]) {
                                    continue inner;
                                }
                            }
                        }
                        matches = true;
                        break outer;
                    }
                }
            }
            if (matches) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
