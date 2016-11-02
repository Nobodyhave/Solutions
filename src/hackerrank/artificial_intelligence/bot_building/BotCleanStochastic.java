package hackerrank.artificial_intelligence.bot_building;

/**
 * Created by Aleksandr on 31/10/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/botcleanr
 */

import java.util.Scanner;

public class BotCleanStochastic {

    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);

        final int row = in.nextInt();
        final int col = in.nextInt();

        final char[][] grid = new char[5][5];
        for (int i = 0; i < 5; i++) {
            final String str = in.next();
            for (int j = 0; j < 5; j++) {
                grid[i][j] = str.charAt(j);
            }
        }

        next_move(row, col, grid);
    }

    public static void next_move(int posR, int posC, char[][] board) {
        int rowD = 0, colD = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (board[i][j] == 'd') {
                    rowD = i;
                    colD = j;
                }
            }
        }

        if (posR == rowD && posC == colD) {
            System.out.println("CLEAN");
            return;
        }

        if (rowD < posR) {
            System.out.println("UP");
        } else if (rowD > posR) {
            System.out.println("DOWN");
        } else {
            if (colD < posC) {
                System.out.println("LEFT");
            } else if (colD > posC) {
                System.out.println("RIGHT");
            }
        }
    }
}
