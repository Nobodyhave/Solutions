package leetcode;

/**
 * Created by Aleksandr on 07/07/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/factorial-trailing-zeroes
 */
public class FactorialTrailingZeroes {
    public int trailingZeroes(int n) {
        long multiplicator = 5;
        int result = 0;
        while (multiplicator <= (long) n) {
            result += n / multiplicator;
            multiplicator *= 5;
        }

        return result;
    }
}
