package hackerrank.tutorial.cracking_the_coding_interview;

/**
 * Created by Aleksandr on 25/10/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/ctci-lonely-integer
 */

import java.util.Scanner;

public class LonelyInteger {

    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);
        final int n = in.nextInt();
        int res = 0;
        for (int i = 0; i < n; i++) {
            res ^= in.nextInt();
        }
        System.out.println(res);
    }
}

