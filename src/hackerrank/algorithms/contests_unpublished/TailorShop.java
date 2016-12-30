package hackerrank.algorithms.contests_unpublished;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Aleksandr on 30/12/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/contests/w27/challenges/tailor-shop
 */
public class TailorShop {
    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);
        final int n = in.nextInt();
        final int p = in.nextInt();
        final int[] a = new int[n];
        for (int a_i = 0; a_i < n; a_i++) {
            a[a_i] = in.nextInt();
        }

        Arrays.sort(a);

        long lastCount = 0;
        long totalCount = 0;
        for (int i = 0; i < n; i++) {
            long buttons;
            if (a[i] % p == 0) {
                buttons = a[i] / p;
            } else {
                buttons = (a[i] / p) + 1;
            }

            if (buttons <= lastCount) {
                buttons = lastCount + 1;
            }
            lastCount = buttons;
            totalCount += lastCount;
        }

        System.out.println(totalCount);
    }
}
