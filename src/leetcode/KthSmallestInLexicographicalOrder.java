package leetcode;

/**
 * Created by Aleksandr on 13/09/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/k-th-smallest-in-lexicographical-order
 */
public class KthSmallestInLexicographicalOrder {
    public int findKthNumber(int n, int k) {
        int depth = countDepth(n);

        return helper(n, k, 0, depth);
    }

    private int helper(int n, int k, int prefix, int depth) {
        final int lowNum = getFullTreeCount(depth);
        final int highNum = getFullTreeCount(depth - 1);

        for (int i = (prefix == 0 ? 1 : 0); i <= 9; i++) {
            final int max = getMax(prefix * 10 + i, depth - 1);
            final int min = getMin(prefix * 10 + i, depth - 1);

            int nodeNum;
            if (max <= n) {
                nodeNum = lowNum;
            } else if (min > n) {
                nodeNum = highNum;
            } else {
                nodeNum = highNum + ((n - min) + 1);
            }

            k -= nodeNum;

            if (k <= 0) {
                k += nodeNum;
                if (k == 1) {
                    return prefix * 10 + i;
                } else {
                    return helper(n, k - 1, prefix * 10 + i, depth - 1);
                }
            }
        }
        return 0;
    }

    private int countDepth(int n) {
        int i = 0;
        while (n > 0) {
            n /= 10;
            i++;
        }
        return i;
    }

    private int getFullTreeCount(int depth) {
        int sum = 0, children = 1;
        while (depth > 0) {
            sum += children;
            children *= 10;
            depth--;
        }
        return sum;
    }

    private int getMax(int prefix, int depth) {
        while (depth > 0) {
            prefix *= 10;
            prefix += 9;
            depth--;
        }
        return prefix;
    }

    private int getMin(int prefix, int depth) {
        while (depth > 0) {
            prefix *= 10;
            depth--;
        }
        return prefix;
    }
}
