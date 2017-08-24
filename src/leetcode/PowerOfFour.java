package leetcode;

/**
 * Created by Aleksandr on 23/08/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/power-of-four
 */
public class PowerOfFour {
    public boolean isPowerOfFour(int num) {
        return num > 0 && (num&(num-1)) == 0 && (num & 0x55555555) != 0;
    }
}
