package leetcode;

/**
 * Created by Aleksandr on 02/05/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/reverse-integer
 */
public class ReverseInteger {
    public int reverse(int x) {
        if (x == 0) {
            return 0;
        }

        boolean isNegative = x < 0;
        long num = x;
        if (isNegative) {
            num = -num;
        }
        long result = 0;
        while (num != 0) {
            long r = num % 10;
            result = 10 * result + r;
            num /= 10;
        }

        if (isNegative) {
            if (-result < Integer.MIN_VALUE) {
                return 0;
            } else {
                return (int) -result;
            }
        } else {
            if (result > Integer.MAX_VALUE) {
                return 0;
            } else {
                return (int) result;
            }
        }
    }
}
