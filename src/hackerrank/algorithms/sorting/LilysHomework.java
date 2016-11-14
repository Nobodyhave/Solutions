package hackerrank.algorithms.sorting;

/**
 * Created by Aleksandr on 14/11/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/lilys-homework
 */

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LilysHomework {

    public static void main(String[] args) throws FileNotFoundException {
        final Scanner in = new Scanner(System.in);

        final int N = in.nextInt();

        final int[] a = new int[N];
        final Integer[] b = new Integer[N];
        final Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            a[i] = in.nextInt();
            b[i] = a[i];
            map.put(a[i], i);
        }

        Arrays.sort(a);
        Arrays.sort(b, (i1, i2) -> Integer.compare(i2, i1));

        int count1 = 0, count2 = 0;
        for (int i = 0; i < N; i++) {
            if (i != map.get(a[i])) {
                swap(a, i, map.get(a[i]));
                count1++;
                i--;
            }
        }

        for (int i = 0; i < N; i++) {
            if (i != map.get(b[i])) {
                swap(b, i, map.get(b[i]));
                count2++;
                i--;
            }
        }

        System.out.print(Math.min(count1, count2));
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private static void swap(Integer[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
