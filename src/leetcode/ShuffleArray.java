package leetcode;

import java.util.Random;

/**
 * Created by Aleksandr on 29/08/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/shuffle-an-array
 */
public class ShuffleArray {
    private Random random;
    private int[] original;
    private int[] shuffled;

    public ShuffleArray(int[] nums) {
        random = new Random();
        original = new int[nums.length];
        System.arraycopy(nums, 0, original, 0, nums.length);
        shuffled = new int[nums.length];
        System.arraycopy(nums, 0, shuffled, 0, nums.length);
    }

    public int[] reset() {
        return original;
    }

    public int[] shuffle() {
        for (int i = shuffled.length - 1; i >= 0; i--) {
            final int rand = random.nextInt(i + 1);
            final int temp = shuffled[i];
            shuffled[i] = shuffled[rand];
            shuffled[rand] = temp;
        }

        return shuffled;
    }
}
