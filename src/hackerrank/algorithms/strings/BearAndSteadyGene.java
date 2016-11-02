package hackerrank.algorithms.strings;

/**
 * Created by Aleksandr on 01/11/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/bear-and-steady-gene
 */

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BearAndSteadyGene {

    public static void main(String[] args) throws FileNotFoundException {
        final Scanner in = new Scanner(System.in);

        final int N = in.nextInt();
        final String s = in.next();

        final Map<Character, Integer> map = new HashMap<>();
        map.put('A', 0);
        map.put('C', 0);
        map.put('G', 0);
        map.put('T', 0);
        for (int i = 0; i < N; i++) {
            final char c = s.charAt(i);
            map.put(c, map.get(c) + 1);
        }

        final int balance = N / 4;
        for (Character c : map.keySet()) {
            int count = map.get(c);
            if (count > balance) {
                map.put(c, count - balance);
            } else {
                map.put(c, 0);
            }
        }

        map.values().removeIf(v -> v == 0);

        if (map.isEmpty()) {
            System.out.println(0);
            return;
        }

        int start = 0, end = 0, minLength = Integer.MAX_VALUE;

        char c = s.charAt(end);
        if (map.containsKey(c)) {
            map.put(c, map.get(c) - 1);
        }

        while (start < N) {
            int mapSum = getMapSum(map);

            if (mapSum == 0 || end == N - 1) {
                if (end - start + 1 < minLength && mapSum == 0) {
                    minLength = end - start + 1;
                }
                c = s.charAt(start);
                if (map.containsKey(c)) {
                    map.put(c, map.get(c) + 1);
                }
                start++;
            } else {
                end++;
                c = s.charAt(end);
                if (map.containsKey(c)) {
                    map.put(c, map.get(c) - 1);
                }
            }
        }

        System.out.println(minLength);
    }

    private static int getMapSum(Map<Character, Integer> map) {
        return map.values().stream().filter(v -> v > 0).reduce(0, (i1, i2) -> i1 + i2);
    }
}
