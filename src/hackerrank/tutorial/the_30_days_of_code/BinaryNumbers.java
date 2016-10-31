package hackerrank.tutorial.the_30_days_of_code;

/**
 * Created by Aleksandr on 31/10/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/30-binary-numbers
 */

import java.util.Scanner;

public class BinaryNumbers {

    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        final StringBuilder sb = new StringBuilder();

        while (n != 0) {
            sb.append(n % 2);
            n /= 2;
        }
        sb.reverse();

        int count = 1;
        int maxCount = 1;
        for (int i = 1; i < sb.length(); i++) {
            if (sb.charAt(i - 1) == '1' && sb.charAt(i) == '1') {
                count++;
            } else {
                if (count > maxCount) {
                    maxCount = count;
                }
                count = 1;
            }
        }
        if (count > maxCount) {
            maxCount = count;
        }

        System.out.println(maxCount);
    }
}
