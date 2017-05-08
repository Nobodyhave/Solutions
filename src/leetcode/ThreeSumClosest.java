package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Aleksandr on 08/05/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/3sum-closest
 */
public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 3) {
            return 0;
        }

        Arrays.sort(nums);

        List<Integer> distinct = new ArrayList<>();
        distinct.add(nums[0]);
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                count++;
            } else {
                count = 1;
            }
            if (count <= 3) {
                distinct.add(nums[i]);
            }
        }

        nums = new int[distinct.size()];
        for (int i = 0; i < distinct.size(); i++) {
            nums[i] = distinct.get(i);
        }

        int diff = Integer.MAX_VALUE;
        int result = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            int start = i + 1;
            int end = nums.length - 1;
            int a = nums[i];
            while (start < end) {
                int candidate = a + nums[start] + nums[end];
                if (Math.abs(candidate - target) < diff) {
                    diff = Math.abs(candidate - target);
                    result = candidate;
                }
                if (candidate - target < 0) {
                    start++;
                } else if (candidate - target > 0) {
                    end--;
                } else {
                    return target;
                }
            }
        }

        return result;
    }
}
