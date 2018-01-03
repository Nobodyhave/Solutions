package leetcode

/**
 * Created by Aleksandr on 02/01/2018.
 * Project Solutions
 *
 * https://leetcode.com/problems/reach-a-number
 */
class ReachNumber {
    fun reachNumber(t: Int): Int {
        var target = t
        target = Math.abs(target)
        var step = 0
        var sum = 0
        while (sum < target) {
            step++
            sum += step
        }
        while ((sum - target) % 2 != 0) {
            step++
            sum += step
        }
        return step
    }
}