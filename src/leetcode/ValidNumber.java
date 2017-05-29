package leetcode;

/**
 * Created by Aleksandr on 29/05/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/valid-number
 */
public class ValidNumber {
    public boolean isNumber(String s) {
        try {
            if (s.charAt(s.length() - 1) == 'f' || s.charAt(s.length() - 1) == 'D') {
                Double.parseDouble(s.substring(s.length() - 1));
            } else {
                Double.parseDouble(s);
            }
        } catch (NumberFormatException e) {
            return false;
        }

        return true;
    }
}
