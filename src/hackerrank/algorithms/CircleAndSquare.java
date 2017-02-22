package hackerrank.algorithms;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by Aleksandr on 22/02/2017.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/contests/w29/challenges/a-circle-and-a-square
 */
public class CircleAndSquare {
    public static void main(String[] args) throws FileNotFoundException {
        //final Scanner in = new Scanner(System.in);
        final Scanner in = new Scanner(new FileInputStream("C:\\Projects\\Solutions\\src\\tests.txt"));
        final int w = in.nextInt();
        final int h = in.nextInt();
        final int circleX = in.nextInt() * 2;
        final int circleY = in.nextInt() * 2;
        final int r = in.nextInt() * 2;
        final int x1 = in.nextInt() * 2;
        final int y1 = in.nextInt() * 2;
        final int x3 = in.nextInt() * 2;
        final int y3 = in.nextInt() * 2;

        int x2 = (x1 + x3 + y3 - y1) / 2;
        int y2 = (y1 + y3 + x1 - x3) / 2;
        int x4 = (x1 + x3 + y1 - y3) / 2;
        int y4 = (y1 + y3 + x3 - x1) / 2;

        final Point A = new Point(x1, y1);
        final Point B = new Point(x2, y2);
        final Point C = new Point(x3, y3);
        final Point D = new Point(x4, y4);

        final Vector AB = new Vector(A, B);
        final Vector AD = new Vector(A, D);

        final int ABAB = dotProduct(AB, AB);
        final int ADAD = dotProduct(AD, AD);

        final StringBuilder sb = new StringBuilder(w * h);
        for (int y = 0; y < h * 2; y += 2) {
            for (int x = 0; x < w * 2; x += 2) {
                boolean inCircle = Math.pow(x - circleX, 2) + Math.pow(y - circleY, 2) <= Math.pow(r, 2);
                if (inCircle) {
                    sb.append('#');
                    continue;
                }
                final Point M = new Point(x, y);

                final Vector AM = new Vector(A, M);

                final int ABAM = dotProduct(AB, AM);
                final int ADAM = dotProduct(AD, AM);

                boolean inSquare = (0 <= ABAM && ABAM <= ABAB) && (0 <= ADAM && ADAM <= ADAD);

                if (inSquare) {
                    sb.append('#');
                } else {
                    sb.append('.');
                }
            }
            sb.append('\n');
        }

        System.out.println(sb.toString());
    }

    private static int dotProduct(Vector v1, Vector v2) {
        return v1.x * v2.x + v1.y * v2.y;
    }

    private static class Vector {
        private int x;
        private int y;

        public Vector(Point p1, Point p2) {
            x = p2.x - p1.x;
            y = p2.y - p1.y;
        }
    }

    private static class Point {
        private int x;
        private int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
