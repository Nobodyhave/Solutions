package leetcode;

/**
 * Created by Aleksandr on 07/07/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/two-sum-ii-input-array-is-sorted
 */
public class TwoSumII {
    public int[] twoSum(int[] numbers, int target) {
        if (numbers == null || numbers.length < 2) {
            return new int[0];
        }

        int start = 0, end = numbers.length - 1;
        while (start < end) {
            if (numbers[start] + numbers[end] > target) {
                end--;
            } else if (numbers[start] + numbers[end] < target) {
                start++;
            } else {
                return new int[]{start + 1, end + 1};
            }
        }

        return new int[0];
    }
}
