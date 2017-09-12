package leetcode;

/**
 * Created by Aleksandr on 07/09/2017.
 * Project Solutions
 *
 * https://leetcode.com/problems/add-strings
 */
public class AddStrings {
    public String addStrings(String num1, String num2) {
        if(num1 == null || num2 == null) {
            return "";
        }

        final StringBuilder sum = new StringBuilder();
        int carry = 0;
        for(int i = num1.length() - 1, j = num2.length() - 1, k = Math.max(num1.length() - 1, num2.length() - 1); k >= 0; k--, i--, j--) {
            if(i >= 0 && j >= 0) {
                int s = num1.charAt(i) - '0' + num2.charAt(j) - '0' + carry;
                sum.append(s % 10);
                carry = s / 10;
            } else if(i >= 0) {
                int s = num1.charAt(i) - '0' + carry;
                sum.append(s % 10);
                carry = s / 10;
            } else if(j >= 0) {
                int s = num2.charAt(j) - '0' + carry;
                sum.append(s % 10);
                carry = s / 10;
            }
        }
        if(carry != 0) {
            sum.append(carry);
        }


        return sum.reverse().toString();
    }
}
