package hackerrank.data_structures.arrays;

/**
 * Created by Aleksandr on 17/11/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/sparse-arrays
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SparseArrays {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final Map<String, Integer> map = new HashMap<>();

        final int N = scanner.nextInt();
        for (int i = 0; i < N; i++) {
            final String str = scanner.next();

            final Integer count = map.get(str);
            if (count == null) {
                map.put(str, 1);
            } else {
                map.put(str, count + 1);
            }
        }

        final int Q = scanner.nextInt();
        for (int i = 0; i < Q; i++) {
            final String str = scanner.next();

            final Integer count = map.get(str);
            if (count == null) {
                System.out.println("0");
            } else {
                System.out.println(count);
            }
        }
    }
}
