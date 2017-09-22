package leetcode;

/**
 * Created by Aleksandr on 21/09/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/license-key-formatting
 */
public class LicenseKeyFormatting {
    public String licenseKeyFormatting(String s, int k) {
        if (s == null || s.length() == 0 || k == 0) {
            return s;
        }

        s = s.toUpperCase();

        final StringBuilder sb = new StringBuilder();
        int count = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            final char c = s.charAt(i);
            if (c >= 'a' && c <= 'z') {
                sb.append((char) (c + 0x20));
                count++;
            } else if (c != '-') {
                sb.append(c);
                count++;
            }
            if (count == k) {
                sb.append('-');
                count = 0;
            }
        }

        if (sb.length() > 0 && sb.charAt(sb.length() - 1) == '-') {
            sb.deleteCharAt(sb.length() - 1);
        }

        return sb.reverse().toString();
    }
}
