package hackerrank.algorithms.warmup;

/**
 * Created by Aleksandr on 08/11/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/a-very-big-sum
 */

import java.util.Scanner;

public class VeryBigSum {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        scanner.close();

        long sum = 0;
        for (int i = 0; i < size; i++) {
            sum += scanner.nextInt();
        }

        System.out.println(sum);
    }
}
