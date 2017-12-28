package leetcode

/**
 * Created by Aleksandr on 22/12/2017.
 * Project Solutions
 *
 * https://leetcode.com/problems/cherry-pickup
 */
class CherryPickup {
    fun cherryPickup(grid: Array<IntArray>): Int {
        val size = grid.size
        val maxLength = (size * 2) - 1
        val dp = array2dOfInt(size, size)
        dp[0][0] = grid[0][0]

        for (n in 1 until maxLength) {
            for (i in (0 until size).reversed()) {
                for (p in (0 until size).reversed()) {
                    val j = n - i
                    val q = n - p

                    if (j < 0 || j >= size || q < 0 || q >= size || grid[i][j] < 0 || grid[p][q] < 0) {
                        dp[i][p] = -1
                        continue
                    }

                    if (i > 0) dp[i][p] = Math.max(dp[i][p], dp[i - 1][p])
                    if (p > 0) dp[i][p] = Math.max(dp[i][p], dp[i][p - 1])
                    if (i > 0 && p > 0) dp[i][p] = Math.max(dp[i][p], dp[i - 1][p - 1])

                    if (dp[i][p] >= 0) dp[i][p] += grid[i][j] + (if (i != p) grid[p][q] else 0)
                }
            }
        }

        return Math.max(dp[size - 1][size - 1], 0)
    }

    private fun array2dOfInt(sizeOuter: Int, sizeInner: Int): Array<IntArray>
            = Array(sizeOuter) { IntArray(sizeInner) }
}