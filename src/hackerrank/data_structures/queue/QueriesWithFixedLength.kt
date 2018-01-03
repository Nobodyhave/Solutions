package hackerrank.data_structures.queue

import java.io.FileInputStream
import java.util.*

/**
 * Created by Aleksandr on 03/01/2018.
 * Project Solutions
 *
 * https://www.hackerrank.com/challenges/queries-with-fixed-length
 */
class QueriesWithFixedLength {
    fun main(args: Array<String>) {
        //val input = Scanner(System.`in`)
        val input = Scanner(FileInputStream("C:\\Projects\\Solutions\\src\\tests.txt"))

        val size = input.nextInt()
        val queries = input.nextInt()
        val nums = IntArray(size)

        for (i in 0 until size) {
            nums[i] = input.nextInt()
        }

        val sparseTable = RangeMaximumQuery(nums)

        (0 until queries)
                .map { input.nextInt() }
                .forEach { d ->
                    (0..size - d)
                            .map { sparseTable.rangeMaximumQuery(it, it + d - 1) }
                            .min()
                            .let {
                                System.out.println(it)
                            }
                }
    }

    class RangeMaximumQuery(private val input: IntArray) {
        private val n: Int = input.size
        private val sparse = preProcess(input, n)

        fun rangeMaximumQuery(low: Int, high: Int): Int {
            val l = high - low + 1
            val k = log2(l)
            return if (input[sparse[low][k]] >= input[sparse[low + l - (1 shl k)][k]]) {
                input[sparse[low][k]]
            } else {
                input[sparse[high - (1 shl k) + 1][k]]
            }
        }

        private fun preProcess(input: IntArray, n: Int): Array<IntArray> {
            val sparse = Array(n) { IntArray(log2(n) + 1) }
            for (i in input.indices) {
                sparse[i][0] = i
            }

            var j = 1
            while (1 shl j <= n) {
                var i = 0
                while (i + (1 shl j) - 1 < n) {
                    if (input[sparse[i][j - 1]] > input[sparse[i + (1 shl j - 1)][j - 1]]) {
                        sparse[i][j] = sparse[i][j - 1]
                    } else {
                        sparse[i][j] = sparse[i + (1 shl j - 1)][j - 1]
                    }
                    i++
                }
                j++
            }
            return sparse
        }

        private fun log2(n: Int): Int {
            if (n <= 0) throw IllegalArgumentException()
            return 31 - Integer.numberOfLeadingZeros(n)
        }
    }
}