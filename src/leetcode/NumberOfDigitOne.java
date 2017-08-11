package leetcode;

/**
 * Created by Aleksandr on 19/07/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/number-of-digit-one
 */
public class NumberOfDigitOne {
    public int countDigitOne(int n) {
        int count = 0;
        for (long i = 1; i <= n; i *= 10) {
            long divider = i * 10;
            count += (n / divider) * i + Math.min(Math.max(n % divider - i + 1, 0L), i);
        }

        return count;
    }
}
