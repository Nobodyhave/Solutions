package hackerrank.algorithms.implementation;

import java.util.Scanner;
import java.util.TreeSet;

/**
 * Created by Aleksandr on 02/01/2017.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/flatland-space-stations
 */
public class FlatlandSpaceStations {
    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);

        final int n = in.nextInt();
        final int m = in.nextInt();

        final TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < m; i++) {
            set.add(in.nextInt());
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            if (!set.contains(i)) {
                final Integer left = set.lower(i);
                final Integer right = set.higher(i);
                int dist;

                if (left == null) {
                    dist = right - i;
                } else if (right == null) {
                    dist = i - left;
                } else {
                    dist = Math.min(i - left, right - i);
                }

                if (dist > max) {
                    max = dist;
                }
            }
        }

        System.out.println(max);
    }
}
