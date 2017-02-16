package hackerrank.algorithms.contests_unpublished;

import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by Aleksandr on 15/02/2017.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/contests/rookierank-2/challenges/knightl-on-chessboard
 */
public class KnightOnChessBoard {
    public static void main(String[] args) throws FileNotFoundException {
        final Scanner in = new Scanner(System.in);
        //final Scanner in = new Scanner(new FileInputStream("C:\\Projects\\Algos\\test_data.txt"));
        final int n = in.nextInt();

        final StringBuilder sb = new StringBuilder();
        for (int a = 1; a < n; a++) {
            for (int b = 1; b < n; b++) {
                int[][] board = new int[n][n];
                int[][] tempBoard = new int[n][n];

                board[0][0] = 1;
                tempBoard[0][0] = 1;

                boolean moveDone;
                do {
                    moveDone = false;
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < n; j++) {
                            moveDone |= doMove(board, tempBoard, n, i, j, i + a, j + b);
                            moveDone |= doMove(board, tempBoard, n, i, j, i + a, j - b);
                            moveDone |= doMove(board, tempBoard, n, i, j, i - a, j + b);
                            moveDone |= doMove(board, tempBoard, n, i, j, i - a, j - b);
                            moveDone |= doMove(board, tempBoard, n, i, j, i + b, j + a);
                            moveDone |= doMove(board, tempBoard, n, i, j, i + b, j - a);
                            moveDone |= doMove(board, tempBoard, n, i, j, i - b, j + a);
                            moveDone |= doMove(board, tempBoard, n, i, j, i - b, j - a);
                        }
                    }
                    int[][] temp = board;
                    board = tempBoard;
                    tempBoard = temp;
                } while (moveDone);

                if (board[n - 1][n - 1] != 0) {
                    sb.append(board[n - 1][n - 1]);
                } else {
                    sb.append(-1);
                }
                sb.append(' ');
            }
            sb.append('\n');
        }
        System.out.println(sb.toString());
    }

    private static boolean doMove(int[][] board, int[][] tempBoard, int n, int i, int j, int row, int col) {
        if (row >= 0 && row < n && col >= 0 && col < n && board[i][j] != 0 && tempBoard[row][col] == 0) {
            tempBoard[row][col] = board[i][j] + ((i == 0 && j == 0) ? 0 : 1);
            return true;
        }

        return false;
    }
}
