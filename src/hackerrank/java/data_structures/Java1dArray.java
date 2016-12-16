package hackerrank.java.data_structures;

import java.util.Scanner;

/**
 * Created by Aleksandr on 16/12/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/java-1d-array-introduction
 */
public class Java1dArray {
    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);
        final int n = in.nextInt();

        final int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            final int val = in.nextInt();
            a[i] = val;
        }

        in.close();

        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
}
