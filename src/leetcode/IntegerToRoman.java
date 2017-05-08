package leetcode;

/**
 * Created by Aleksandr on 04/05/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/integer-to-roman
 */
public class IntegerToRoman {
    public String intToRoman(int num) {
        final StringBuilder sb = new StringBuilder();

        int count = num / 1000;
        if (count != 0) {
            for (int i = 0; i < count; i++) {
                sb.append('M');
            }
        }
        num %= 1000;

        count = num / 100;
        if (count < 4) {
            for (int i = 0; i < count; i++) {
                sb.append('C');
            }
        } else if (count == 4) {
            sb.append("CD");
        } else if (count == 5) {
            sb.append('D');
        } else if (count < 9) {
            sb.append('D');
            for (int i = 0; i < count - 5; i++) {
                sb.append('C');
            }
        } else if (count == 9) {
            sb.append("CM");
        }
        num %= 100;

        count = num / 10;
        if (count < 4) {
            for (int i = 0; i < count; i++) {
                sb.append('X');
            }
        } else if (count == 4) {
            sb.append("XL");
        } else if (count == 5) {
            sb.append('L');
        } else if (count < 9) {
            sb.append('L');
            for (int i = 0; i < count - 5; i++) {
                sb.append('X');
            }
        } else if (count == 9) {
            sb.append("XC");
        }
        num %= 10;

        count = num;
        if (count < 4) {
            for (int i = 0; i < count; i++) {
                sb.append('I');
            }
        } else if (count == 4) {
            sb.append("IV");
        } else if (count == 5) {
            sb.append('V');
        } else if (count < 9) {
            sb.append('V');
            for (int i = 0; i < count - 5; i++) {
                sb.append('I');
            }
        } else if (count == 9) {
            sb.append("IX");
        }

        return sb.toString();
    }
}
