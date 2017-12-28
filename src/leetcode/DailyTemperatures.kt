package leetcode

import java.util.*

/**
 * Created by Aleksandr on 20/12/2017.
 * Project Solutions
 *
 * https://leetcode.com/problems/daily-temperatures
 */
class DailyTemperatures {
    fun dailyTemperatures(temperatures: IntArray): IntArray {
        val result = IntArray(temperatures.size)
        if (result.isEmpty()) return result

        val stack = ArrayDeque<Int>()
        var i = 0
        while (i < temperatures.size) {
            if (stack.isEmpty() || temperatures[i] <= temperatures[stack.peekFirst()]) {
                stack.addFirst(i++)
            } else {
                while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peekFirst()]) {
                    val idx = stack.pollFirst()
                    result[idx] = i - idx
                }
            }
        }

        while (!stack.isEmpty()) {
            val idx = stack.pollFirst()
            result[idx] = 0
        }

        return result
    }
}