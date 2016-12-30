package hackerrank.algorithms.contests_unpublished;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;
import java.awt.geom.Line2D;
import java.awt.geom.PathIterator;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by Aleksandr on 30/12/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/contests/ncr-codesprint/challenges/area-of-triangles
 */
public class AreasOfTriangles {
    public static void main(String[] args) throws FileNotFoundException {
        final Scanner in = new Scanner(System.in);
        //final Scanner in = new Scanner(new FileInputStream("C:\\Projects\\Training\\src\\problemsolving\\test_data.txt"));

        final int n = in.nextInt();

        final Area[] shapes = new Area[n];
        for (int i = 0; i < n; i++) {
            final int x1 = in.nextInt();
            final int y1 = in.nextInt();
            final int x2 = in.nextInt();
            final int y2 = in.nextInt();
            final int x3 = in.nextInt();
            final int y3 = in.nextInt();

            shapes[i] = new Area(new Polygon(new int[]{x1, x2, x3}, new int[]{y1, y2, y3}, 3));
        }

        Area result = shapes[0];
        for (int i = 1; i < n; i++) {
            result.add(shapes[i]);
        }
        PathIterator i = result.getPathIterator(AffineTransform.getQuadrantRotateInstance(0));

        double a = 0.0;
        double[] coords = new double[6];
        double startX = Double.NaN, startY = Double.NaN;
        Line2D segment = new Line2D.Double(Double.NaN, Double.NaN, Double.NaN, Double.NaN);
        while (!i.isDone()) {
            int segType = i.currentSegment(coords);
            double x = coords[0], y = coords[1];
            switch (segType) {
                case PathIterator.SEG_CLOSE:
                    segment.setLine(segment.getX2(), segment.getY2(), startX, startY);
                    a += hexArea(segment);
                    startX = startY = Double.NaN;
                    segment.setLine(Double.NaN, Double.NaN, Double.NaN, Double.NaN);
                    break;
                case PathIterator.SEG_LINETO:
                    segment.setLine(segment.getX2(), segment.getY2(), x, y);
                    a += hexArea(segment);
                    break;
                case PathIterator.SEG_MOVETO:
                    startX = x;
                    startY = y;
                    segment.setLine(Double.NaN, Double.NaN, x, y);
                    break;
                default:
                    throw new IllegalArgumentException("PathIterator contains curved segments");
            }
            i.next();
        }

        a = 0.5 * Math.abs(a);

        System.out.println(a);
    }

    private static double hexArea(Line2D seg) {
        return seg.getX1() * seg.getY2() - seg.getX2() * seg.getY1();
    }
}
