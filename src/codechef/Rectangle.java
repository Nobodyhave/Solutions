package codechef;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Aleksandr on 05/01/2018.
 * Project Solutions
 * <p>
 * https://www.codechef.com/JAN18/problems/RECTANGL
 */
public class Rectangle {
    public static void main(String[] args) throws java.lang.Exception {
        final Scanner in = new Scanner(System.in);

        final int T = in.nextInt();
        for (int t = 0; t < T; t++) {
            final int[] sides = new int[]{in.nextInt(), in.nextInt(), in.nextInt(), in.nextInt()};
            Arrays.sort(sides);

            if (sides[0] == sides[1] && sides[2] == sides[3]) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }

        in.close();
    }
}
