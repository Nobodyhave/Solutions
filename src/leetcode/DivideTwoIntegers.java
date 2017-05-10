package leetcode;

/**
 * Created by Aleksandr on 09/05/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/divide-two-integers
 */
public class DivideTwoIntegers {
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        } else if (dividend == Integer.MIN_VALUE && divisor == 1) {
            return Integer.MIN_VALUE;
        } else if (divisor == 0) {
            throw new ArithmeticException("Divide by 0");
        }

        boolean isNegative = (dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0);
        long dividendL = Math.abs((long) dividend);
        long divisorL = Math.abs((long) divisor);

        int pos = -1;
        while (divisorL <= dividendL) {
            divisorL <<= 1;
            pos++;
        }
        divisorL >>= 1;

        int quotient = 0;
        while (pos > -1) {
            if (dividendL >= divisorL) {
                quotient += (1 << pos);
                dividendL -= divisorL;
            }

            divisorL >>= 1;
            pos--;
        }

        return isNegative ? -quotient : quotient;
    }
}
