package hackerrank.algorithms.contests_unpublished;

import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by Aleksandr on 30/12/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/contests/w27/challenges/hackonacci-matrix-rotations
 */

public class HackonacciMatrixRotations {
    public static void main(String[] args) throws FileNotFoundException {
        final Scanner in = new Scanner(System.in);
        //final Scanner in = new Scanner(new FileInputStream("C:\\Projects\\Solutions\\src\\tests.txt"));
        final int n = in.nextInt();
        final int Q = in.nextInt();

        final char[][] matrix = new char[n][n];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                long result = (long) Math.pow(i * j, 2);
                if (result % 7 == 2 || result % 7 == 4 || result % 7 == 5) {
                    matrix[i - 1][j - 1] = 'X';
                } else {
                    matrix[i - 1][j - 1] = 'Y';
                }
            }
        }

        final char[][] rotatedMatrix = copyMatrix(matrix);
        rotateMatrix(rotatedMatrix);
        int count90 = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] != rotatedMatrix[i][j]) {
                    count90++;
                }
            }
        }

        rotateMatrix(rotatedMatrix);
        int count180 = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] != rotatedMatrix[i][j]) {
                    count180++;
                }
            }
        }

        rotateMatrix(rotatedMatrix);
        int count270 = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] != rotatedMatrix[i][j]) {
                    count270++;
                }
            }
        }

        for (int q = 0; q < Q; q++) {
            int angle = in.nextInt();

            if (angle % 360 == 0) {
                System.out.println(0);
            } else if (angle % 360 == 90) {
                System.out.println(count90);
            } else if (angle % 360 == 180) {
                System.out.println(count180);
            } else {
                System.out.println(count270);
            }
        }

    }

    private static char[][] copyMatrix(char[][] board) {
        char[][] newBoard = new char[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {
            System.arraycopy(board[i], 0, newBoard[i], 0, board[0].length);
        }

        return newBoard;
    }

    private static void rotateMatrix(char[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return;
        }

        int layers = (matrix.length - 1) / 2 + 1;

        for (int i = 0; i < layers; i++) {
            int sideLength = matrix.length - i * 2;
            for (int j = 0; j < sideLength - 1; j++) {
                int firstR = i;
                int firstC = i + j;
                int secondR = i + j;
                int secondC = sideLength - 1 + i;
                int thirdR = sideLength - 1 + i;
                int thirdC = sideLength - 1 + i - j;
                int fourthR = sideLength - 1 + i - j;
                int fourthC = i;

                char temp = matrix[firstR][firstC];
                matrix[firstR][firstC] = matrix[fourthR][fourthC];
                matrix[fourthR][fourthC] = matrix[thirdR][thirdC];
                matrix[thirdR][thirdC] = matrix[secondR][secondC];
                matrix[secondR][secondC] = temp;
            }
        }
    }
}
