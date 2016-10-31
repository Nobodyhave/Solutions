package hackerrank.tutorial.the_30_days_of_code;

/**
 * Created by Aleksandr on 26/10/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/30-arrays
 */

import java.util.Scanner;


public class Arrays {

    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);
        final int n = in.nextInt();
        final int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        in.close();

        for (int i = n - 1; i >= 0; i--) {
            System.out.print(arr[i] + " ");
        }
    }
}

