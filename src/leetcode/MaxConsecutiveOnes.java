package leetcode;

/**
 * Created by Aleksandr on 21/09/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/max-consecutive-ones
 */
public class MaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int count = 0, maxCount = 0;
        for (int num : nums) {
            if (num == 1) {
                count++;
            } else {
                maxCount = Math.max(maxCount, count);
                count = 0;
            }
        }
        maxCount = Math.max(maxCount, count);

        return maxCount;
    }
}
