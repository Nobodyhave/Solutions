package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aleksandr on 07/06/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/restore-ip-addresses
 */
public class RestoreIpAddress {
    public List<String> restoreIpAddresses(String s) {
        final List<String> result = new ArrayList<>();
        if (s == null || s.length() < 4) {
            return result;
        }

        goDeeper(result, s, new int[4], 0, 0);

        return result;
    }

    private static void goDeeper(List<String> result, String s, int[] parts, int part, int start) {
        if (part == parts.length && start == s.length()) {
            final StringBuilder sb = new StringBuilder();
            for (int i = 0; i < parts.length; i++) {
                sb.append(parts[i]).append('.');
            }
            sb.deleteCharAt(sb.length() - 1);
            result.add(sb.toString());

            return;
        } else if (part == parts.length && start != s.length()) {
            return;
        }

        for (int i = 1; i <= 3; i++) {
            if (start + i > s.length()) {
                break;
            }

            final int num = stringToInt(s.substring(start, start + i));
            if (num >= 0 && num < 256) {
                parts[part] = num;
                goDeeper(result, s, parts, part + 1, start + i);
            }
        }
    }

    private static int stringToInt(String s) {
        if (s.length() == 0 || s.length() > 3) {
            return -1;
        } else if (s.length() >= 2 && s.startsWith("0")) {
            return -1;
        }

        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            final char c = s.charAt(i);

            if (c < '0' || c > '9') {
                return -1;
            } else {
                result *= 10;
                result += c - '0';
            }
        }

        return result;
    }
}
