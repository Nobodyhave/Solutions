package hackerrank.algorithms.contests_unpublished;

import java.util.Scanner;

/**
 * Created by Aleksandr on 22/06/2017.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/contests/101hack50/challenges/hard-questions
 */
public class HardQuestions {
    private static int maxScoreOfVincent(int n, String s, String t) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) != '.' && s.charAt(i) != t.charAt(i)) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);
        //  Return the maximum score of Vincent.
        final int n = in.nextInt();
        final String s = in.next();
        final String t = in.next();
        System.out.println(maxScoreOfVincent(n, s, t));
    }
}
