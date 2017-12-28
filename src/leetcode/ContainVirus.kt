package leetcode

/**
 * Created by Aleksandr on 28/12/2017.
 * Project Solutions
 *
 * https://leetcode.com/problems/contain-virus
 */
class ContainVirus {
    fun containVirus(grid: Array<IntArray>): Int {
        val rows = grid.size
        val cols = grid[0].size
        val isolated = Array(rows, { BooleanArray(cols) })
        var walls = 0

        var expanded: Boolean
        do {
            val graph = buildGraph(grid, isolated)
            val dangerous = findMostDangerousRegion(graph, grid, isolated)
            walls += buildWalls(grid, isolated, dangerous)
            expanded = expandVirus(grid, isolated)
        } while (expanded)

        return walls
    }

    private fun buildGraph(grid: Array<IntArray>, isolated: Array<BooleanArray>): Graph {
        val rows = grid.size
        val cols = grid[0].size
        val graph = Graph(rows * cols)
        for (i in grid.indices) {
            for (j in grid[i].indices) {
                if (i + 1 < rows && grid[i][j] == grid[i + 1][j] && !isolated[i][j] && !isolated[i + 1][j]) {
                    graph.addEdge(idx(cols, i, j), idx(cols, i + 1, j))
                }
                if (j + 1 < cols && grid[i][j] == grid[i][j + 1] && !isolated[i][j] && !isolated[i][j + 1]) {
                    graph.addEdge(idx(cols, i, j), idx(cols, i, j + 1))
                }
            }
        }

        return graph
    }

    private fun findMostDangerousRegion(graph: Graph, grid: Array<IntArray>, isolated: Array<BooleanArray>): Set<Int> {
        val cols = grid[0].size
        val regions = ConnectedComponents(graph).regions()
        var maxAffected = Integer.MIN_VALUE
        var maxAffectedId = -1
        for (region in regions) {
            if (region.value.isNotEmpty()) {
                val (row, col) = idxToRowCol(cols, region.value.first())
                if (isolated[row][col] || grid[row][col] == 0) continue

                val affected = calculateAffectedCells(grid, region.value)
                if (affected > maxAffected) {
                    maxAffected = affected
                    maxAffectedId = region.key
                }
            }
        }

        return regions[maxAffectedId] ?: HashSet()
    }

    private fun calculateAffectedCells(grid: Array<IntArray>, region: Set<Int>): Int {
        val rows = grid.size
        val cols = grid[0].size
        val affected = HashSet<Int>()
        for (idx in region) {
            val (row, col) = idxToRowCol(cols, idx)
            if (row + 1 < rows && grid[row + 1][col] == 0) {
                affected.add(idx(cols, row + 1, col))
            }
            if (row - 1 >= 0 && grid[row - 1][col] == 0) {
                affected.add(idx(cols, row - 1, col))
            }
            if (col + 1 < cols && grid[row][col + 1] == 0) {
                affected.add(idx(cols, row, col + 1))
            }
            if (col - 1 >= 0 && grid[row][col - 1] == 0) {
                affected.add(idx(cols, row, col - 1))
            }
        }

        return affected.size
    }

    private fun buildWalls(grid: Array<IntArray>, isolated: Array<BooleanArray>, dangerous: Set<Int>): Int {
        val rows = grid.size
        val cols = grid[0].size
        var affected = 0
        for (idx in dangerous) {
            val (row, col) = idxToRowCol(cols, idx)

            isolated[row][col] = true

            if (row + 1 < rows && grid[row + 1][col] == 0) {
                affected++
            }
            if (row - 1 >= 0 && grid[row - 1][col] == 0) {
                affected++
            }
            if (col + 1 < cols && grid[row][col + 1] == 0) {
                affected++
            }
            if (col - 1 >= 0 && grid[row][col - 1] == 0) {
                affected++
            }
        }

        return affected
    }

    private fun expandVirus(grid: Array<IntArray>, isolated: Array<BooleanArray>): Boolean {
        val rows = grid.size
        val cols = grid[0].size
        var expanded = false

        val newGrid = grid.copy()

        for (row in grid.indices) {
            for (col in grid[row].indices) {
                if (grid[row][col] == 0 || isolated[row][col]) continue

                if (row + 1 < rows && grid[row + 1][col] == 0) {
                    newGrid[row + 1][col] = 1
                    expanded = true
                }
                if (row - 1 >= 0 && grid[row - 1][col] == 0) {
                    newGrid[row - 1][col] = 1
                    expanded = true
                }
                if (col + 1 < cols && grid[row][col + 1] == 0) {
                    newGrid[row][col + 1] = 1
                    expanded = true
                }
                if (col - 1 >= 0 && grid[row][col - 1] == 0) {
                    newGrid[row][col - 1] = 1
                    expanded = true
                }
            }
        }

        for (row in grid.indices) {
            for (col in grid[row].indices) {
                grid[row][col] = newGrid[row][col]
            }
        }

        return expanded
    }

    private fun idx(cols: Int, i: Int, j: Int): Int {
        return i * cols + j
    }

    private fun idxToRowCol(cols: Int, idx: Int): Pair<Int, Int> {
        return Pair(idx / cols, idx % cols)
    }

    private fun Array<IntArray>.copy() = Array(size) { get(it).clone() }

    class Graph(private val V: Int) {
        private var edgeCount: Int = 0
        private val adj = Array(V, { ArrayList<Int>() })

        fun vertexCount(): Int {
            return V
        }

        fun addEdge(v: Int, w: Int) {
            edgeCount++
            adj[v].add(w)
            adj[w].add(v)
        }

        fun adj(v: Int): Iterable<Int> {
            return adj[v]
        }
    }

    class ConnectedComponents(G: Graph) {
        private val marked = BooleanArray(G.vertexCount())
        private val id = IntArray(G.vertexCount())
        private val size = IntArray(G.vertexCount())
        private var count: Int = 0

        init {
            for (v in 0 until G.vertexCount()) {
                if (!marked[v]) {
                    dfs(G, v)
                    count++
                }
            }
        }

        private fun dfs(G: Graph, v: Int) {
            marked[v] = true
            id[v] = count
            size[count]++
            G.adj(v).filter { w -> !marked[w] }.forEach { w -> dfs(G, w) }
        }

        fun regions(): Map<Int, Set<Int>> {
            return id.withIndex().groupBy({ it.value }, { it.index }).mapValues { HashSet(it.value) }
        }

        fun size(v: Int): Int {
            return size[id[v]]
        }
    }
}