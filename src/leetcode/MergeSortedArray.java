package leetcode;

/**
 * Created by Aleksandr on 02/06/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/merge-sorted-array
 */
public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i1 = m - 1, i2 = n - 1, i = n + m - 1;

        while (i1 >= 0 || i2 >= 0) {
            if (i1 >= 0 && i2 >= 0) {
                if (nums1[i1] >= nums2[i2]) {
                    nums1[i--] = nums1[i1--];
                } else {
                    nums1[i--] = nums2[i2--];
                }
            } else if (i1 >= 0) {
                nums1[i--] = nums1[i1--];
            } else {
                nums1[i--] = nums2[i2--];
            }
        }
    }
}
