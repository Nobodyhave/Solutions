package leetcode;

/**
 * Created by Aleksandr on 07/09/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/decode-string
 */
public class DecodeString {
    public String decodeString(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        int count = 0, pCount = 0, start = 0, end = 0;
        final StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            final char c = s.charAt(i);
            if (c >= '0' && c <= '9' && pCount == 0) {
                count *= 10;
                count += c - '0';
            } else if (c == '[') {
                if (pCount == 0) {
                    start = i;
                }
                pCount++;
            } else if (c == ']') {
                pCount--;
                if (pCount == 0) {
                    end = i;
                    final String str = decodeString(s.substring(start + 1, end));
                    for (int j = 0; j < count; j++) {
                        sb.append(str);
                    }
                    count = 0;
                }
            } else if (pCount == 0) {
                sb.append(c);
            }
        }

        return sb.toString();
    }
}
