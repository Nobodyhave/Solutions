package leetcode;

/**
 * Created by Aleksandr on 10/08/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/missing-number/description/
 */
public class MissingNumber {
    public int missingNumber(int[] nums) {
        if(nums == null || nums.length == 0) {
            return -1;
        }

        int sum = 0;
        int indexSum = 0;
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            indexSum += i;
        }

        return nums.length - (sum - indexSum);
    }
}
