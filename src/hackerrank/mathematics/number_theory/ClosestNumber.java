package hackerrank.mathematics.number_theory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by Aleksandr on 08/12/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/closest-number
 */
public class ClosestNumber {
    public static void main(String[] args) throws FileNotFoundException {
        //final Scanner in = new Scanner(System.in);
        final Scanner in = new Scanner(new FileInputStream("C:\\Projects\\Solutions\\src\\tests.txt"));

        final int T = in.nextInt();
        for (int t = 0; t < T; t++) {
            final int a = in.nextInt();
            final int b = in.nextInt();
            final int x = in.nextInt();

            final double ab = Math.pow(a, b);
            final double div = Math.round(ab / x);
            final long result = (long) div * x;

            System.out.println(result);
        }
    }
}
