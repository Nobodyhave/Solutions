package leetcode;

/**
 * Created by Aleksandr on 14/08/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/range-sum-query-immutable
 */
public class RangeSumQuery {
    private int[] nums;
    private int[] prefixSum;

    public RangeSumQuery(int[] nums) {
        this.nums = nums;
        prefixSum = new int[nums.length];

        if (nums != null && nums.length != 0) {
            prefixSum[0] = nums[0];
            for (int i = 1; i < nums.length; i++) {
                prefixSum[i] = prefixSum[i - 1] + nums[i];
            }
        }
    }

    public int sumRange(int i, int j) {
        if (nums == null || nums.length == 0) {
            return 0;
        } else if (i == 0) {
            return prefixSum[j];
        } else {
            return prefixSum[j] - prefixSum[i - 1];
        }
    }
}
