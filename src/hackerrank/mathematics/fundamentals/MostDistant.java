package hackerrank.mathematics.fundamentals;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.Scanner;

/**
 * Created by Aleksandr on 08/12/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/most-distant
 */
public class MostDistant {
    public static void main(String[] args) throws FileNotFoundException {
        //final Scanner in = new Scanner(System.in);
        final Scanner in = new Scanner(new FileInputStream("C:\\Projects\\Solutions\\src\\tests.txt"));

        final int N = in.nextInt();
        int minX = Integer.MAX_VALUE, maxX = Integer.MIN_VALUE, minY = Integer.MAX_VALUE, maxY = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            final int x = in.nextInt();
            final int y = in.nextInt();

            minX = Math.min(x, minX);
            maxX = Math.max(x, maxX);
            minY = Math.min(y, minY);
            maxY = Math.max(y, maxY);
        }

        int dX = Math.abs(minX - maxX);
        int dY = Math.abs(minY - maxY);

        maxX = Math.max(Math.abs(minX), Math.abs(maxX));
        maxY = Math.max(Math.abs(minY), Math.abs(maxY));

        BigDecimal dXY = sqrt(new BigDecimal(Math.pow(maxX, 2) + Math.pow(maxY, 2)));

        if(dXY.compareTo(new BigDecimal(Math.max(dX, dY))) >= 0) {
            System.out.println(dXY);
        } else {
            System.out.println(Math.max(dX, dY));
        }

    }

    public static BigDecimal sqrt(BigDecimal value) {
        BigDecimal x = new BigDecimal(Math.sqrt(value.doubleValue()));
        return x.add(new BigDecimal(value.subtract(x.multiply(x)).doubleValue() / (x.doubleValue() * 2.0)));
    }
}
