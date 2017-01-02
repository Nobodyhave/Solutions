package hackerrank.algorithms.implementation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Aleksandr on 02/01/2017.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/absolute-permutation
 */
public class AbsolutePermutation {
    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();
        for (int t = 0; t < T; t++) {
            final int n = in.nextInt();
            final int k = in.nextInt();

            final HashSet<Integer> set = new HashSet<>();
            for (int i = 1; i <= n; i++) {
                set.add(i);
            }

            final List<Integer> result = new ArrayList<>();
            for (int i = 1; i <= n; i++) {
                if (set.contains(i - k)) {
                    result.add(i - k);
                    set.remove(i - k);
                } else if (set.contains(i + k)) {
                    result.add(i + k);
                    set.remove(i + k);
                } else {
                    break;
                }
            }

            if (result.size() == n) {
                for (Integer num : result) {
                    System.out.print(num + " ");
                }
                System.out.println();
            } else {
                System.out.println("-1");
            }
        }
    }
}
