package hackerrank.algorithms.contests_unpublished;

import java.util.Scanner;

/**
 * Created by Aleksandr on 18/01/2017.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/contests/101hack45/challenges/mlp
 */
public class MinimumEdgesInLayeredGraph {
    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);
        final int n = in.nextInt();
        final int k = in.nextInt();

        if (k > n || (k == 2 && n > 2)) {
            System.out.println("-1");
        } else if (k == n) {
            System.out.println(k - 1);
        } else {
            System.out.println(k - 1 + (n - k) * 2);
        }
    }
}
