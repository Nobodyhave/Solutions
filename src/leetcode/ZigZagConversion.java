package leetcode;

/**
 * Created by Aleksandr on 02/05/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/zigzag-conversion
 */
public class ZigZagConversion {
    public String convert(String s, int numRows) {
        final StringBuilder sb = new StringBuilder();

        if (numRows == 1) {
            return s;
        }

        for (int i = 0; i < numRows; i++) {
            if (i == 0 || i == numRows - 1) {
                int position = i;
                while (position < s.length()) {
                    sb.append(s.charAt(position));
                    position += 2 * numRows - 2;
                }
            } else {
                int position = i;
                boolean up = false;
                while (position < s.length()) {
                    sb.append(s.charAt(position));
                    if (up) {
                        position += 2 * i;
                    } else {
                        position += 2 * (numRows - 1 - i);
                    }
                    up = !up;
                }
            }
        }

        return sb.toString();
    }
}
