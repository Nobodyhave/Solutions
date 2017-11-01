package leetcode;

/**
 * Created by Aleksandr on 26/10/2017.
 * Project Solutions
 * https://leetcode.com/problems/kth-smallest-number-in-multiplication-table
 */
public class KthSmallestNumberInMultiplicationTable {
    public int findKthNumber(int m, int n, int k) {
        int low = 1, high = m * n + 1;

        while (low < high) {
            final int mid = low + (high - low) / 2;
            int c = countLessOrEqual(mid, m, n);
            if (c >= k) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return high;
    }

    private int countLessOrEqual(int v, int m, int n) {
        int count = 0;
        for (int i = 1; i <= m; i++) {
            int temp = Math.min(v / i, n);
            count += temp;
        }
        return count;
    }
}
