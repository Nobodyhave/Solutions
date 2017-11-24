package leetcode;

/**
 * Created by Aleksandr on 17/11/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/find-pivot-index
 */
public class FindPivotIndex {
    public int pivotIndex(int[] nums) {
        if (nums == null || nums.length < 3) {
            return -1;
        }

        final int[] prefixSum = new int[nums.length + 1];
        prefixSum[nums.length] = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            prefixSum[i] = prefixSum[i + 1] + nums[i];
        }

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (sum == prefixSum[i + 1]) {
                return i;
            }
            sum += nums[i];
        }

        return -1;
    }
}
