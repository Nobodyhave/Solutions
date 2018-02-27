package leetcode

/**
 * Created by Aleksandr on 27/02/2018.
 * Project Solutions
 *
 * https://leetcode.com/problems/toeplitz-matrix
 */
class ToeplitzMatrix {
    fun isToeplitzMatrix(matrix: Array<IntArray>): Boolean {
        return (0 until matrix.size)
                .all { row ->
                    var r = row
                    var c = 0
                    val num = matrix[r][c]
                    while (r < matrix.size && c < matrix[0].size) {
                        if (matrix[r][c] != num) {
                            return@all false
                        }
                        r++
                        c++
                    }
                    return@all true
                } &&
                (0 until matrix[0].size).all { col ->
                    var r = 0
                    var c = col
                    val num = matrix[r][c]
                    while (r < matrix.size && c < matrix[0].size) {
                        if (matrix[r][c] != num) {
                            return@all false
                        }
                        r++
                        c++
                    }
                    return@all true
                }
    }
}