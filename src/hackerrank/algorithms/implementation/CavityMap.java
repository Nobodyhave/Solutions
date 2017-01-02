package hackerrank.algorithms.implementation;

import java.util.Scanner;

/**
 * Created by Aleksandr on 02/01/2017.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/cavity-map
 */
public class CavityMap {
    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);
        final int N = in.nextInt();
        final char[][] cells = new char[N][N];
        for (int i = 0; i < N; i++) {
            String line = in.next();
            for (int j = 0; j < N; j++) {
                cells[i][j] = line.charAt(j);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == 0 || i == N - 1 || j == 0 || j == N - 1) {
                    System.out.print(cells[i][j]);
                } else if (
                        cells[i - 1][j] < cells[i][j] &&
                                cells[i][j + 1] < cells[i][j] &&
                                cells[i + 1][j] < cells[i][j] &&
                                cells[i][j - 1] < cells[i][j]) {
                    System.out.print("X");
                } else {
                    System.out.print(cells[i][j]);
                }
            }
            System.out.println();
        }
    }
}
