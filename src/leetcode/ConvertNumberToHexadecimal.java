package leetcode;

/**
 * Created by Aleksandr on 07/09/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/convert-a-number-to-hexadecimal
 */
public class ConvertNumberToHexadecimal {
    public String toHex(int num) {
        final char[] hex = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        if (num == 0) {
            return "0";
        }

        final StringBuilder sb = new StringBuilder();
        while (num != 0) {
            sb.append(hex[num & 0b1111]);
            num >>>= 4;
        }

        return sb.reverse().toString();
    }
}
