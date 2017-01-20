package hackerrank.java.data_structures;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Created by Aleksandr on 20/01/2017.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/java-comparator
 */
public class JavaComparator {
    public static void main(String[] args) {
        final Scanner scan = new Scanner(System.in);
        final int n = scan.nextInt();

        final Player[] players = new Player[n];
        final Checker checker = new Checker();

        for (int i = 0; i < n; i++) {
            players[i] = new Player(scan.next(), scan.nextInt());
        }
        scan.close();

        Arrays.sort(players, checker);
        for (Player player : players) {
            System.out.printf("%s %s\n", player.name, player.score);
        }
    }

    private static class Player {
        String name;
        int score;

        Player(String name, int score) {
            this.name = name;
            this.score = score;
        }
    }

    private static class Checker implements Comparator<Player> {
        @Override
        public int compare(Player a, Player b) {
            int result = Integer.compare(b.score, a.score);

            if (result == 0) {
                result = a.name.compareTo(b.name);
            }

            return result;
        }
    }
}
