package leetcode;

import java.math.BigInteger;

/**
 * Created by Aleksandr on 08/06/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/unique-binary-search-trees
 */
public class UniqueBinarySearchTrees {
    public int numTrees(int n) {
        return (int) factorial(2 * n).divide(factorial(n).multiply(factorial(n).multiply(BigInteger.valueOf(n + 1)))).longValue();
    }

    private static BigInteger factorial(int n) {
        BigInteger result = BigInteger.ONE;
        for (int i = n; i > 1; i--) {
            result = result.multiply(BigInteger.valueOf(i));
        }

        return result;
    }
}
