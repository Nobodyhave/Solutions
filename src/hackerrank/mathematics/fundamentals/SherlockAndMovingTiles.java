package hackerrank.mathematics.fundamentals;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by Aleksandr on 05/12/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/sherlock-and-moving-tiles
 */
public class SherlockAndMovingTiles {
    public static void main(String[] args) throws FileNotFoundException {
        //final Scanner in = new Scanner(System.in);
        final Scanner in = new Scanner(new FileInputStream("C:\\Projects\\Solutions\\src\\tests.txt"));

        final double L = in.nextDouble();
        final double S1 = in.nextDouble();
        final double S2 = in.nextDouble();

        final int Q = in.nextInt();
        for (int q = 0; q < Q; q++) {
            final double s = in.nextDouble();

            final double l = Math.sqrt(s);
            final double L1 = Math.sqrt(2 * Math.pow(L, 2));
            final double L2 = Math.sqrt(2 * Math.pow(l, 2));
            final double dL = Math.abs(L1 - L2);

            final double t = dL / Math.abs(S1-S2);

            System.out.format("%.20f\n", t);
        }
    }
}
