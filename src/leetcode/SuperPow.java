package leetcode;

import java.math.BigInteger;

/**
 * Created by Aleksandr on 25/08/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/super-pow
 */
public class SuperPow {
    private static final BigInteger TWO = BigInteger.valueOf(2);

    public int superPow(int a, int[] b) {
        if (a == 0 || b == null || b.length == 0) {
            return 0;
        }

        int result = 1;
        int base = a % 1337;
        final StringBuilder sb = new StringBuilder();
        for (int i = 0; i < b.length; i++) {
            sb.append(b[i]);
        }
        BigInteger exp = new BigInteger(sb.toString());

        while (exp.compareTo(BigInteger.ZERO) > 0) {
            if (exp.mod(TWO).compareTo(BigInteger.ONE) == 0) {
                result = (result * base) % 1337;
            }

            exp = exp.shiftRight(1);
            base = (base * base) % 1337;
        }

        return result;
    }
}
