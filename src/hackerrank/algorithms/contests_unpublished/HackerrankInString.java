package hackerrank.algorithms.contests_unpublished;

import java.util.Scanner;

/**
 * Created by Aleksandr on 15/02/2017.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/contests/rookierank-2/challenges/hackerrank-in-a-string
 */
public class HackerrankInString {
    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);
        final int q = in.nextInt();
        final String letters = "hackerrank";
        outer:
        for (int a0 = 0; a0 < q; a0++) {
            final String s = in.next();
            int index = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == letters.charAt(index)) {
                    index++;
                }
                if (index >= letters.length()) {
                    System.out.println("YES");
                    continue outer;
                }
            }
            System.out.println("NO");
        }
    }
}
