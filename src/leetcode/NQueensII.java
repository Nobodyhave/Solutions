package leetcode;

/**
 * Created by Aleksandr on 16/05/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/n-queens
 */
public class NQueensII {
    public int totalNQueens(int n) {
        final char[][] board = new char[n][n];
        final int[][] attacked = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }

        return goDeeper(board, attacked, 0);
    }

    private static int goDeeper(char[][] board, int[][] attacked, int count) {
        if (count == board.length) {
            return 1;
        }

        int solutions = 0;
        for (int i = 0; i < board.length; i++) {
            if (attacked[count][i] != 0) {
                continue;
            }

            markAttacked(attacked, count, i, 1);
            board[count][i] = 'Q';
            solutions += goDeeper(board, attacked, count + 1);
            board[count][i] = '.';
            markAttacked(attacked, count, i, -1);
        }

        return solutions;
    }

    private static void markAttacked(int[][] attacked, int row, int col, int isAttacked) {

        // Left
        for (int c = col - 1; c >= 0; c--) {
            attacked[row][c] += isAttacked;
        }

        // Right
        for (int c = col + 1; c < attacked.length; c++) {
            attacked[row][c] += isAttacked;
        }

        // Up
        for (int r = row - 1; r >= 0; r--) {
            attacked[r][col] += isAttacked;
        }

        // Down
        for (int r = row + 1; r < attacked.length; r++) {
            attacked[r][col] += isAttacked;
        }

        // Up-left
        for (int r = row - 1, c = col - 1; r >= 0 && c >= 0; r--, c--) {
            attacked[r][c] += isAttacked;
        }

        // Up-right
        for (int r = row - 1, c = col + 1; r >= 0 && c < attacked.length; r--, c++) {
            attacked[r][c] += isAttacked;
        }

        // Down-right
        for (int r = row + 1, c = col + 1; r < attacked.length && c < attacked.length; r++, c++) {
            attacked[r][c] += isAttacked;
        }

        // Down-left
        for (int r = row + 1, c = col - 1; r < attacked.length && c >= 0; r++, c--) {
            attacked[r][c] += isAttacked;
        }
    }
}
