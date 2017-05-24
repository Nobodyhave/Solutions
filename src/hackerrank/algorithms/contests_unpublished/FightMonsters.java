package hackerrank.algorithms.contests_unpublished;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Aleksandr on 16/05/2017.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/contests/w32/challenges/fight-the-monsters
 */
public class FightMonsters {
    private static int getMaxMonsters(int n, int hit, int t, int[] h) {
        Arrays.sort(h);

        int result = 0;
        int hits = 0;
        while (result < n && hits + hitsPerMonster(h[result], hit) <= t) {
            hits += hitsPerMonster(h[result], hit);
            result++;
        }

        return result;
    }

    private static int hitsPerMonster(int health, int hit) {
        return health / hit + (health % hit != 0 ? 1 : 0);
    }

    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);
        final int n = in.nextInt();
        final int hit = in.nextInt();
        final int t = in.nextInt();
        final int[] h = new int[n];
        for (int i = 0; i < n; i++) {
            h[i] = in.nextInt();
        }

        System.out.println(getMaxMonsters(n, hit, t, h));
    }
}
