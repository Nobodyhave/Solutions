package hackerrank.artificial_intelligence.bot_building;

/**
 * Created by Aleksandr on 31/10/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/botclean/submissions/game/31382927
 */

import java.util.Scanner;

public class BotClean {

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

    public static void next_move(int posr, int posc, char[][] board) {
        if (board[posr][posc] == 'd') {
            System.out.println("CLEAN");
            return;
        } else if (posr == 4 && posc == 4) {
            return;
        }

        if (posr % 2 == 0) {
            if (posc == 4) {
                System.out.println("DOWN");
            } else {
                System.out.println("RIGHT");
            }
        } else {
            if (posc == 0) {
                System.out.println("DOWN");
            } else {
                System.out.println("LEFT");
            }
        }
    }
}
