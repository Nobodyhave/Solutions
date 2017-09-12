package leetcode;

/**
 * Created by Aleksandr on 07/09/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/rotate-function
 */
public class RotateFunction {
    public int maxRotateFunction(int[] A) {
        if (A == null || A.length < 2) {
            return 0;
        }

        final int n = A.length;
        int sum = 0, maxF = 0;
        for (int i = 0; i < n; i++) {
            sum += A[i];
            maxF += i * A[i];
        }

        int prevF = maxF;
        for (int f = 1; f < n; f++) {
            int curF = prevF - A[n - f] * (n - 1) + (sum - A[n - f]);
            maxF = Math.max(maxF, curF);
            prevF = curF;
        }

        return maxF;
    }
}
