package leetcode;

/**
 * Created by Aleksandr on 02/10/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/minesweeper
 */
public class MineSweeper {
    public char[][] updateBoard(char[][] board, int[] click) {
        if (board == null || click == null || board.length == 0 || click.length == 0) {
            return board;
        }

        if (board[click[0]][click[1]] == 'M') {
            board[click[0]][click[1]] = 'X';
            return board;
        }

        reveal(board, click[0], click[1]);

        return board;
    }

    private void reveal(char[][] board, int clickR, int clickC) {
        if (board[clickR][clickC] != 'E') {
            return;
        }

        int[] dirs = new int[]{-1, 0, 1};
        int mines = 0;
        for (int dirR : dirs) {
            for (int dirC : dirs) {
                final int newR = clickR + dirR;
                final int newC = clickC + dirC;
                if (newR >= 0 && newR < board.length && newC >= 0 && newC < board[0].length && (dirR != 0 || dirC != 0)) {
                    if (board[newR][newC] == 'M') {
                        mines++;
                    }
                }
            }
        }

        if (mines != 0) {
            board[clickR][clickC] = (char) ('0' + mines);
        } else {
            for (int dirR : dirs) {
                for (int dirC : dirs) {
                    final int newR = clickR + dirR;
                    final int newC = clickC + dirC;
                    if (newR >= 0 && newR < board.length && newC >= 0 && newC < board[0].length) {
                        board[clickR][clickC] = 'B';
                        reveal(board, newR, newC);
                    }
                }
            }
        }
    }
}
