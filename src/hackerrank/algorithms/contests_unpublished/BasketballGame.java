package hackerrank.algorithms.contests_unpublished;

import java.awt.*;
import java.awt.geom.Point2D;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by Aleksandr on 22/03/2017.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/contests/101hack47/challenges/basketball-game
 */
public class BasketballGame {
    public static void main(String[] args) throws FileNotFoundException {
        final Scanner in = new Scanner(System.in);
        //final Scanner in = new Scanner(new FileInputStream("C:\\Projects\\Algos\\test_data.txt"));
        final int T = in.nextInt();
        for (int t = 0; t < T; t++) {
            int xHoop = in.nextInt();
            int yHoop = in.nextInt();
            int xC = in.nextInt();
            int yC = in.nextInt();
            int sC = in.nextInt();

            int dX = Math.abs(xHoop - xC);
            int dY = Math.abs(yHoop - yC);
            double dist = Math.sqrt(Math.pow(dX, 2) + Math.pow(dY, 2));
            double time = dist / sC;

            boolean intercepts = false;
            final Point.Double[] players = new Point2D.Double[5];
            final int[] speeds = new int[5];
            for (int a1 = 0; a1 < 5; a1++) {
                int x = in.nextInt();
                int y = in.nextInt();
                int s = in.nextInt();

                players[a1] = new Point2D.Double(x, y);
                speeds[a1] = s;
            }

            if (dX != 0 || dY != 0) {
                double delta = time / 10000.0;
                outer:
                for (double i = 0; i <= time; i += delta) {
                    double percent = i / time;
                    double x = xC + (xHoop - xC) * percent;
                    double y = yC + (yHoop - yC) * percent;
                    for (int j = 0; j < 5; j++) {
                        double radius = Math.pow(speeds[j] * i, 2);
                        double circle = Math.pow(players[j].x - x, 2) + Math.pow(players[j].y - y, 2);
                        if (circle < radius || (circle == radius && x != xHoop && y != yHoop)) {
                            intercepts = true;
                            break outer;
                        }
                    }
                }
            }

            if (!intercepts) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
