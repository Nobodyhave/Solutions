package leetcode;

/**
 * Created by Aleksandr on 15/09/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/circular-array-loop
 */
public class CircularArrayLoop {
    public boolean circularArrayLoop(int[] nums) {
        if (nums == null || nums.length < 2) {
            return false;
        }

        for (int i = 0; i < nums.length; i++) {
            int slow = i, fast = i, count = 0;
            do {
                slow = getIndex(nums, slow);
                int fast1 = getIndex(nums, fast);
                if ((nums[i] > 0 && nums[fast1] < 0) || (nums[i] < 0 && nums[fast1] > 0)) {
                    break;
                }
                fast = getIndex(nums, fast1);
                if ((nums[i] > 0 && nums[fast] < 0) || (nums[i] < 0 && nums[fast] > 0)) {
                    break;
                }
                if (fast1 == fast) {
                    break;
                }
                if (slow == fast) {
                    return true;
                }
                count++;
            } while (count < nums.length);
        }

        return false;
    }

    private int getIndex(int[] nums, int i) {
        int index = i + nums[i];
        if (index < 0) {
            index += (-index / nums.length + 1) * nums.length;
        }

        return index % nums.length;
    }
}
