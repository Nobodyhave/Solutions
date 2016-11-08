package hackerrank.algorithms.warmup;

/**
 * Created by Aleksandr on 08/11/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/staircase
 */

import java.util.Scanner;

public class Staircase {

    public static void main(String[] args) {
        final int size = new Scanner(System.in).nextInt();

        for (int i = size; i > 0; i--) {
            final StringBuilder sb = new StringBuilder();
            for (int j = 1; j < size + 1; j++) {
                if (j < i) {
                    sb.append(" ");
                } else {
                    sb.append("#");
                }
            }
            System.out.println(sb.toString());
        }
    }
}
