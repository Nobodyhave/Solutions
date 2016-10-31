package hackerrank.algorithms.implementation;

/**
 * Created by Aleksandr on 31/10/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/bomber-man
 */

import java.util.Scanner;

public class TheBombermanGame {

    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);

        final int R = in.nextInt();
        final int C = in.nextInt();
        final int N = in.nextInt();

        final char[][] initial = new char[R][C];
        final char[][] full = new char[R][C];
        final char[][] third = new char[R][C];
        final char[][] fifth = new char[R][C];
        for (int i = 0; i < R; i++) {
            final String row = in.next();
            for (int j = 0; j < C; j++) {
                initial[i][j] = row.charAt(j);
                full[i][j] = 'O';
                third[i][j] = 'O';
                fifth[i][j] = 'O';
            }
        }

        detonate(R, C, initial, third);
        detonate(R, C, third, fifth);

        if (N == 1) {
            printBoard(initial);
        } else if (N % 2 == 0) {
            printBoard(full);
        } else if ((N - 1) % 4 == 0) {
            printBoard(fifth);
        } else {
            printBoard(third);
        }

    }

    private static void detonate(int R, int C, char[][] initial, char[][] exploded) {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (initial[i][j] == '.') {
                    continue;
                }

                if (i != 0) {
                    exploded[i - 1][j] = '.';
                }
                if (i != R - 1) {
                    exploded[i + 1][j] = '.';
                }
                if (j != 0) {
                    exploded[i][j - 1] = '.';
                }
                if (j != C - 1) {
                    exploded[i][j + 1] = '.';
                }
                exploded[i][j] = '.';
            }
        }
    }

    private static void printBoard(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }
}
