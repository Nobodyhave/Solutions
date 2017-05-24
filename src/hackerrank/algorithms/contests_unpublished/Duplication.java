package hackerrank.algorithms.contests_unpublished;

import java.util.Scanner;

/**
 * Created by Aleksandr on 15/05/2017.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/contests/w32/challenges/duplication
 */
public class Duplication {
    private static int duplication(StringBuilder sb, int x) {
        return sb.charAt(x) - '0';
    }

    private static StringBuilder reverse(StringBuilder sb) {
        final StringBuilder reverse = new StringBuilder(sb);

        for (int i = 0; i < sb.length(); i++) {
            if (reverse.charAt(i) == '0') {
                reverse.setCharAt(i, '1');
            } else {
                reverse.setCharAt(i, '0');
            }
        }

        return reverse;
    }

    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);
        final int Q = in.nextInt();

        final StringBuilder sb = new StringBuilder("0");
        while (sb.length() <= 1000) {
            sb.append(reverse(sb));
        }

        for (int q = 0; q < Q; q++) {
            final int x = in.nextInt();
            System.out.println(duplication(sb, x));
        }
    }
}
