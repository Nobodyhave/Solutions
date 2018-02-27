package hackerrank.data_structures.disjoint_set

import java.io.FileInputStream
import java.util.*

/**
 * Created by Aleksandr on 04/01/2018.
 * Project Solutions
 *
 * https://www.hackerrank.com/challenges/maximum-cost-queries
 */
class SuperMaximumCostQueries {
    fun main(args: Array<String>) {
        //val input = Scanner(System.`in`)
        val input = Scanner(FileInputStream("C:\\Projects\\Solutions\\src\\tests.txt"))

        val nodesCount = input.nextInt()
        val queriesCount = input.nextInt()
        val unionFind = UnionFind(nodesCount)

        var sum = 0L
        val counts = (0 until nodesCount - 1)
                .map { Edge(input.nextInt() - 1, input.nextInt() - 1, input.nextInt().toLong()) }
                .groupBy { it.w }
                .toSortedMap()
                .mapValues {
                    for (e in it.value) {
                        sum += unionFind.union(e.u, e.v)
                    }

                    sum
                }.toSortedMap() as TreeMap<Long, Long>

        for (q in 0 until queriesCount) {
            val l = input.nextInt().toLong()
            val r = input.nextInt().toLong()

            val leftCount = counts.lowerEntry(l)?.value ?: 0
            val rightCount = counts.floorEntry(r)?.value ?: 0

            System.out.println(rightCount - leftCount)
        }
    }

    data class Edge(val u: Int, val v: Int, val w: Long)

    private class UnionFind(count: Int) {
        private val parents: IntArray = IntArray(count, { it })
        val size: LongArray = LongArray(count, { 1 })

        private fun find(parent: Int): Int {
            var p = parent
            while (p != parents[p]) {
                p = parents[p]
            }

            return p
        }

        fun connected(p: Int, q: Int): Boolean {
            return find(p) == find(q)
        }

        fun union(p: Int, q: Int): Long {
            val rootP = find(p)
            val rootQ = find(q)
            if (rootP == rootQ) return 0

            var countIncrement = 0L
            if (size[rootP] < size[rootQ]) {
                parents[rootP] = rootQ
                countIncrement -= (size[rootP] * (size[rootP] - 1) / 2) + (size[rootQ] * (size[rootQ] - 1) / 2)
                val prevQ = size[rootQ]
                size[rootQ] += size[rootP]
                countIncrement += (size[rootQ] * (size[rootQ] - 1) / 2)
                size[rootP] = 0
            } else {
                parents[rootQ] = rootP
                countIncrement -= (size[rootP] * (size[rootP] - 1) / 2) + (size[rootQ] * (size[rootQ] - 1) / 2)
                size[rootP] += size[rootQ]
                countIncrement += (size[rootP] * (size[rootP] - 1) / 2)
                size[rootQ] = 0
            }

            return countIncrement
        }
    }
}