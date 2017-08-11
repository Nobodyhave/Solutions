package leetcode;

/**
 * Created by Aleksandr on 20/07/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/ugly-number
 */
public class UglyNumber {
    public boolean isUgly(int num) {
        if (num == 0) {
            return false;
        }

        while (num % 2 == 0) {
            num /= 2;
        }

        while (num % 3 == 0) {
            num /= 3;
        }

        while (num % 5 == 0) {
            num /= 5;
        }

        return num == 1;
    }
}
