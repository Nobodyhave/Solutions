package leetcode;

/**
 * Created by Aleksandr on 11/05/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/sudoku-solver
 */
public class SudokuSolver {
    public void solveSudoku(char[][] board) {
        // 0-8 rows, 9-17 columns, 18-26 - squares
        goDeeper(board);
    }

    private boolean goDeeper(char[][] board) {
        if (!isValidSudoku(board)) {
            return false;
        }

        if (isFilled(board)) {
            return true;
        } else {
            boolean isSolved = false;
            int minGapIndex = findMinGap(board);
            int[] cellInfo = getCellInfo(board, minGapIndex);
            int row = cellInfo[9];
            int column = cellInfo[10];
            for (int i = 0; i < 9; i++) {
                if (cellInfo[i] == 0) {
                    char c = (char) ((char) (i) + '1');
                    board[row][column] = c;
                    //System.out.format("Set [%d][%d] to %c in region %d\n", row, column, c, minGapIndex);
                    //System.out.println(printBoard(board));
                    isSolved = goDeeper(board);
                    if (!isSolved) {
                        //System.out.format("Set [%d][%d] to %c\n", row, column, '.');
                        board[row][column] = '.';
                    } else {
                        break;
                    }
                }
            }

            return isSolved;
        }
    }

    private int[] getCellInfo(char[][] board, int regionIndex) {
        int[] result = new int[11];
        if (regionIndex < 9) {
            int row = 0;
            int column = 0;
            for (int i = 0; i < 9; i++) {
                char c = board[regionIndex][i];
                if (c == '.') {
                    row = regionIndex;
                    column = i;
                } else {
                    result[c - '0' - 1] = 1;
                }
            }
            result[9] = row;
            result[10] = column;

        } else if (regionIndex < 18) {
            int row = 0;
            int column = 0;
            for (int i = 0; i < 9; i++) {
                char c = board[i][regionIndex - 9];
                if (c == '.') {
                    row = i;
                    column = regionIndex - 9;
                } else {
                    result[c - '0' - 1] = 1;
                }
            }
            result[9] = row;
            result[10] = column;
        } else if (regionIndex < 27) {
            int row = 0;
            int column = 0;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    char c = board[(regionIndex - 18) / 3 * 3 + i][(regionIndex - 18) % 3 * 3 + j];
                    if (c == '.') {
                        row = ((regionIndex - 18) / 3 * 3 + i);
                        column = (regionIndex - 18) % 3 * 3 + j;
                    } else {
                        result[c - '0' - 1] = 1;
                    }
                }
            }
            result[9] = row;
            result[10] = column;
        } else {
            throw new IllegalArgumentException("Wrong region index");
        }

        return result;
    }

    private int findMinGap(char[][] board) {
        int[] gapsCount = new int[27];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    gapsCount[i]++;
                    gapsCount[j + 9]++;
                    gapsCount[(i / 3) * 3 + j / 3 + 18]++;
                }
            }
        }

        int min = Integer.MAX_VALUE;
        int minIndex = -1;
        for (int i = 0; i < gapsCount.length; i++) {
            int count = gapsCount[i];
            if (count < min && count != 0) {
                min = count;
                minIndex = i;
            }
        }

        return minIndex;
    }

    private boolean isFilled(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean isValidSudoku(char[][] board) {
        // 0-8 rows, 9-17 columns, 18-26 - squares
        char[][] validBoard = new char[27][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                int c = board[i][j] - '0';
                if (validBoard[i][c - 1] == 1) {
                    return false;
                } else {
                    validBoard[i][c - 1] = 1;
                }
                if (validBoard[j + 9][c - 1] == 1) {
                    return false;
                } else {
                    validBoard[j + 9][c - 1] = 1;
                }
                if (validBoard[(i / 3) * 3 + j / 3 + 18][c - 1] == 1) {
                    return false;
                } else {
                    validBoard[(i / 3) * 3 + j / 3 + 18][c - 1] = 1;
                }
            }
        }

        return true;
    }
}
