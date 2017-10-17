package leetcode;

import java.util.Arrays;

/**
 * Created by Aleksandr on 16/10/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/valid-triangle-number
 */
public class ValidTriangleNumber {
    public int triangleNumber(int[] nums) {
        if (nums == null || nums.length < 3) {
            return 0;
        }

        Arrays.sort(nums);

        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                final int key = nums[i] + nums[j] - 1;
                int index = Arrays.binarySearch(nums, j + 1, nums.length, key);
                if (index < 0) {
                    index = -(index + 1) - 1;
                } else {
                    while (index < nums.length - 1 && nums[index + 1] == key) {
                        index++;
                    }
                }

                if (index > j) {
                    count += index - j;
                }
            }
        }

        return count;
    }
}
