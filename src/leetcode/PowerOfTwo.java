package leetcode;

/**
 * Created by Aleksandr on 18/07/2017.
 * Project Solutions
 *
 * https://leetcode.com/problems/power-of-two
 */
public class PowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n-1)) == 0;
    }
}
