package hackerrank.java.data_structures;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Aleksandr on 19/01/2017.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/java-list
 */
public class JavaList {
    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);

        final int N = in.nextInt();
        final List<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            list.add(in.nextInt());
        }

        final int Q = in.nextInt();
        for (int q = 0; q < Q; q++) {
            final String query = in.next();
            if ("Insert".equals(query)) {
                list.add(in.nextInt(), in.nextInt());
            } else {
                list.remove(in.nextInt());
            }
        }

        for (Integer i : list) {
            System.out.print(i + " ");
        }
    }
}
