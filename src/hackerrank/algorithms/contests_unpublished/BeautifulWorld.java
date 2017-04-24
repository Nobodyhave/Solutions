package hackerrank.algorithms.contests_unpublished;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by Aleksandr on 10/04/2017.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/contests/w31/challenges/beautiful-word
 */
public class BeautifulWorld {
    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);
        final String w = in.next();

        final Set<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        vowels.add('y');

        for (int i = 1; i < w.length(); i++) {
            final char prev = w.charAt(i - 1);
            final char cur = w.charAt(i);

            if (prev == cur || (vowels.contains(prev) && vowels.contains(cur))) {
                System.out.println("No");
                return;
            }
        }

        System.out.println("Yes");
    }
}
