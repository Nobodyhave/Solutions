package leetcode;

/**
 * Created by Aleksandr on 24/08/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/water-and-jug-problem/description/
 */
public class WaterAndJugProblem {
    public boolean canMeasureWater(int x, int y, int z) {
        if (x == 0 && y == 0) {
            return z == 0;
        }

        return z <= x + y && z % gcd(x, y) == 0;
    }

    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }
}
