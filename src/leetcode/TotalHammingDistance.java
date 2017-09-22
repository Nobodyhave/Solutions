package leetcode;

/**
 * Created by Aleksandr on 20/09/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/total-hamming-distance
 */
public class TotalHammingDistance {
    public int totalHammingDistance(int[] nums) {
        int result = 0;
        for (int j = 0; j < 32; j++) {
            int bitCount = 0;
            for (int num : nums) {
                bitCount += (num >> j) & 1;
            }
            result += bitCount * (nums.length - bitCount);
        }
        return result;
    }
}
