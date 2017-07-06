package leetcode;

/**
 * Created by Aleksandr on 30/06/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/single-number
 */
public class SingleNumber {
    public int singleNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result ^= nums[i];
        }

        return result;
    }
}
