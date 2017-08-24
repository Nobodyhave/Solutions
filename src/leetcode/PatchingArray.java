package leetcode;

/**
 * Created by Aleksandr on 22/08/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/patching-array
 */
public class PatchingArray {
    public int minPatches(int[] nums, int n) {
        if (nums == null) {
            return 0;
        }

        long miss = 1;
        int patchCount = 0, i = 0;

        while (miss <= n) {
            if (i < nums.length && nums[i] <= miss) {
                miss += nums[i++];
            } else {
                miss += miss;
                patchCount++;
            }
        }

        return patchCount;
    }
}
