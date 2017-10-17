package leetcode;

/**
 * Created by Aleksandr on 10/10/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/valid-square
 */
public class ValidSquare {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        long d2 = distSq(p1, p2);
        long d3 = distSq(p1, p3);
        long d4 = distSq(p1, p4);
        long d23 = distSq(p2, p3);
        long d24 = distSq(p2, p4);
        long d34 = distSq(p3, p4);

        if (d2 == 0 || d3 == 0 || d4 == 0 || d23 == 0 || d24 == 0 || d34 == 0) {
            return false;
        }

        if (d2 == d3 && 2 * d2 == d4) {
            return d24 == d34 && d24 == d2;
        } else if (d2 == d4 && 2 * d2 == d3) {
            return d23 == d34 && d23 == d2;
        } else if (d3 == d4 && 2 * d3 == d2) {
            return d23 == d24 && d23 == d3;
        } else {
            return false;
        }
    }

    private int distSq(int[] p, int[] q) {
        return (p[0] - q[0]) * (p[0] - q[0]) + (p[1] - q[1]) * (p[1] - q[1]);
    }
}
