package leetcode

/**
 * Created by Aleksandr on 27/12/2017.
 * Project Solutions
 *
 * https://leetcode.com/problems/largest-number-at-least-twice-of-others
 */
class LargestNumberAtLeastTwiceOfOthers {
    fun dominantIndex(nums: IntArray): Int {
        val max = nums.max() ?: 0

        return if (nums.filter { it != max }.none { it * 2 > max }) {
            nums.withIndex().indexOfFirst { it.value == max }
        } else {
            -1
        }
    }
}