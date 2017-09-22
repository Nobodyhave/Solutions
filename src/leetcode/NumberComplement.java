package leetcode;

/**
 * Created by Aleksandr on 20/09/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/number-complement
 */
public class NumberComplement {
    public int findComplement(int num) {
        if (num <= 0) {
            return 0;
        }

        int add = 1, result = 0;
        while (num != 0) {
            if ((num & 1) == 0) {
                result += add;
            }
            add <<= 1;
            num >>= 1;
        }

        return result;
    }
}
