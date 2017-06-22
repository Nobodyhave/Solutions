package hackerrank.algorithms.contests_unpublished;

import java.util.Scanner;

/**
 * Created by Aleksandr on 22/06/2017.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/contests/w33/challenges/pattern-count
 */
public class PatternCount {
    private static int patternCount(String s) {
        boolean isOpen = false;
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            final char c = s.charAt(i);

            if (c == '1') {
                if (i != 0 && s.charAt(i - 1) == '0' && isOpen) {
                    count++;
                }
                isOpen = true;
            } else if (c == '0') {
                // Continue
            } else {
                isOpen = false;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);
        final int q = in.nextInt();
        for (int i = 0; i < q; i++) {
            final String s = in.next();
            System.out.println(patternCount(s));
        }
    }
}
