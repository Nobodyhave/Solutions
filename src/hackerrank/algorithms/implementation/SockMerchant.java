package hackerrank.algorithms.implementation;

/**
 * Created by Aleksandr on 25/11/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/sock-merchant
 */

import java.util.Scanner;

public class SockMerchant {

    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);
        final int n = in.nextInt();
        final int C[] = new int[105];
        for (int i = 0; i < n; i++) {
            C[in.nextInt()]++;
        }

        int count = 0;
        for (int c : C) {
            count += c / 2;
        }

        System.out.println(count);
    }
}

