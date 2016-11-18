package hackerrank.data_structures.arrays;

/**
 * Created by Aleksandr on 17/11/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/dynamic-array
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DynamicArray {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        final int N = scanner.nextInt();
        final int Q = scanner.nextInt();

        int lastAnswer = 0;
        final List<Integer>[] sequences = (List<Integer>[]) new List[N];
        for (int q = 0; q < Q; q++) {
            final int type = scanner.nextInt();
            final int seq = scanner.nextInt();
            final int num = scanner.nextInt();

            final int index = (lastAnswer ^ seq) % N;
            if (type == 1) {
                if (sequences[index] == null) {
                    sequences[index] = new ArrayList<>();
                }
                sequences[index].add(num);
            } else {
                lastAnswer = sequences[index].get(num % sequences[index].size());
                System.out.println(lastAnswer);
            }
        }
    }
}
