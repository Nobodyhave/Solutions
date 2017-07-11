package leetcode;

/**
 * Created by Aleksandr on 10/07/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/reverse-bits
 */
public class ReverseBits {
    public int reverseBits(int n) {
        int result = 0, mask = 1;
        for (int i = 0; i < 32; i++) {
            int digit = (n >>> i) & mask;
            result |= (digit << (31 - i));
        }

        return result;
    }
}
