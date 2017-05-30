package leetcode;

/**
 * Created by Aleksandr on 30/05/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/word-search
 */
public class WordSearch {
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0] == null || board[0].length == 0) {
            return false;
        } else if (word == null || word.length() == 0) {
            return true;
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    final StringBuilder sb = new StringBuilder();
                    sb.append(board[i][j]);
                    final boolean found = goDeeper(board, new boolean[board.length][board[0].length], word, sb, i, j);
                    if (found) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private static boolean goDeeper(char[][] board, boolean[][] marked, String word, StringBuilder sb, int row, int col) {
        if (sb.length() == word.length()) {
            return word.equals(sb.toString());
        }

        marked[row][col] = true;
        boolean found = makeMove(board, marked, word, sb, row - 1, col);
        if (found) {
            return true;
        }
        found = makeMove(board, marked, word, sb, row + 1, col);
        if (found) {
            return true;
        }
        found = makeMove(board, marked, word, sb, row, col - 1);
        if (found) {
            return true;
        }
        found = makeMove(board, marked, word, sb, row, col + 1);
        if (found) {
            return true;
        }
        marked[row][col] = false;

        return false;
    }

    private static boolean makeMove(char[][] board, boolean[][] marked, String word, StringBuilder sb, int row, int col) {
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || marked[row][col] || board[row][col] != word.charAt(sb.length())) {
            return false;
        }

        sb.append(board[row][col]);
        final boolean found = goDeeper(board, marked, word, sb, row, col);
        sb.deleteCharAt(sb.length() - 1);

        return found;
    }
}
