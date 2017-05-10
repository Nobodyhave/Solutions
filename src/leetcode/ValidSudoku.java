package leetcode;

import java.util.BitSet;

/**
 * Created by Aleksandr on 10/05/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/valid-sudoku
 */
public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        final BitSet bitSet = new BitSet(9);

        // Check rows
        for (int i = 0; i < 9; i++) {
            bitSet.clear();
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    if (bitSet.get(board[i][j] - '0')) {
                        return false;
                    } else {
                        bitSet.set(board[i][j] - '0');
                    }
                }
            }
        }

        // Check columns
        for (int i = 0; i < 9; i++) {
            bitSet.clear();
            for (int j = 0; j < 9; j++) {
                if (board[j][i] != '.') {
                    if (bitSet.get(board[j][i] - '0')) {
                        return false;
                    } else {
                        bitSet.set(board[j][i] - '0');
                    }
                }
            }
        }

        // Check squares
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                bitSet.clear();
                for (int k = 0; k < 3; k++) {
                    for (int l = 0; l < 3; l++) {
                        if (board[i * 3 + k][j * 3 + l] != '.') {
                            if (bitSet.get(board[i * 3 + k][j * 3 + l] - '0')) {
                                return false;
                            } else {
                                bitSet.set(board[i * 3 + k][j * 3 + l] - '0');
                            }
                        }
                    }
                }
            }
        }

        return true;
    }
}
