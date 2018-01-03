package leetcode

/**
 * Created by Aleksandr on 02/01/2018.
 * Project Solutions
 *
 * https://leetcode.com/problems/pour-water
 */
class PourWater {
    fun pourWater(heights: IntArray, V: Int, K: Int): IntArray {
        for (v in 1..V) {
            var minIndex = K
            for (i in (0 until K).reversed()) {
                if (heights[i] < heights[i + 1]) {
                    minIndex = i
                } else if (heights[i] > heights[i + 1]) {
                    break
                }
            }

            if (minIndex != K) {
                heights[minIndex]++
                continue
            }

            minIndex = K
            for (i in K + 1 until heights.size) {
                if (heights[i] < heights[i - 1]) {
                    minIndex = i
                } else if (heights[i] > heights[i - 1]) {
                    break
                }
            }

            heights[minIndex]++
        }

        return heights
    }
}