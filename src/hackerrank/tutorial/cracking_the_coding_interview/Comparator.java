package hackerrank.tutorial.cracking_the_coding_interview;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Aleksandr on 21/10/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/ctci-comparator-sorting
 */
class Player {
    String name;
    int score;

    Player(String name, int score) {
        this.name = name;
        this.score = score;
    }
}

class Checker implements java.util.Comparator<Player> {
    @Override
    public int compare(Player p1, Player p2) {
        int result = Integer.compare(p2.score, p1.score);

        if (result == 0) {
            result = p1.name.compareTo(p2.name);
        }

        return result;
    }
}

class Comparator<P> {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        Player[] player = new Player[n];
        Checker checker = new Checker();

        for (int i = 0; i < n; i++) {
            player[i] = new Player(scan.next(), scan.nextInt());
        }
        scan.close();

        Arrays.sort(player, checker);
        for (int i = 0; i < player.length; i++) {
            System.out.printf("%s %s\n", player[i].name, player[i].score);
        }
    }


}
