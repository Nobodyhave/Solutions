package leetcode;

import java.util.Arrays;

/**
 * Created by Aleksandr on 26/09/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/next-greater-element-i
 */
public class NextGreaterElementI {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            return new int[0];
        }

        final int[] result = new int[nums1.length];
        Arrays.fill(result, -1);

        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (nums2[j] == nums1[i]) {
                    for (int k = j + 1; k < nums2.length; k++) {
                        if (nums2[k] > nums2[j]) {
                            result[i] = nums2[k];
                            break;
                        }
                    }
                }
            }
        }

        return result;
    }
}
