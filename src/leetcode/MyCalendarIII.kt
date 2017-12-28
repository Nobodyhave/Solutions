package leetcode

import java.util.*

/**
 * Created by Aleksandr on 15/12/2017.
 * Project Solutions
 *
 * https://leetcode.com/problems/my-calendar-iii
 */
class MyCalendarIII {
    private val times = TreeMap<Int, Int>()
    fun book(s: Int, e: Int): Int {
        times.put(s, times.getOrDefault(s, 0) + 1)
        times.put(e, times.getOrDefault(e, 0) - 1)
        var ongoing = 0
        var k = 0
        for (v in times.values) {
            ongoing += v
            k = Math.max(k, ongoing)
        }

        return k
    }
}
