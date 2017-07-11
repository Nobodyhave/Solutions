package leetcode;

/**
 * Created by Aleksandr on 07/07/2017.
 * Project Solutions
 *
 * https://leetcode.com/problems/maximum-gap
 */
public class MaximumGap {
    public int maximumGap(int[] nums) {
        if(nums == null || nums.length < 2) {
            return 0;
        }

        nums = sort(nums, 0xFF, 0);
        nums = sort(nums, 0xFF00, 8);
        nums = sort(nums, 0xFF0000, 16);
        nums = sort(nums, 0xFF000000, 24);

        int maxGap = 0;
        for(int i = 1; i < nums.length; i++) {
            maxGap = Math.max(maxGap, nums[i] - nums[i-1]);
        }

        return maxGap;
    }

    private static int[] sort(int[] nums, int mask, int shift) {
        final int[] counts = new int[256 + 1];

        for(int i = 0; i < nums.length; i++) {
            counts[((nums[i] & mask) >>> shift) + 1]++;
        }

        for(int i = 0; i < counts.length-1; i++) {
            counts[i+1] += counts[i];
        }

        final int[] aux = new int[nums.length];

        for(int i = 0; i < nums.length; i++) {
            aux[counts[(nums[i] & mask) >>> shift]++] = nums[i];
        }

        return aux;
    }
}
