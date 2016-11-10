package hackerrank.algorithms.implementation;

/**
 * Created by Aleksandr on 08/11/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/equality-in-a-array
 */

import java.util.Arrays;
import java.util.Scanner;

public class EqualizeTheArray {

    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);

        final int n = in.nextInt();

        final int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        Arrays.sort(arr);

        int modCount = 1;
        int maxCount = modCount;
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] == arr[i + 1]) {
                modCount++;
            } else {
                if (modCount >= maxCount) {
                    maxCount = modCount;
                }
                modCount = 1;
            }
        }
        if (modCount >= maxCount) {
            maxCount = modCount;
        }

        System.out.println(n - maxCount);
    }
}
