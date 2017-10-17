package leetcode;

/**
 * Created by Aleksandr on 17/10/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/sum-of-square-numbers
 */
public class SumOfSquareNumbers {
    public boolean judgeSquareSum(int c) {
        if (c < 0) {
            return false;
        }

        for (long a = 0; a * a <= c; a++) {
            long b2 = (long) c - a * a;
            long b = binarySearch(0, b2, b2);
            if (b != -1) {
                return true;
            }
        }

        return false;
    }

    private long binarySearch(long start, long end, long b2) {
        while (start <= end) {
            final long mid = start + (end - start) / 2;
            if (mid * mid < b2) {
                start = mid + 1;
            } else if (mid * mid > b2) {
                end = mid - 1;
            } else {
                return mid;
            }
        }

        return -1L;
    }
}
