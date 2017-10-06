package leetcode;

/**
 * Created by Aleksandr on 27/09/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/base-7
 */
public class Base7 {
    public String convertToBase7(int num) {
        if (num == 0) {
            return "0";
        }

        final StringBuilder sb = new StringBuilder();
        boolean isNegative = num < 0;
        num = Math.abs(num);

        while (num > 0) {
            sb.append(num % 7);
            num /= 7;
        }

        if (isNegative) {
            sb.append("-");
        }

        return sb.reverse().toString();
    }
}
