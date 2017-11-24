package leetcode;

import java.math.BigInteger;
import java.util.*;

/**
 * Created by Aleksandr on 15/11/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/maximum-length-of-repeated-subarray
 */
public class MaximumLengthOfRepeatedSubarray {
    private static final long BASE = 347;
    private static final long MOD = BigInteger.probablePrime(40, new Random()).longValue();

    public int findLength(int[] A, int[] B) {
        if (A == null || A.length == 0 || B == null || B.length == 0) {
            return 0;
        }

        return hashSolution(A, B);
    }

    private int dynamicProgrammingSolution(int[] A, int[] B) {
        final int[][] dp = new int[A.length + 1][B.length + 1];
        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= A.length; i++) {
            for (int j = 1; j <= B.length; j++) {
                if (A[i - 1] == B[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                max = Math.max(max, dp[i][j]);
            }
        }

        for (int i = 1; i < dp.length; i++) {
            System.out.print("i: " + i);
            for (int j = 1; j < dp[0].length; j++) {
                System.out.format(" %2d ", dp[i][j]);
            }
            System.out.println();
        }

        return max;
    }

    // Not working on some tests by strange reason
    private int hashSolution(int[] A, int[] B) {
        final Map<Integer, Set<Long>> mapB = new HashMap<>();
        for (int l = B.length; l >= 1; l--) {
            final Set<Long> set = new HashSet<>();
            mapB.put(l, set);
            long hash = hash(B, 0, l - 1);
            set.add(hash);
            for (int i = 1; i <= B.length - l; i++) {
                hash = nextHash(hash, l, B[i - 1], B[i + l - 1]);
                set.add(hash);
            }
        }

        for (int l = A.length; l >= 1; l--) {
            long hash = hash(A, 0, l - 1);
            if (mapB.get(l).contains(hash)) {
                return l;
            }
            for (int i = 1; i <= A.length - l; i++) {
                hash = nextHash(hash, l, A[i - 1], A[i + l - 1]);
                if (mapB.get(l).contains(hash)) {
                    return l;
                }
            }
        }

        return 0;
    }

    private long hash(int[] a, int lo, int hi) {
        long hash = 0;
        for (int i = lo; i <= hi; i++) {
            hash = (hash * BASE + a[i]) % MOD;
        }

        return hash;
    }

    private long nextHash(long hash, long len, long prev, long next) {
        long nextHash = hash + MOD - (modPowByExponent(BASE, len - 1, MOD) * prev) % MOD;
        nextHash %= MOD;
        nextHash = (nextHash * BASE + next) % MOD;
        return nextHash;
    }

    private long modPowByExponent(long x, long exp, long mod) {
        if (mod == 1) {
            return 0;
        }

        long result = 1;
        long base = x % mod;

        while (exp > 0) {
            if (exp % 2 == 1) {
                result = (result * base) % mod;
            }
            exp = exp >> 1;
            base = (base * base) % mod;
        }

        return result;
    }
}
