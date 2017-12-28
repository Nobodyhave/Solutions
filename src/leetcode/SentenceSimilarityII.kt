package leetcode

import java.util.*

/**
 * Created by Aleksandr on 19/12/2017.
 * Project Solutions
 *
 * https://leetcode.com/problems/sentence-similarity-ii
 *
 * Not checked as it suddenly became closed
 */
class SentenceSimilarityII {
    fun areSentencesSimilarTwo(words1: Array<String>, words2: Array<String>, pairs: Array<Array<String>>): Boolean {
        val uf = UnionFind(1000)

        if (words1.size != words2.size) return false

        pairs.forEach { uf.union(it[0], it[1]) }

        words1.zip(words2).forEach {
            if (!uf.connected(it.first, it.second)) return false
        }

        return true
    }

    private class UnionFind(private var count: Int) {
        private val map = HashMap<String, Int>()
        private val parents: IntArray = IntArray(count)
        private val size: IntArray = IntArray(count)
        private var index = 0

        init {
            for (i in 0 until count) {
                parents[i] = i
                size[i] = 1
            }
        }

        private fun find(parent: String): Int {
            var p = map[parent] as Int
            while (p != parents[p]) {
                p = parents[p]
            }

            return p
        }

        fun connected(p: String, q: String): Boolean {
            return if (map[p] == null || map[q] == null) {
                false
            } else {
                find(p) == find(q)
            }
        }

        fun union(p: String, q: String) {
            if (map[p] == null) map[p] = index++
            if (map[q] == null) map[q] = index++

            val rootP = find(p)
            val rootQ = find(q)
            if (rootP == rootQ) return

            if (size[rootP] < size[rootQ]) {
                parents[rootP] = rootQ
                size[rootQ] += size[rootP]
            } else {
                parents[rootQ] = rootP
                size[rootP] += size[rootQ]
            }
        }
    }
}
