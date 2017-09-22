package leetcode;

import java.math.BigInteger;

/**
 * Created by Aleksandr on 21/09/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/smallest-good-base
 */
public class SmallestGoodBase {
    public String smallestGoodBase(String n) {
        final BigInteger N = new BigInteger(n);
        long base = Long.MAX_VALUE;

        for (int k = 2; k < 66; k++) {
            long l = 2, r = Long.MAX_VALUE;
            while (l <= r) {
                final long mid = l + (r - l) / 2;

                final BigInteger cb = BigInteger.valueOf(mid).pow(k).subtract(BigInteger.ONE);
                final BigInteger wb = N.multiply(BigInteger.valueOf(mid).subtract(BigInteger.ONE));

                int cmp = cb.compareTo(wb);
                if (cmp == 0) {
                    base = Math.min(base, mid);
                    break;
                } else if (cmp < 0) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }

        return String.valueOf(base);
    }
}
