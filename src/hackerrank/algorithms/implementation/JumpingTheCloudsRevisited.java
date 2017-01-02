package hackerrank.algorithms.implementation;

import java.util.Scanner;

/**
 * Created by Aleksandr on 02/01/2017.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/jumping-on-the-clouds-revisited
 */
public class JumpingTheCloudsRevisited {
    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);
        final int n = in.nextInt();
        final int k = in.nextInt();
        final int c[] = new int[n];
        for (int c_i = 0; c_i < n; c_i++) {
            c[c_i] = in.nextInt();
        }

        int pos = 0;
        int E = 100;
        do {
            E--;
            pos = (pos + k) % n;
            if (c[pos] == 1) {
                E -= 2;
            }
        } while (pos != 0);

        System.out.println(E);
    }
}
