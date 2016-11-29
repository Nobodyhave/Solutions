package hackerrank.tutorial.the_10_days_of_statistics;

import Jama.Matrix;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by Aleksandr on 31/10/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/s10-multiple-linear-regression
 */
public class MultipleLinearRegression {
    public static void main(String[] args) throws FileNotFoundException {
        //final Scanner in = new Scanner(System.in);
        final Scanner in = new Scanner(new FileInputStream("C:\\Projects\\Solutions\\src\\tests.txt"));

        final int n = in.nextInt();
        final int m = in.nextInt();

        final double[][] x = new double[m][n + 1];
        final double[][] y = new double[m][1];

        for (int i = 0; i < m; i++) {
            x[i][0] = 1;
            for (int j = 1; j <= n; j++) {
                x[i][j] = in.nextDouble();
            }
            y[i][0] = in.nextDouble();
        }

        final Matrix X = new Matrix(x);
        final Matrix Y = new Matrix(y);

        final Matrix B = X.transpose().times(X).inverse().times(X.transpose()).times(Y);

        final int Q = in.nextInt();
        for (int q = 0; q < Q; q++) {
            final Matrix qY = new Matrix(1, n + 1);
            qY.set(0, 0, 1);
            for (int i = 1; i <= n; i++) {
                qY.set(0, i, in.nextDouble());
            }

            System.out.format("%.2f\n", qY.times(B).get(0, 0));
        }
    }
}
