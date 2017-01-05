package hackerrank.algorithms.contests_unpublished;

import java.util.Scanner;

/**
 * Created by Aleksandr on 03/01/2017.
 * Project Solutions
 *
 * https://www.hackerrank.com/contests/hourrank-16/challenges/leonardo-and-lucky-numbers
 */
public class LuckyNumbers {
    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);
        final int Q = in.nextInt();
        for(int q = 0; q < Q; q++){
            final long n = in.nextLong();

            if(n == 1 || n == 2 || n == 3 || n == 5 || n == 6 || n == 9 || n == 10 || n == 13 || n == 17) {
                System.out.println("No");
            } else {
                System.out.println("Yes");
            }
        }
    }
}
