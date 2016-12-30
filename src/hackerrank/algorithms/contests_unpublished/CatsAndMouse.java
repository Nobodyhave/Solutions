package hackerrank.algorithms.contests_unpublished;

import java.util.Scanner;

/**
 * Created by Aleksandr on 30/12/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/contests/hourrank-15/challenges
 */
public class CatsAndMouse {
    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);
        final int q = in.nextInt();
        for (int a0 = 0; a0 < q; a0++) {
            int x = in.nextInt();
            int y = in.nextInt();
            int z = in.nextInt();

            if (Math.abs(x - z) < Math.abs(y - z)) {
                System.out.println("Cat A");
            } else if (Math.abs(x - z) > Math.abs(y - z)) {
                System.out.println("Cat B");
            } else {
                System.out.println("Mouse C");
            }
        }
    }
}
