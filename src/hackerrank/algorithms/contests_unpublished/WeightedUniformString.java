package hackerrank.algorithms.contests_unpublished;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by Aleksandr on 10/02/2017.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/contests/world-codesprint-9/challenges/weighted-uniform-string
 */
public class WeightedUniformString {
    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);
        final String s = in.next();
        final int n = in.nextInt();

        final Set<Integer> set = new HashSet<>();
        set.add(s.charAt(0) - 'a' + 1);
        int count = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i - 1) == s.charAt(i)) {
                count++;
                set.add((s.charAt(i) - 'a' + 1) * count);
            } else {
                count = 1;
                set.add(s.charAt(i) - 'a' + 1);
            }
        }

        //System.out.println(set);

        for (int a0 = 0; a0 < n; a0++) {
            int x = in.nextInt();

            if (set.contains(x)) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }
}
