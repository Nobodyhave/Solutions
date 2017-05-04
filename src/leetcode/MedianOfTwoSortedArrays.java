package leetcode;

/**
 * Created by Aleksandr on 28/04/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/median-of-two-sorted-arrays
 */
public class MedianOfTwoSortedArrays {
    double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;

        if (n > m) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int k = (n + m - 1) / 2;
        int l = 0, r = Math.min(k, n);
        while (l < r) {
            int midA = (l + r) / 2;
            int midB = k - midA;
            if (nums1[midA] < nums2[midB])
                l = midA + 1;
            else
                r = midA;
        }

        int a = Math.max(l > 0 ? nums1[l - 1] : Integer.MIN_VALUE, k - l >= 0 ? nums2[k - l] : Integer.MIN_VALUE);
        if (((n + m) & 1) == 1)
            return (double) a;

        int b = Math.min(l < n ? nums1[l] : Integer.MAX_VALUE, k - l + 1 < m ? nums2[k - l + 1] : Integer.MAX_VALUE);

        return (a + b) / 2.0;
    }
}
