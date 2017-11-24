package leetcode;

import java.util.Arrays;

/**
 * Created by Aleksandr on 15/11/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/find-k-th-smallest-pair-distance
 */
public class FindKthSmallestPairDistance {
    public int countPairs(int[] a, int mid) {
        int n = a.length, res = 0;
        for (int i = 0; i < n; ++i) {
            int j = i;
            while (j < n && a[j] - a[i] <= mid) {
                j++;
            }
            res += j - i - 1;
        }
        return res;
    }

    private int smallestDistancePair(int a[], int k) {
        int n = a.length;
        Arrays.sort(a);

        int low = a[1] - a[0];
        for (int i = 1; i < n - 1; i++) {
            low = Math.min(low, a[i + 1] - a[i]);
        }

        // Maximum absolute difference
        int high = a[n - 1] - a[0];

        while (low < high) {
            int mid = low + (high - low) / 2;
            if (countPairs(a, mid) < k) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low;
    }
}
