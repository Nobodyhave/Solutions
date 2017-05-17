package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Aleksandr on 16/05/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/n-queens
 */
public class NQueens {
    public List<List<String>> solveNQueens(int n) {
        final char[][] board = new char[n][n];
        final int[][] attacked = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }

        final List<List<String>> result = new ArrayList<>();
        goDeeper(result, board, attacked, 0);

        return result;
    }

    private static void goDeeper(List<List<String>> result, char[][] board, int[][] attacked, int count) {
        if (count == board.length) {
            result.add(boardToString(board));
            return;
        }

        for (int i = 0; i < board.length; i++) {
            if (attacked[count][i] != 0) {
                continue;
            }

            markAttacked(attacked, count, i, 1);
            board[count][i] = 'Q';
            goDeeper(result, board, attacked, count + 1);
            board[count][i] = '.';
            markAttacked(attacked, count, i, -1);
        }
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

    private static List<String> boardToString(char[][] board) {
        return Stream.of(board).map(String::new).collect(Collectors.toList());
    }
}
