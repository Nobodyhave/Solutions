package hackerrank.algorithms.contests_unpublished;

import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by Aleksandr on 30/12/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/contests/ncr-codesprint/challenges/mega-tic-tac-toe
 */
public class MegaTicTacToe {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(System.in);
        //Scanner in = new Scanner(new FileInputStream("C:\\Projects\\Algos\\test_data.txt"));

        final int G = in.nextInt();
        outer:
        for (int g = 0; g < G; g++) {
            int n = in.nextInt();
            int m = in.nextInt();
            int k = in.nextInt();

            char[][] board = new char[n][m];
            for (int i = 0; i < n; i++) {
                String str = in.next();
                for (int j = 0; j < m; j++) {
                    board[i][j] = str.charAt(j);
                }
            }

            Result result = Result.NONE;
            if (k <= m) {
                for (int i = 0; i < n; i++) {
                    Result lResult = checkRow(board, i, k);
                    if ((lResult == Result.WIN && result == Result.LOSE)
                            || (lResult == Result.LOSE && result == Result.WIN)) {
                        System.out.println(Result.NONE.name());
                        continue outer;
                    } else if (lResult == Result.WIN || lResult == Result.LOSE) {
                        result = lResult;
                    }
                }
            }

            if (k <= n) {
                for (int i = 0; i < m; i++) {
                    Result lResult = checkColumn(board, i, k);
                    if ((lResult == Result.WIN && result == Result.LOSE)
                            || (lResult == Result.LOSE && result == Result.WIN)) {
                        System.out.println(Result.NONE.name());
                        continue outer;
                    } else if (lResult == Result.WIN || lResult == Result.LOSE) {
                        result = lResult;
                    }
                }
            }

            if (k <= n && k <= m) {
                Result lResult = checkFirstDiagonals(board, k);
                if ((lResult == Result.WIN && result == Result.LOSE)
                        || (lResult == Result.LOSE && result == Result.WIN)) {
                    System.out.println(Result.NONE.name());
                    continue;
                } else if (lResult == Result.WIN || lResult == Result.LOSE) {
                    result = lResult;
                }
                lResult = checkSecondDiagonals(board, k);
                if ((lResult == Result.WIN && result == Result.LOSE)
                        || (lResult == Result.LOSE && result == Result.WIN)) {
                    System.out.println(Result.NONE.name());
                    continue;
                } else if (lResult == Result.WIN || lResult == Result.LOSE) {
                    result = lResult;
                }
            }

            System.out.println(result.name());
        }
    }

    private static Result checkRow(char[][] board, int row, int k) {
        int i = 0;
        outer:
        while (i < board[0].length - k + 1) {
            if (board[row][i] == '-') {
                i++;
                continue;
            }

            int start = i, end = i + k - 1;
            while (start <= end) {
                if (board[row][start] != board[row][i] || board[row][end] != board[row][i]) {
                    i++;
                    continue outer;
                }
                start++;
                end--;
            }
            if (board[row][i] == 'O') {
                return Result.WIN;
            } else {
                return Result.LOSE;
            }
        }

        return Result.NONE;
    }

    private static Result checkColumn(char[][] board, int col, int k) {
        int i = 0;
        outer:
        while (i < board.length - k + 1) {
            if (board[i][col] == '-') {
                i++;
                continue;
            }

            int start = i, end = i + k - 1;
            while (start <= end) {
                if (board[start][col] != board[i][col] || board[end][col] != board[i][col]) {
                    i++;
                    continue outer;
                }
                start++;
                end--;
            }
            if (board[i][col] == 'O') {
                return Result.WIN;
            } else {
                return Result.LOSE;
            }
        }

        return Result.NONE;
    }

    private static Result checkFirstDiagonals(char[][] board, int k) {
        for (int i = 0; i < board.length - k + 1; i++) {
            outer:
            for (int j = 0; j < board[0].length - k + 1; j++) {
                if (board[i][j] == '-') {
                    continue;
                }

                int startR = i, endR = i + k - 1, startC = j, endC = j + k - 1;
                while (startR <= endR && startC <= endC) {
                    if (board[startR][startC] != board[i][j] || board[endR][endC] != board[i][j]) {
                        continue outer;
                    }
                    startR++;
                    startC++;
                    endR--;
                    endC--;
                }
                if (board[i][j] == 'O') {
                    return Result.WIN;
                } else {
                    return Result.LOSE;
                }
            }
        }

        return Result.NONE;
    }

    private static Result checkSecondDiagonals(char[][] board, int k) {
        for (int i = k - 1; i < board.length; i++) {
            outer:
            for (int j = 0; j < board[0].length - k + 1; j++) {
                if (board[i][j] == '-') {
                    continue;
                }

                int startR = i, endR = i - k + 1, startC = j, endC = j + k - 1;
                while (startR >= endR && startC <= endC) {
                    if (board[startR][startC] != board[i][j] || board[endR][endC] != board[i][j]) {
                        continue outer;
                    }
                    startR--;
                    startC++;
                    endR++;
                    endC--;
                }
                if (board[i][j] == 'O') {
                    return Result.WIN;
                } else {
                    return Result.LOSE;
                }
            }
        }

        return Result.NONE;
    }

    private enum Result {
        WIN, LOSE, NONE;
    }
}
