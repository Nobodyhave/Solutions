package leetcode;

/**
 * Created by Aleksandr on 19/09/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/validate-ip-address
 */
public class ValidateIpAddress {
    public String validIPAddress(String IP) {
        if (isValidIPv4(IP)) {
            return "IPv4";
        } else if (isValidIPv6(IP)) {
            return "IPv6";
        } else {
            return "Neither";
        }
    }

    private boolean isValidIPv4(String ip) {
        if (ip.length() < 7 || ip.charAt(0) == '.' || ip.charAt(ip.length() - 1) == '.') {
            return false;
        }
        final String[] tokens = ip.split("\\.");
        if (tokens.length != 4) {
            return false;
        }
        for (String token : tokens) {
            if (!isValidIPv4Token(token)) {
                return false;
            }
        }

        return true;
    }

    private boolean isValidIPv4Token(String token) {
        if (token.startsWith("0") && token.length() > 1) {
            return false;
        }
        try {
            final int parsedInt = Integer.parseInt(token);
            if (parsedInt < 0 || parsedInt > 255 || (parsedInt == 0 && token.charAt(0) != '0')) {
                return false;
            }
        } catch (NumberFormatException e) {
            return false;
        }

        return true;
    }

    private boolean isValidIPv6(String ip) {
        if (ip.length() < 15 || ip.charAt(0) == ':' || ip.charAt(ip.length() - 1) == ':') {
            return false;
        }
        final String[] tokens = ip.split(":");
        if (tokens.length != 8) {
            return false;
        }
        for (String token : tokens) {
            if (!isValidIPv6Token(token)) {
                return false;
            }
        }
        return true;
    }

    private boolean isValidIPv6Token(String token) {
        if (token.length() > 4 || token.length() == 0) {
            return false;
        }
        final char[] chars = token.toCharArray();
        for (char c : chars) {
            final boolean isUppercaseAF = c >= 'A' && c <= 'F';
            final boolean isLowerCaseAF = c >= 'a' && c <= 'f';
            if (!(Character.isDigit(c) || isUppercaseAF || isLowerCaseAF)) {
                return false;
            }
        }

        return true;
    }
}
