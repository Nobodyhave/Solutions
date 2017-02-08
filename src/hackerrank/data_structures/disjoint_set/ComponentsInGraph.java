package hackerrank.data_structures.disjoint_set;

import java.util.*;

/**
 * Created by Aleksandr on 08/02/2017.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/components-in-graph
 */
public class ComponentsInGraph {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        final int N = scanner.nextInt();
        final List<Integer>[] vertices = (List<Integer>[]) new List[2 * N + 1];
        final boolean[] marked = new boolean[2 * N + 1];
        final int[] ids = new int[2 * N + 1];

        for (int i = 1; i <= 2 * N; i++) {
            vertices[i] = new ArrayList<>();
        }

        for (int i = 0; i < N; i++) {
            final int v = scanner.nextInt();
            final int w = scanner.nextInt();
            vertices[v].add(w);
            vertices[w].add(v);
        }

        int id = 0;
        for (int i = 1; i <= 2 * N; i++) {
            if (!marked[i]) {
                id++;
                final Queue<Integer> queue = new ArrayDeque<>();
                marked[i] = true;
                ids[i] = id;
                queue.add(i);

                while (!queue.isEmpty()) {
                    final int cur = queue.poll();
                    for (Integer w : vertices[cur]) {
                        if (!marked[w]) {
                            marked[w] = true;
                            ids[w] = id;
                            queue.add(w);
                        }
                    }
                }
            }
        }


        Arrays.sort(ids);
        int count = 1;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 2; i <= 2 * N; i++) {
            if (ids[i - 1] == ids[i]) {
                count++;
            } else {
                if (count < min && count > 1) {
                    min = count;
                }
                if (count > max) {
                    max = count;
                }
                count = 1;
            }
        }

        System.out.println(min + " " + max);
    }
}
