package leetcode;

import java.util.Arrays;

/**
 * Created by Aleksandr on 07/07/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/majority-element
 */
public class MajorityElement {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);

        return nums[nums.length / 2];
    }
}
