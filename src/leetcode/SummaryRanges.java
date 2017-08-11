package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aleksandr on 18/07/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/summary-ranges
 */
public class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        final List<String> result = new ArrayList<>();

        if (nums == null || nums.length == 0) {
            return result;
        }

        int startIndex = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] - nums[i] != 1) {
                if (startIndex == i) {
                    result.add(String.valueOf(nums[startIndex]));
                } else {
                    result.add(String.valueOf(nums[startIndex]) + "->" + String.valueOf(nums[i]));
                }
                startIndex = i + 1;
            }
        }

        if (startIndex == nums.length - 1) {
            result.add(String.valueOf(nums[startIndex]));
        } else {
            result.add(String.valueOf(nums[startIndex]) + "->" + String.valueOf(nums[nums.length - 1]));
        }

        return result;
    }
}
