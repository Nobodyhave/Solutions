package leetcode;

/**
 * Created by Aleksandr on 21/08/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/power-of-three
 */
public class PowerOfThree {
    public boolean isPowerOfThree(int n) {
        if (n <= 0) {
            return false;
        } else if (n == 1) {
            return true;
        }

        while (n % 3 == 0 && n > 3) {
            n /= 3;
        }

        return n % 3 == 0;
    }
}
