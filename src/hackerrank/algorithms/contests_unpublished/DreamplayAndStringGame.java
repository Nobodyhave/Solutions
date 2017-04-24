package hackerrank.algorithms.contests_unpublished;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by Aleksandr on 24/04/2017.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/contests/101hack48/challenges/dreamplay-and-the-string-game
 */
public class DreamplayAndStringGame {
    private static boolean check(String s, String p, int off) {
        for (int i = 0; i < p.length(); i++) {
            if (s.charAt(i + off) != p.charAt(i)) {
                return false;
            }
        }

        return true;
    }

    private static String stringGameWinner(String s, String p) {
        int diff = s.length() - p.length();
        if (diff < 0) {
            return "Steven";
        } else if (diff == 0) {
            if(s.equals(p)) {
                return "Amanda";
            } else {
                return "Steven";
            }
        }

        if (diff % 2 == 0) {
            if (check(s, p, diff / 2) || check(s, p, diff / 2 - 1 ) && check(s, p, diff / 2 + 1)) {
                return "Amanda";
            }
        } else {
            if (check(s, p, diff / 2) && check(s, p, diff / 2 + 1)) {
                return "Amanda";
            }
        }

        return "Steven";
    }

    public static void main(String[] args) throws FileNotFoundException {
        //final Scanner in = new Scanner(System.in);
        Scanner in = new Scanner(new FileInputStream("C:\\Projects\\Solutions\\src\\tests.txt"));
        final int q = in.nextInt();
        for (int i = 0; i < q; i++) {
            final String s = in.next();
            final String p = in.next();
            final String result = stringGameWinner(s, p);
            System.out.println(result);
        }
    }
}
