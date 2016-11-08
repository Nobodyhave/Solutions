package hackerrank.algorithms.warmup;

/**
 * Created by Aleksandr on 08/11/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/plus-minus
 */

import java.util.Scanner;

public class PlusMinus {

    public static void main(String[] args) {
        final Scanner s = new Scanner(System.in);
        final int size = s.nextInt();
        final int[] counts = new int[3];

        for (int i = 0; i < size; i++) {
            final int num = s.nextInt();
            if (num < 0) {
                counts[1]++;
            } else if (num > 0) {
                counts[0]++;
            } else {
                counts[2]++;
            }
        }
        s.close();

        for (int count : counts) {
            System.out.println(count / (double) size);
        }
    }
}
