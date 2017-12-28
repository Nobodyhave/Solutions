package leetcode

/**
 * Created by Aleksandr on 27/12/2017.
 * Project Solutions
 *
 * https://leetcode.com/problems/min-cost-climbing-stairs
 */
class MinCostClimbingStairs {
    fun minCostClimbingStairs(cost: IntArray): Int {
        var step1 = 0
        var step2 = 0

        cost.forEach {
            val min = Math.min(step1, step2) + it
            step2 = step1
            step1 = min
        }

        return Math.min(step2, step1)
    }
}