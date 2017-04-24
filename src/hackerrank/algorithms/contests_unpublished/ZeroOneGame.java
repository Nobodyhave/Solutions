package hackerrank.algorithms.contests_unpublished;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Aleksandr on 12/04/2017.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/contests/w31/challenges/zero-one-game
 */
public class ZeroOneGame {
    public static void main(String[] args) throws FileNotFoundException {
        final Scanner in = new Scanner(System.in);
        //generateTest();
        //final Scanner in = new Scanner(new FileInputStream("C:\\Projects\\Solutions\\src\\tests.txt"));
        final int G = in.nextInt();
        final StringBuilder result = new StringBuilder(G * 5);
        for (int g = 0; g < G; g++) {
            final int n = in.nextInt();
            final int[] sequence = new int[n];
            final StringBuilder sb = new StringBuilder(n);
            for (int i = 0; i < n; i++) {
                sequence[i] = in.nextInt();
                sb.append(sequence[i]);
            }

            if (sequence.length <= 2) {
                result.append("Bob").append('\n');
                continue;
            }

            final Pattern p = Pattern.compile("1{2,}");
            final Matcher m = p.matcher(sb.toString());
            final List<Integer> list = new ArrayList<>();

            while (m.find()) {
                list.add(m.start());
                list.add(m.end());
            }

            if (!list.isEmpty()) {
                if (list.get(0) == 0) {
                    list.remove(0);
                } else {
                    list.add(0, 1);
                }

                if (list.get(list.size() - 1) == n) {
                    list.remove(list.get(list.size() - 1));
                } else {
                    list.add(n - 1);
                }
            } else {
                list.add(1);
                list.add(n - 1);
            }

            int moves = 0;
            for (int i = 0; i < list.size(); i += 2) {
                moves += calculateMoves(sequence, list.get(i) - 1, list.get(i + 1));
            }

            if (moves % 2 == 0) {
                result.append("Bob").append('\n');
            } else {
                result.append("Alice").append('\n');
            }
        }
        System.out.println(result.toString());
    }

    private static int calculateMoves(int[] a, int start, int end) {
        while (a[start] != 0) {
            start++;
        }
        while (a[end] != 0) {
            end--;
        }

        return Math.max(end - start - 1, 0);
    }
}
