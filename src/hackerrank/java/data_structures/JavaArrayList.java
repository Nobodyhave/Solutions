package hackerrank.java.data_structures;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Aleksandr on 19/01/2017.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/java-arraylist
 */
public class JavaArrayList {
    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);
        final int N = in.nextInt();

        final List<Integer>[] lists = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            final int D = in.nextInt();
            lists[i] = new ArrayList<>();

            for (int d = 0; d < D; d++) {
                lists[i].add(in.nextInt());
            }
        }

        final int Q = in.nextInt();
        for (int q = 0; q < Q; q++) {
            final int x = in.nextInt() - 1;
            final int y = in.nextInt() - 1;
            if (lists[x].size() > y) {
                System.out.println(lists[x].get(y));
            } else {
                System.out.println("ERROR!");
            }
        }
    }
}
