package leetcode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by Aleksandr on 27/06/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/surrounded-regions
 */
public class SurroundedRegions {
    private boolean[][] markedCheck;
    private boolean[][] markedFill;

    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0] == null || board[0].length == 0) {
            return;
        }

        markedCheck = new boolean[board.length][board[0].length];
        markedFill = new boolean[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'O' && !markedCheck[i][j] && bfsCheck(board, i, j)) {
                    bfsMark(board, i, j);
                }
            }
        }
    }

    private void bfsMark(char[][] board, int row, int col) {
        final Queue<Integer> queue = new ArrayDeque<>();

        queue.add(row * board[0].length + col);

        while (!queue.isEmpty()) {
            int cellIndex = queue.poll();
            int r = cellIndex / board[0].length;
            int c = cellIndex % board[0].length;

            if (markedFill[r][c] || board[r][c] == 'X') {
                continue;
            }

            board[r][c] = 'X';
            markedFill[r][c] = true;

            if (r - 1 >= 0) {
                queue.add((r - 1) * board[0].length + c);
            }
            if (r + 1 < board.length) {
                queue.add((r + 1) * board[0].length + c);
            }
            if (c - 1 >= 0) {
                queue.add(r * board[0].length + c - 1);
            }
            if (c + 1 < board[0].length) {
                queue.add(r * board[0].length + c + 1);
            }
        }
    }

    private boolean bfsCheck(char[][] board, int row, int col) {
        final Queue<Integer> queue = new ArrayDeque<>();
        boolean isSurrounded = true;

        queue.add(row * board[0].length + col);

        while (!queue.isEmpty()) {
            int cellIndex = queue.poll();
            int r = cellIndex / board[0].length;
            int c = cellIndex % board[0].length;

            if (markedCheck[r][c] || board[r][c] == 'X') {
                continue;
            }
            markedCheck[r][c] = true;

            if (r - 1 >= 0) {
                queue.add((r - 1) * board[0].length + c);
            } else {
                isSurrounded = false;
            }
            if (r + 1 < board.length) {
                queue.add((r + 1) * board[0].length + c);
            } else {
                isSurrounded = false;
            }
            if (c - 1 >= 0) {
                queue.add(r * board[0].length + c - 1);
            } else {
                isSurrounded = false;
            }
            if (c + 1 < board[0].length) {
                queue.add(r * board[0].length + c + 1);
            } else {
                isSurrounded = false;
            }
        }

        return isSurrounded;
    }
}
