package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aleksandr on 14/08/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/additive-number
 */
public class AdditiveNumber {
    public boolean isAdditiveNumber(String num) {
        if (num == null || num.isEmpty()) {
            return false;
        }

        return isAdditiveNumber(num, new ArrayList<>(), 0);
    }

    private boolean isAdditiveNumber(String num, List<Long> nums, int start) {
        if (start == num.length() && nums.size() > 2) {
            return true;
        }

        for (int i = start; i < num.length() && i - start < 19; i++) {
            if (num.charAt(start) == '0' && i != start) {
                break;
            }

            long number = Long.parseLong(num.substring(start, i + 1));

            if (nums.size() < 2 || nums.get(nums.size() - 1) + nums.get(nums.size() - 2) == number) {
                nums.add(number);
                if (isAdditiveNumber(num, nums, i + 1)) {
                    return true;
                }
                nums.remove(nums.size() - 1);
            }
        }

        return false;
    }
}
