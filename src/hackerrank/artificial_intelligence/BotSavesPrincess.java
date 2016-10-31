package hackerrank.artificial_intelligence;

/**
 * Created by Aleksandr on 31/10/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/saveprincess
 */

import java.util.Scanner;

public class BotSavesPrincess {

    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);

        final int N = in.nextInt();
        final char[][] grid = new char[N][N];
        int row = 0, col = 0;
        for (int i = 0; i < N; i++) {
            final String str = in.next();
            for (int j = 0; j < N; j++) {
                grid[i][j] = str.charAt(j);
                if (grid[i][j] == 'm') {
                    row = i;
                    col = j;
                }
            }
        }

        if (grid[0][0] == 'p' || grid[0][N - 1] == 'p') {
            while (row > 0) {
                System.out.println("UP");
                row--;
            }
        } else {
            while (row < N - 1) {
                System.out.println("DOWN");
                row++;
            }
        }

        if (grid[0][0] == 'p' || grid[N - 1][0] == 'p') {
            while (col > 0) {
                System.out.println("LEFT");
                col--;
            }
        } else {
            while (col < N - 1) {
                System.out.println("RIGHT");
                col++;
            }
        }
    }
}
