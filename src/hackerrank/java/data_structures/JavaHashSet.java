package hackerrank.java.data_structures;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by Aleksandr on 20/01/2017.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/java-hashset
 */
public class JavaHashSet {
    public static void main(String[] args) {
        final Scanner s = new Scanner(System.in);
        final int N = s.nextInt();
        final String[] pairLeft = new String[N];
        final String[] pairRight = new String[N];

        for (int i = 0; i < N; i++) {
            pairLeft[i] = s.next();
            pairRight[i] = s.next();
        }

        final Set<String> set = new HashSet<>();

        for (int i = 0; i < N; i++) {
            set.add(pairLeft[i] + " " + pairRight[i]);
            System.out.println(set.size());
        }
    }
}
