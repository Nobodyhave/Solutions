package leetcode;

/**
 * Created by Aleksandr on 12/05/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/multiply-strings
 */
public class MultiplyStrings {
    public String multiply(String num1, String num2) {
        if (num1 == null || num1.length() == 0 || num2 == null || num2.length() == 0) {
            return "";
        }

        if (num2.length() > num2.length()) {
            String temp = num1;
            num1 = num2;
            num2 = temp;
        }

        String result = multiplySingle(num1, num2.charAt(0));
        for (int i = 1; i < num2.length(); i++) {
            result = add(multiplyByTen(result), multiplySingle(num1, num2.charAt(i)));
        }

        return result.replaceFirst("^0+(?!$)", "");
    }

    private String add(String s1, String s2) {
        final StringBuilder sb = new StringBuilder();
        s1 = new StringBuilder(s1).reverse().toString();
        s2 = new StringBuilder(s2).reverse().toString();
        int i = 0, carry = 0;
        while (i < s1.length() || i < s2.length()) {
            if (i >= s1.length()) {
                int a = ((s2.charAt(i) - '0') + carry) % 10;
                carry = ((s2.charAt(i) - '0') + carry) / 10;
                sb.append(a);
            } else if (i >= s2.length()) {
                int a = ((s1.charAt(i) - '0') + carry) % 10;
                carry = ((s1.charAt(i) - '0') + carry) / 10;
                sb.append(a);
            } else {
                int a = ((s1.charAt(i) - '0' + s2.charAt(i) - '0') + carry) % 10;
                carry = ((s1.charAt(i) - '0' + s2.charAt(i) - '0') + carry) / 10;
                sb.append(a);
            }
            i++;
        }
        if (carry != 0) {
            sb.append(carry);
        }
        sb.reverse();

        return sb.toString();
    }

    private static String multiplyByTen(String s) {
        return s + "0";
    }

    private static String multiplySingle(String s, char c) {
        final StringBuilder sb = new StringBuilder();

        int carry = 0;
        int b = c - '0';
        for (int i = s.length() - 1; i >= 0; i--) {
            int a = s.charAt(i) - '0';
            sb.append((a * b + carry) % 10);
            carry = (a * b + carry) / 10;
        }
        if (carry != 0) {
            sb.append(carry);
        }
        sb.reverse();

        return sb.toString();
    }
}
