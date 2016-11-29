package hackerrank.artificial_intelligence.bot_building;

/**
 * Created by Aleksandr on 29/11/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/botcleanlarge
 */

import java.util.Scanner;

public class BotCleanLarge {
    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);

        int x = in.nextInt();
        int y = in.nextInt();

        final int row = in.nextInt();
        final int col = in.nextInt();

        final char[][] grid = new char[row][col];
        for (int i = 0; i < row; i++) {
            final String str = in.next();
            for (int j = 0; j < col; j++) {
                grid[i][j] = str.charAt(j);
            }
        }

        next_move(x, y, grid);
    }

    public static void next_move(int posR, int posC, char[][] board) {
        int rowD = -1, colD = -1;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'd') {
                    rowD = i;
                    colD = j;
                }
            }
            if (rowD != -1) {
                for (int j = board[0].length - 1; j >= 0; j--) {
                    if (board[i][j] == 'd') {
                        if (Math.abs(posC - colD) > Math.abs(posC - j)) {
                            colD = j;
                        }
                        break;
                    }
                }
                break;
            }
        }

        if (rowD == -1) {
            return;
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
