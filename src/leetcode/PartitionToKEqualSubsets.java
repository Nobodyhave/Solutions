package leetcode;

/**
 * Created by Aleksandr on 13/11/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/partition-to-k-equal-sum-subsets
 */
public class PartitionToKEqualSubsets {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        if (nums == null) {
            return false;
        } else if (nums.length == 0) {
            return k == 0;
        } else if (k == 1) {
            return true;
        } else if (nums.length < k) {
            return false;
        }

        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        final boolean[] marked = new boolean[nums.length];
        final int[] sums = new int[k];

        sums[0] = nums[0];
        marked[0] = true;

        return sum % k == 0 && dfs(nums, marked, sums, sum / k, 0, 0);

    }

    private boolean dfs(int[] nums, boolean[] marked, int[] sums, int sum, int currentIndex, int limitIndex) {
        if (sums[currentIndex] == sum) {
            return currentIndex == sums.length - 2 || dfs(nums, marked, sums, sum, currentIndex + 1, 0);
        }

        for (int i = limitIndex; i < nums.length; i++) {
            if (marked[i]) continue;

            if (sums[currentIndex] + nums[i] <= sum) {
                marked[i] = true;
                sums[currentIndex] += nums[i];
                boolean next = dfs(nums, marked, sums, sum, currentIndex, i + 1);
                marked[i] = false;
                sums[currentIndex] -= nums[i];
                if (next) return true;
            }
        }
        return false;
    }
}
