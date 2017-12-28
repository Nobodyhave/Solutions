package leetcode


/**
 * Created by Aleksandr on 22/12/2017.
 * Project Solutions
 *
 * https://leetcode.com/problems/network-delay-time
 */
class NetworkDelayTime {
    fun networkDelayTime(times: Array<IntArray>, N: Int, K: Int): Int {
        val graph = EdgeWeightedDigraph(N + 1)

        for (edge in times) {
            graph.addEdge(DirectedEdge(edge[0], edge[1], edge[2]))
        }

        val paths = DijkstraSP(graph, K)

        return if (paths.distTo.drop(1).any({ it == Int.MAX_VALUE })) {
            -1
        } else {
            paths.distTo.drop(1).max() ?: 0
        }
    }

    inner class DijkstraSP(G: EdgeWeightedDigraph, s: Int) {
        val distTo = IntArray(G.size(), { if (it == s) 0 else Int.MAX_VALUE })
        private val edgeTo: Array<DirectedEdge?> = arrayOfNulls(G.size())
        private val pq: IndexMinPQ<Int> = IndexMinPQ(G.size())

        init {
            pq.insert(s, distTo[s])
            while (!pq.isEmpty()) {
                val v = pq.delMin()
                for (e in G.adj(v))
                    relax(e)
            }
        }

        private fun relax(e: DirectedEdge) {
            val v = e.from()
            val w = e.to()
            if (distTo[w] > distTo[v] + e.weight()) {
                distTo[w] = distTo[v] + e.weight()
                edgeTo[w] = e
                if (pq.contains(w))
                    pq.decreaseKey(w, distTo[w])
                else
                    pq.insert(w, distTo[w])
            }
        }
    }

    inner class DirectedEdge(private val v: Int, private val w: Int, private val weight: Int) {
        fun from(): Int {
            return v
        }

        fun to(): Int {
            return w
        }

        fun weight(): Int {
            return weight
        }
    }

    inner class EdgeWeightedDigraph(private val V: Int) {
        private val adj = Array(V, { ArrayList<DirectedEdge>() })
        private val inDegree = IntArray(V)

        fun size(): Int {
            return V
        }

        fun addEdge(e: DirectedEdge) {
            val v = e.from()
            val w = e.to()
            adj[v].add(e)
            inDegree[w]++
        }

        fun adj(v: Int): Iterable<DirectedEdge> {
            return adj[v]
        }
    }

    inner class IndexMinPQ<in Key : Comparable<Key>>(maxN: Int) {
        private var N: Int = 0
        private val pq = IntArray(maxN + 1)
        private val qp = IntArray(maxN + 1, { -1 })
        private val keys = arrayOfNulls<Comparable<Key>>(maxN + 1) as Array<Key>

        fun isEmpty(): Boolean {
            return N == 0
        }

        operator fun contains(i: Int): Boolean {
            return qp[i] != -1
        }

        fun size(): Int {
            return N
        }

        fun insert(i: Int, key: Key) {
            N++
            qp[i] = N
            pq[N] = i
            keys[i] = key
            swim(N)
        }

        fun delMin(): Int {
            val min = pq[1]
            exchange(1, N--)
            sink(1)
            assert(min == pq[N + 1])
            qp[min] = -1        // delete
            pq[N + 1] = -1        // not needed
            return min
        }

        fun decreaseKey(i: Int, key: Key) {
            keys[i] = key
            swim(qp[i])
        }

        private fun greater(i: Int, j: Int): Boolean {
            return keys[pq[i]] > keys[pq[j]]
        }

        private fun exchange(i: Int, j: Int) {
            val swap = pq[i]
            pq[i] = pq[j]
            pq[j] = swap
            qp[pq[i]] = i
            qp[pq[j]] = j
        }

        private fun swim(num: Int) {
            var k = num
            while (k > 1 && greater(k / 2, k)) {
                exchange(k, k / 2)
                k /= 2
            }
        }

        private fun sink(num: Int) {
            var k = num
            while (2 * k <= N) {
                var j = 2 * k
                if (j < N && greater(j, j + 1)) j++
                if (!greater(k, j)) break
                exchange(k, j)
                k = j
            }
        }
    }
}