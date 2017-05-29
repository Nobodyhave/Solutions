package leetcode;

/**
 * Created by Aleksandr on 29/05/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/sqrtx
 */
public class SquareRootX {
    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }

        long start = 1, end = x, best = 0;

        while (start <= end) {
            long mid = start + (end - start) / 2;

            if (mid * mid < (long) x) {
                start = mid + 1;
                best = mid;
            } else if (mid * mid > (long) x) {
                end = mid - 1;
            } else {
                return (int) mid;
            }
        }

        return (int) best;
    }
}
