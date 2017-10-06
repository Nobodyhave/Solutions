package leetcode;

import java.util.Arrays;

/**
 * Created by Aleksandr on 05/10/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/array-partition-i
 */
public class ArrayPartitionI {
    public int arrayPairSum(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length % 2 != 0) {
            return 0;
        }

        Arrays.sort(nums);

        int sum = 0;
        for (int i = 0; i < nums.length; i += 2) {
            sum += nums[i];
        }

        return sum;
    }
}
