package hackerrank.algorithms.implementation;

import java.util.Scanner;

/**
 * Created by Aleksandr on 02/01/2017.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/encryption
 */
public class Encryption {
    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);

        final String str = in.next();
        final int l = str.length();
        final int low = (int) Math.floor(Math.sqrt(l));
        final int high = (int) Math.ceil(Math.sqrt(l));

        int row, col;
        if (low * low >= l) {
            row = low;
            col = low;
        } else if (high * low >= l) {
            row = low;
            col = high;
        } else {
            row = high;
            col = high;
        }

        final char[][] matrix = new char[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                final int ind = i * col + j;

                if (ind < l) {
                    matrix[i][j] = str.charAt(ind);
                } else {
                    matrix[i][j] = '0';
                }
            }
        }

        final StringBuilder sb = new StringBuilder();
        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                if (matrix[j][i] != '0') {
                    sb.append(matrix[j][i]);
                }
            }
            sb.append(" ");
        }

        System.out.println(sb.toString());
    }
}
