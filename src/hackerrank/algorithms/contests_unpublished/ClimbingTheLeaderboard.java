package hackerrank.algorithms.contests_unpublished;

import java.util.Scanner;

/**
 * Created by Aleksandr on 30/12/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/contests/world-codesprint-8/challenges/climbing-the-leaderboard
 */
public class ClimbingTheLeaderboard {
    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);
        final int n = in.nextInt();
        final int[] scores = new int[n];
        for (int scores_i = 0; scores_i < n; scores_i++) {
            scores[scores_i] = in.nextInt();
        }

        int m = in.nextInt();
        int[] alice = new int[m];
        for (int alice_i = 0; alice_i < m; alice_i++) {
            alice[alice_i] = in.nextInt();
        }

        int[] places = new int[n];
        places[0] = 1;
        for (int i = 1; i < n; i++) {
            if (scores[i] != scores[i - 1]) {
                places[i] = places[i - 1] + 1;
            } else {
                places[i] = places[i - 1];
            }
        }

        int topIndex = n - 1;
        outer:
        for (int i = 0; i < m; i++) {
            boolean isFound = false;
            for (int j = topIndex; j >= 0; j--) {
                if (alice[i] < scores[j]) {
                    System.out.println(places[j] + 1);
                    topIndex = j;
                    continue outer;
                } else if (alice[i] == scores[j]) {
                    isFound = true;
                    topIndex = j - 1;
                }
            }

            if (isFound) {
                System.out.println(places[topIndex + 1]);
            } else {
                System.out.println(1);
            }
        }
    }
}
