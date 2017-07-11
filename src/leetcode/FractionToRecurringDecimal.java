package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Aleksandr on 07/07/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/fraction-to-recurring-decimal
 */
public class FractionToRecurringDecimal {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) {
            return "0";
        }

        final StringBuilder sb = new StringBuilder();
        sb.append(((numerator > 0) ^ (denominator > 0)) ? "-" : "");

        long num = Math.abs((long) numerator);
        long den = Math.abs((long) denominator);

        sb.append(num / den);
        num %= den;

        if (num == 0) {
            return sb.toString();
        }

        sb.append(".");
        final Map<Long, Integer> map = new HashMap<>();
        map.put(num, sb.length());
        while (num != 0) {
            num *= 10;
            sb.append(num / den);
            num %= den;
            if (map.containsKey(num)) {
                sb.insert(map.get(num), "(");
                sb.append(")");
                break;
            } else {
                map.put(num, sb.length());
            }
        }

        return sb.toString();
    }
}
