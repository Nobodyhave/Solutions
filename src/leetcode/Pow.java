package leetcode;

/**
 * Created by Aleksandr on 16/05/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/powx-n
 */
public class Pow {
    public double myPow(double x, int exp) {
        if (x == 0) {
            return 0;
        } else if (exp == 0) {
            return 1;
        }

        double result = 1;
        double base = x;

        long n = Math.abs((long)exp);
        while (n > 0) {
            if (n % 2 == 1) {
                result *= base;
            }
            n >>= 1;
            base *= base;
        }

        return exp > 0 ? result : 1 / result;
    }
}
