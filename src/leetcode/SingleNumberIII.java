package leetcode;

/**
 * Created by Aleksandr on 30/06/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/single-number-iii
 */
public class SingleNumberIII {
    public int[] singleNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[]{};
        }

        int aXorB = 0;
        for (int i = 0; i < nums.length; i++) {
            aXorB ^= nums[i];
        }
        int diffBit = Integer.lowestOneBit(aXorB);

        int A = 0, B = 0;
        for (int i = 0; i < nums.length; i++) {
            if ((diffBit & nums[i]) == 0) {
                A ^= nums[i];
            } else {
                B ^= nums[i];
            }
        }

        return new int[]{A, B};
    }
}
