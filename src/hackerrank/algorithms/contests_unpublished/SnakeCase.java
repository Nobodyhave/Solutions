package hackerrank.algorithms.contests_unpublished;

import java.util.Scanner;

/**
 * Created by Aleksandr on 30/12/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/contests/world-codesprint-8/challenges/snake-case
 */
public class SnakeCase {
    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);
        final String s = in.next();

        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '_') {
                count++;
            }
        }

        System.out.println(count + 1);
    }
}
