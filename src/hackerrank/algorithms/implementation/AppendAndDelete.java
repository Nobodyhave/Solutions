package hackerrank.algorithms.implementation;

import java.util.Scanner;

/**
 * Created by Aleksandr on 30/12/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/append-and-delete
 */
public class AppendAndDelete {
    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);
        final String s = in.next();
        final String t = in.next();
        int k = in.nextInt();
        final int sL = s.length();
        final int tL = t.length();

        int lastCommon = -1;
        while (lastCommon + 1 < sL && lastCommon + 1 < tL && s.charAt(lastCommon + 1) == t.charAt(lastCommon + 1)) {
            lastCommon++;
        }

        if (lastCommon == -1) { // If strings are different
            if (k >= tL + sL) { // If k more then target lenght and remainder is even
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        } else {
            int sDiff = sL - lastCommon - 1;
            int tDiff = tL - lastCommon - 1;
            if (k >= tL + sL) {
                System.out.println("Yes");
            } else if (k >= sDiff + tDiff && (k - sDiff - tDiff) % 2 == 0) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }
}
