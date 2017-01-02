package hackerrank.algorithms.implementation;

import java.util.Scanner;

/**
 * Created by Aleksandr on 02/01/2017.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/bigger-is-greater
 */
public class BiggerIsGreater {
    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();

        for (int t = 0; t < T; t++) {
            final String s = in.next();
            final char[] letters = s.toCharArray();
            int p = -1, q = -1;
            for (int i = s.length() - 2; i >= 0; i--) {
                if (letters[i] < letters[i + 1]) {
                    p = i;
                    break;
                }
            }
            if (p == -1) {
                System.out.println("no answer");
                continue;
            }
            for (int i = s.length() - 1; i > p; i--) {
                if (letters[i] > letters[p]) {
                    q = i;
                    break;
                }
            }
            char temp = letters[p];
            letters[p] = letters[q];
            letters[q] = temp;

            int start = p + 1, end = letters.length - 1;
            while (start < end) {
                temp = letters[start];
                letters[start] = letters[end];
                letters[end] = temp;
                start++;
                end--;
            }
            System.out.println(new String(letters));
        }
    }
}
