package leetcode

/**
 * Created by Aleksandr on 27/02/2018.
 * Project Solutions
 *
 * https://leetcode.com/problems/max-chunks-to-make-sorted
 */

class MaxChunksToMakeSorted {
    fun maxChunksToSorted(arr: IntArray): Int {
        var numToFind = 0
        var start = 0
        var chunks = 0
        while (numToFind < arr.size) {
            var numIndex = indexOfNum(arr, start, arr.size, numToFind)
            while (true) {
                val max = arr.slice(start..numIndex).max() ?: -1
                numToFind = max + 1
                if (max != numIndex) {
                    numIndex = max
                } else {
                    chunks++
                    break
                }
            }
            start = numToFind
        }

        return chunks
    }

    private fun indexOfNum(arr: IntArray, start: Int, end: Int, num: Int): Int {
        return (start until end).firstOrNull { arr[it] == num } ?: -1
    }
}
