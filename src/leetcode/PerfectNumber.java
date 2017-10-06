package leetcode;

/**
 * Created by Aleksandr on 27/09/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/perfect-number
 */
public class PerfectNumber {
    public boolean checkPerfectNumber(int num) {
        if (num < 2) {
            return false;
        }

        int sum = 1, sqrt = (int) Math.sqrt(num);
        for (int i = 2; i <= sqrt; i++) {
            if (num % i == 0) {
                sum += i;
                sum += num / i;
            }
        }

        return num == sum;
    }
}
