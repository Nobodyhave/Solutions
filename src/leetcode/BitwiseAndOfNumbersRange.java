package leetcode;

/**
 * Created by Aleksandr on 12/07/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/bitwise-and-of-numbers-range
 */
public class BitwiseAndOfNumbersRange {
    public int rangeBitwiseAnd(int m, int n) {
        int r = Integer.MAX_VALUE;
        while ((m & r) != (n & r)) r = r << 1;
        return n & r;
    }
}
