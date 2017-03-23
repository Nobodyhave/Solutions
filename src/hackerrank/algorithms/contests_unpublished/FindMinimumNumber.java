package hackerrank.algorithms.contests_unpublished;

import java.util.Scanner;

/**
 * Created by Aleksandr on 14/03/2017.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/contests/w30/challenges/find-the-minimum-number
 */
public class FindMinimumNumber {
    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);
        final int n = in.nextInt();

        final StringBuilder sb = new StringBuilder("min(int, int)");
        for (int i = 2; i < n; i++) {
            sb.insert(0, "min(int, ");
            sb.append(')');
        }

        System.out.println(sb.toString());
    }
}
