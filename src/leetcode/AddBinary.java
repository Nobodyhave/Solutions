package leetcode;

/**
 * Created by Aleksandr on 29/05/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/add-binary
 */
public class AddBinary {
    public String addBinary(String a, String b) {
        if (a == null || b == null) {
            return "0";
        }

        final StringBuilder sb = new StringBuilder();
        int carry = 0;
        int i = a.length() - 1, j = b.length() - 1;
        while (i >= 0 || j >= 0) {
            if (i >= 0 && j >= 0) {
                if (a.charAt(i) == '0' && b.charAt(j) == '0') {
                    sb.append(carry);
                    carry = 0;
                } else if (a.charAt(i) == '0' && b.charAt(j) == '1') {
                    if (carry == 0) {
                        sb.append(1);
                    } else {
                        sb.append(0);
                        carry = 1;
                    }
                } else if (a.charAt(i) == '1' && b.charAt(j) == '0') {
                    if (carry == 0) {
                        sb.append(1);
                    } else {
                        sb.append(0);
                        carry = 1;
                    }
                } else {
                    if (carry == 0) {
                        sb.append(0);
                        carry = 1;
                    } else {
                        sb.append(1);
                        carry = 1;
                    }
                }
                i--;
                j--;
            } else if (i >= 0) {
                if (a.charAt(i) == '0') {
                    sb.append(carry);
                    carry = 0;
                } else {
                    if (carry == 0) {
                        sb.append(1);
                    } else {
                        sb.append(0);
                        carry = 1;
                    }
                }
                i--;
            } else if (j >= 0) {
                if (b.charAt(j) == '0') {
                    sb.append(carry);
                    carry = 0;
                } else {
                    if (carry == 0) {
                        sb.append(1);
                    } else {
                        sb.append(0);
                        carry = 1;
                    }
                }
                j--;
            }
        }

        if (carry > 0) {
            sb.append(1);
        }

        return sb.reverse().toString();
    }
}
