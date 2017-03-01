package hackerrank.algorithms.contests_unpublished;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Aleksandr on 21/02/2017.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/contests/w29/challenges/big-sorting
 */
public class BigSorting {
    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);
        final int n = in.nextInt();
        final String[] unsorted = new String[n];
        for (int i = 0; i < n; i++) {
            unsorted[i] = in.next();
        }

        Arrays.sort(unsorted, (o1, o2) -> {
            int result = o1.length() - o2.length();

            if (result == 0) {
                result = o1.compareTo(o2);
            }

            return result;
        });

        for (String s : unsorted) {
            System.out.println(s);
        }
    }
}
