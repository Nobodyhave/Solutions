package codechef;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by Aleksandr on 01/12/2017.
 * Project Solutions
 * <p>
 * https://www.codechef.com/DEC17/problems/CPLAY
 */
public class PenaltyShootOut {
    public static void main(String[] args) throws IOException {
        //final Scanner in = new Scanner(System.in);
        final Scanner in = new Scanner(new FileInputStream("C:\\Projects\\Solutions\\src\\tests.txt"));

        String s;
        outer:
        while (in.hasNextLine()) {
            s = in.nextLine();
            int scoreA = 0, scoreB = 0;
            for (int i = 1; i <= s.length(); i++) {
                if ((i & 1) != 0) { // Team A
                    scoreA += s.charAt(i - 1) == '1' ? 1 : 0;
                } else { // Team B
                    scoreB += s.charAt(i - 1) == '1' ? 1 : 0;
                }

                if (i < 10) { // Main series ongoing
                    if ((10 - i + 1) / 2 < scoreA - scoreB) {
                        System.out.format("TEAM-A %d\n", i);
                        continue outer;
                    } else if ((10 - i) / 2 < scoreB - scoreA) {
                        System.out.format("TEAM-B %d\n", i);
                        continue outer;
                    }
                } else if (i == 10) { // Main series ended
                    if (scoreA > scoreB) {
                        System.out.format("TEAM-A %d\n", i);
                        continue outer;
                    } else if (scoreB > scoreA) {
                        System.out.format("TEAM-B %d\n", i);
                        continue outer;
                    }
                } else { // Sudden death
                    if ((i & 1) == 0) {
                        if (scoreA > scoreB) {
                            System.out.format("TEAM-A %d\n", i);
                            continue outer;
                        } else if (scoreB > scoreA) {
                            System.out.format("TEAM-B %d\n", i);
                            continue outer;
                        }
                    }
                }
            }
            System.out.println("TIE");
        }
    }
}
