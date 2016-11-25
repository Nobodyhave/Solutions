package hackerrank.algorithms.implementation;

/**
 * Created by Aleksandr on 25/11/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/bon-appetit
 */

import java.util.Scanner;

public class BonAppetit {

    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);

        final int n = in.nextInt();
        final int k = in.nextInt();
        int sum = 0;
        for (int i = 0; i < n; i++) {
            int num = in.nextInt();
            if (i != k) {
                sum += num;
            }
        }
        int bCharged = in.nextInt();
        int bActual = sum / 2;

        if (bCharged - bActual == 0) {
            System.out.println("Bon Appetit");
        } else {
            System.out.println(bCharged - bActual);
        }
    }
}
