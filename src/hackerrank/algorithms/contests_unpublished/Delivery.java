package hackerrank.algorithms.contests_unpublished;

import java.io.FileNotFoundException;
import java.util.*;

/**
 * Created by Aleksandr on 30/12/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/contests/walmart-codesprint-algo/challenges/delivery
 */
public class Delivery {
    public static void main(String[] args) throws FileNotFoundException {
        final Scanner in = new Scanner(System.in);

        final int n = in.nextInt();
        final int m = in.nextInt();
        int Q = in.nextInt();

        final Map<Integer, List<Integer>> shops = new HashMap<>();
        for (int i = 1; i <= m; i++) {
            int count = in.nextInt();
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < count; j++) {
                list.add(in.nextInt());
            }
            shops.put(i, list);
        }

        int pos = 1;
        int fullDist = 0;
        for (int q = 0; q < Q; q++) {
            int food = in.nextInt();
            int person = in.nextInt();

            fullDist += shortestPath(shops.get(food), pos, person);
            pos = person;
        }

        System.out.println(fullDist);
    }

    private static int shortestPath(List<Integer> shops, int pos, int person) {
        int minPath = Integer.MAX_VALUE;
        for (Integer shop : shops) {
            int path = distance(pos, shop) + distance(shop, person);
            if (path < minPath) {
                minPath = path;
            }
        }

        return minPath;
    }

    private static int distance(int pos1, int pos2) {
        int dist = 0;
        while (pos1 != pos2) {
            if (pos1 > pos2) {
                pos1 = pos1 / 2;
            } else {
                pos2 = pos2 / 2;
            }
            dist++;
        }

        return dist;
    }
}
