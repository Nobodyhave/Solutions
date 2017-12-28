package leetcode

/**
 * Created by Aleksandr on 21/12/2017.
 * Project Solutions
 *
 * https://leetcode.com/problems/delete-and-earn
 */
class DeleteAndEarn {
    fun deleteAndEarn(nums: IntArray): Int {
        val counts = IntArray(10001)
        nums
                .groupBy({ it })
                .mapValues { it.value.size }
                .forEach { counts[it.key] = it.value }

        val dp = IntArray(10001)

        dp[1] = counts[1]
        var result = Int.MIN_VALUE
        for (i in 2 until dp.size) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + counts[i] * i)
            result = Math.max(result, dp[i])
        }

        return result
    }
}