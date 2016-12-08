package hackerrank.mathematics.fundamentals;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by Aleksandr on 07/12/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/die-hard-3
 */
public class DieHard3 {
    public static void main(String[] args) throws FileNotFoundException {
        //final Scanner in = new Scanner(System.in);
        final Scanner in = new Scanner(new FileInputStream("C:\\Projects\\Solutions\\src\\tests.txt"));

        final int T = in.nextInt();
        for (int t = 0; t < T; t++) {
            final int a = in.nextInt();
            final int b = in.nextInt();
            final int c = in.nextInt();

            if (c % gcd(a, b) == 0 && c < Math.max(a, b)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    private static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
