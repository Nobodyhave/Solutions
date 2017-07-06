package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Aleksandr on 06/07/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/max-points-on-a-line
 */
public class MaxPointsOnLine {
    public int maxPoints(Point[] points) {
        if (points == null) {
            return 0;
        } else if (points.length <= 2) {
            return points.length;
        }

        int max = 0;
        for (Point point : points) {
            final Map<Segment, Integer> map = new HashMap<>();

            for (Point p : points) {
                final Segment s = new Segment(point.x - p.x, point.y - p.y);
                if (map.containsKey(s)) {
                    map.put(s, map.get(s) + 1);
                } else {
                    map.put(s, 1);
                }
            }

            for (Map.Entry<Segment, Integer> entry : map.entrySet()) {
                if (entry.getValue() >= max) {
                    max = entry.getValue();
                    final Segment selfSegment = new Segment(0, 0);
                    if (!entry.getKey().equals(selfSegment)) {
                        max += map.get(selfSegment);
                    }
                }
            }
        }

        return max;
    }

    private static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }

    private static class Segment {
        private int dx;
        private int dy;

        Segment(int dx, int dy) {
            final int gcd = gcd(dx, dy);

            this.dx = dx;
            this.dy = dy;

            if (gcd != 0) {
                this.dx /= gcd;
                this.dy /= gcd;
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Segment segment = (Segment) o;

            return dx == segment.dx && dy == segment.dy;
        }

        @Override
        public int hashCode() {
            int result = dx;
            result = 31 * result + dy;
            return result;
        }
    }

    static class Point {
        int x;
        int y;

        Point(int a, int b) {
            x = a;
            y = b;
        }
    }
}
