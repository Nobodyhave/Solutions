package hackerrank.tutorial.cracking_the_coding_interview;

/**
 * Created by Aleksandr on 19/10/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/ctci-ransom-note
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class RansomNote {

    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);
        final int m = in.nextInt();
        final int n = in.nextInt();

        final Map<String, Integer> magazine = new HashMap<>();
        for (int i = 0; i < m; i++) {
            final String word = in.next();
            final Integer count = magazine.get(word);
            if (count == null) {
                magazine.put(word, 1);
            } else {
                magazine.put(word, count + 1);
            }
        }

        String ransom[] = new String[n];
        for (int i = 0; i < n; i++) {
            final String word = in.next();
            final Integer count = magazine.get(word);
            if (count == null || count == 0) {
                System.out.println("No");
                return;
            } else {
                magazine.put(word, count - 1);
            }
        }

        System.out.println("Yes");
    }
}

