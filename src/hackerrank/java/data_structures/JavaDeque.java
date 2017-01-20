package hackerrank.java.data_structures;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by Aleksandr on 20/01/2017.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/java-dequeue
 */
public class JavaDeque {
    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);
        final int n = in.nextInt();
        final int m = in.nextInt();

        final int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }

        final Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < m; i++) {
            Integer num = map.get(a[i]);
            if(num == null) {
                map.put(a[i], 1);
            } else {
                map.put(a[i], num + 1);
            }
        }

        int max = map.size();
        for(int i = 1; i <= n - m; i++) {
            Integer numP = map.get(a[i-1]);
            if(numP - 1 == 0) {
                map.remove(a[i-1]);
            } else {
                map.put(a[i-1], numP - 1);
            }

            Integer num = map.get(a[i + m - 1]);
            if(num == null) {
                map.put(a[i + m - 1], 1);
            } else {
                map.put(a[i + m - 1], num + 1);
            }

            max = Math.max(max, map.size());
        }

        System.out.println(max);
    }
}
