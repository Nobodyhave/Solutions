package leetcode

import java.util.*

/**
 * Created by Aleksandr on 02/01/2018.
 * Project Solutions
 *
 * https://leetcode.com/problems/set-intersection-size-at-least-two
 */
class SetIntersectionSizeAtLeastTwo {
    fun intersectionSizeTwo(intervals: Array<IntArray>): Int {
        intervals.sortWith(Comparator { a, b -> if (Integer.compare(a[0], b[0]) == 0) Integer.compare(b[1], a[1]) else Integer.compare(a[0], b[0]) })

        val stack = ArrayDeque<IntArray>()
        for (interval in intervals) {
            while (!stack.isEmpty() && stack.peek()[1] >= interval[1]) {
                stack.pop()
            }
            stack.push(interval)
        }
        val n = stack.size
        val a = Array(n) { IntArray(2) }
        for (i in n - 1 downTo 0) {
            a[i][0] = stack.peek()[0]
            a[i][1] = stack.pop()[1]
        }

        var ans = 2
        var p1 = a[0][1] - 1
        var p2 = a[0][1]
        for (i in 1 until n) {
            val chosen1 = p1 >= a[i][0] && p1 <= a[i][1]
            val chosen2 = p2 >= a[i][0] && p2 <= a[i][1]
            if (chosen1 && chosen2) {
                continue
            } else if (chosen2) {
                p1 = p2
                p2 = a[i][1]
                ans++
            } else {
                p1 = a[i][1] - 1
                p2 = a[i][1]
                ans += 2
            }
        }
        return ans
    }
}