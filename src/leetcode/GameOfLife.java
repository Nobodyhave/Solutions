package leetcode;

/**
 * Created by Aleksandr on 14/08/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/game-of-life/description/
 */
public class GameOfLife {
    private static final int CUR_MASK = 1;

    public void gameOfLife(int[][] board) {
        if (board == null || board.length == 0 || board[0] == null || board[0].length == 0) {
            return;
        }

        int rows = board.length;
        int cols = board[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                board[i][j] <<= 1;
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int count = 0;

                if (i != 0 && j != 0) {
                    count += board[i - 1][j - 1] >> 1;
                }
                if (i != 0) {
                    count += board[i - 1][j] >> 1;
                }
                if (i != 0 && j != cols - 1) {
                    count += board[i - 1][j + 1] >> 1;
                }
                if (j != cols - 1) {
                    count += board[i][j + 1] >> 1;
                }
                if (i != rows - 1 && j != cols - 1) {
                    count += board[i + 1][j + 1] >> 1;
                }
                if (i != rows - 1) {
                    count += board[i + 1][j] >> 1;
                }
                if (i != rows - 1 && j != 0) {
                    count += board[i + 1][j - 1] >> 1;
                }
                if (j != 0) {
                    count += board[i][j - 1] >> 1;
                }

                if ((board[i][j] >> 1) == 1) {
                    if (count < 2) {
                        // Underpopulation
                        board[i][j] |= 0;
                    } else if (count < 4) {
                        // Just OK
                        board[i][j] |= 1;
                    } else {
                        // Overpopulation
                        board[i][j] |= 0;
                    }
                } else if (count == 3) {
                    // Revive dead cell
                    board[i][j] |= 1;
                }
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                board[i][j] &= CUR_MASK;
            }
        }
    }
}
