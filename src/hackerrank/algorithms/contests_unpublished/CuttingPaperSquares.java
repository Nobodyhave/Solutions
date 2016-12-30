package hackerrank.algorithms.contests_unpublished;

/**
 * Created by Aleksandr on 30/12/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/contests/101hack42/challenges/p1-paper-cutting
 */

import java.util.Scanner;

public class CuttingPaperSquares {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        long n = in.nextLong();
        long m = in.nextLong();


        System.out.println(n * m - 1);
    }
}
