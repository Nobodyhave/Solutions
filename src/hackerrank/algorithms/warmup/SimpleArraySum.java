package hackerrank.algorithms.warmup;

/**
 * Created by Aleksandr on 08/11/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/simple-array-sum
 */

import java.util.Scanner;

public class SimpleArraySum {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final int size = scanner.nextInt();
        scanner.close();

        int sum = 0;
        for (int i = 0; i < size; i++) {
            sum += scanner.nextInt();
        }
        System.out.println(sum);
    }
}
