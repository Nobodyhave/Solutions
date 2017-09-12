package leetcode;

/**
 * Created by Aleksandr on 07/09/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/battleships-in-a-board
 */
public class BattleshipsInBoard {
    public int countBattleships(char[][] board) {
        if (board == null || board.length == 0 || board[0] == null || board[0].length == 0) {
            return 0;
        }

        final int rows = board.length;
        final int cols = board[0].length;

        int count = 0;
        for (int r = 0; r < rows; r++) {
            for (int c = 1; c <= cols; c++) {
                char cur;
                if (c == cols) {
                    cur = '.';
                } else {
                    cur = board[r][c];
                }

                char tl;
                if (r == 0) {
                    tl = '.';
                } else {
                    tl = board[r - 1][c - 1];
                }

                char l = board[r][c - 1];

                char bl;
                if (r == rows - 1) {
                    bl = '.';
                } else {
                    bl = board[r + 1][c - 1];
                }

                if (cur == '.' && ((tl == '.' && l == 'X' && bl == '.') || (tl == 'X' && l == 'X' && bl == '.'))) {
                    count++;
                }
            }
        }

        return count;
    }
}
