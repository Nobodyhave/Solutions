package leetcode;

import java.util.*;

/**
 * Created by Aleksandr on 09/10/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/erect-the-fence
 */
public class ErectFence {
    public List<Point> outerTrees(Point[] points) {
        final List<Point> result = new ArrayList<>();

        if (points == null) {
            return result;
        } else if (points.length < 4) {
            Collections.addAll(result, points);

            return result;
        }

        final PolarPoint[] polars = new PolarPoint[points.length];
        for (int i = 0; i < points.length; i++) {
            polars[i] = new PolarPoint(points[i].x, points[i].y);
        }

        Arrays.sort(polars);
        int minX = Integer.MAX_VALUE;
        for (PolarPoint p : polars) {
            minX = Math.min(minX, p.x);
        }

        Arrays.sort(polars, 1, polars.length, polars[0].polar(minX));

        final Deque<PolarPoint> hull = new ArrayDeque<>();

        hull.offerFirst(polars[0]);
        hull.offerFirst(polars[1]);
        hull.offerFirst(polars[2]);

        for (int i = 3; i < polars.length; i++) {
            PolarPoint top = hull.poll();
            while (top.ccw(hull.peek(), top, polars[i]) < 0) {
                top = hull.poll();
            }
            hull.offerFirst(top);
            hull.offerFirst(polars[i]);
        }

        for (PolarPoint p : hull) {
            result.add(new Point(p.x, p.y));
        }

        return result;
    }

    private class PolarPoint extends Point implements Comparable<PolarPoint> {
        PolarPoint(int a, int b) {
            super(a, b);
        }

        PolarComparator polar(int minX) {
            return new PolarComparator(minX);
        }

        int ccw(PolarPoint a, PolarPoint b, PolarPoint c) {
            final double area = (b.x - a.x) * (c.y - a.y) - (b.y - a.y) * (c.x - a.x);
            if (area < 0) return -1;
            else if (area > 0) return +1;
            else return 0;
        }

        @Override
        public int compareTo(PolarPoint that) {
            if (this.y < that.y) return -1;
            if (this.y > that.y) return +1;
            if (this.x < that.x) return -1;
            if (this.x > that.x) return +1;
            return 0;
        }

        private class PolarComparator implements Comparator<PolarPoint> {
            private int minX;

            PolarComparator(int minX) {
                this.minX = minX;
            }

            @Override
            public int compare(PolarPoint p1, PolarPoint p2) {
                final double dx1 = p1.x - x;
                final double dy1 = p1.y - y;
                final double dx2 = p2.x - x;
                final double dy2 = p2.y - y;

                final int turn = -ccw(PolarPoint.this, p1, p2);

                if (turn != 0) {
                    return turn;
                }

                if (dx1 > 0 && dx2 > 0) {
                    if (dy1 < dy2) {
                        return -1;
                    } else if (dy1 > dy2) {
                        return 1;
                    } else {
                        return dx1 <= dx2 ? -1 : 1;
                    }
                } else if (dx1 < 0 && dx2 < 0) {
                    if (dy1 < dy2) {
                        return 1;
                    } else if (dy1 > dy2) {
                        return -1;
                    } else {
                        return dx1 <= dx2 ? -1 : 1;
                    }
                } else if (dx1 < 0 && dx2 > 0) {
                    return 1;
                } else if (dx2 < 0 && dx1 > 0) {
                    return -1;
                } else if (dx1 == 0 && dx2 == 0) {
                    if (minX != x) {
                        return dy1 < dy2 ? -1 : 1;
                    } else {
                        return dy1 < dy2 ? 1 : -1;
                    }
                } else {
                    return 0;
                }
            }
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
