package interviewbit;

import java.util.ArrayList;

/**
 * Created by Aleksandr on 24/11/2017.
 * Project Solutions
 * <p>
 * https://www.interviewbit.com/problems/add-one-to-number/
 */
public class AddOneToNumber {
    public ArrayList<Integer> plusOne(ArrayList<Integer> digits) {
        int carry = 1;
        for (int i = digits.size() - 1; i >= 0; i--) {
            final int digit = digits.get(i);
            digits.set(i, (digit + carry) % 10);
            carry = (digit + carry) / 10;
        }

        if (carry != 0) {
            digits.add(0, carry);
        }

        while (!digits.isEmpty() && digits.get(0) == 0) {
            digits.remove(0);
        }

        return digits;
    }
}
