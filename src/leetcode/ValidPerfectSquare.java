package leetcode;

/**
 * Created by Aleksandr on 24/08/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/valid-perfect-square
 */
public class ValidPerfectSquare {
    public boolean isPerfectSquare(int num) {
        if (num < 1) {
            return false;
        }

        int start = 1, end = Integer.MAX_VALUE;
        while (start <= end) {
            long mid = start + (end - start) / 2;
            if (mid * mid < (long) num) {
                start = (int) mid + 1;
            } else if (mid * mid > (long) num) {
                end = (int) mid - 1;
            } else {
                return true;
            }
        }

        return false;
    }
}
