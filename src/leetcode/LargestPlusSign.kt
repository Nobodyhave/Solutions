package leetcode

/**
 * Created by Aleksandr on 23/02/2018.
 * Project Solutions
 *
 * https://leetcode.com/problems/largest-plus-sign
 */
class LargestPlusSign {
    fun orderOfLargestPlusSign(N: Int, mines: Array<IntArray>): Int {
        val board = Array(N, { IntArray(N, { 1 }) })

        mines.forEach { board[it[0]][it[1]] = 0 }

        var result = 0
        for (i in 0 until N) {
            for (j in 0 until N) {
                result = Math.max(result, calculateOrder(i, j, N, board))
            }
        }

        return result
    }

    private fun calculateOrder(row: Int, col: Int, N: Int, board: Array<IntArray>): Int {
        var left = col
        var right = col
        var up = row
        var down = row

        var order = 0
        while (left >= 0 && right < N && up >= 0 && down < N) {
            if (board[row][left] != 0 && board[row][right] != 0 && board[up][col] != 0 && board[down][col] != 0) {
                order++
                left--
                right++
                up--
                down++
            } else {
                break
            }
        }

        return order
    }
}