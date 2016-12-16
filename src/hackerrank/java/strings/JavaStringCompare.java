package hackerrank.java.strings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Aleksandr on 13/12/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/java-string-compare
 */
public class JavaStringCompare {
    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);

        final String s = in.next();
        final int k = in.nextInt();

        final List<String> subStrings = new ArrayList<>();
        for (int i = 0; i < s.length() - k + 1; i++) {
            subStrings.add(s.substring(i, i + k));
        }

        Collections.sort(subStrings);
        System.out.println(subStrings.get(0));
        System.out.println(subStrings.get(subStrings.size() - 1));
    }
}
