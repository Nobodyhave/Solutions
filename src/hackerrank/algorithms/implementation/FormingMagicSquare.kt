package hackerrank.algorithms.implementation

import java.util.*

/**
 * Created by Aleksandr on 27/02/2018.
 * Project Solutions
 *
 * https://www.hackerrank.com/challenges/magic-square-forming
 */

fun main(args: Array<String>) {
    val input = Scanner(System.`in`)
    //val input = Scanner(FileInputStream("C:\\Projects\\Solutions\\src\\tests.txt"))

    val matrix = IntArray(9, { input.nextInt() })

    val possibleSquares = arrayOf(
            intArrayOf(8, 1, 6, 3, 5, 7, 4, 9, 2),
            intArrayOf(6, 1, 8, 7, 5, 3, 2, 9, 4),
            intArrayOf(4, 9, 2, 3, 5, 7, 8, 1, 6),
            intArrayOf(2, 9, 4, 7, 5, 3, 6, 1, 8),
            intArrayOf(8, 3, 4, 1, 5, 9, 6, 7, 2),
            intArrayOf(4, 3, 8, 9, 5, 1, 2, 7, 6),
            intArrayOf(6, 7, 2, 1, 5, 9, 8, 3, 4),
            intArrayOf(2, 7, 6, 9, 5, 1, 4, 3, 8)
    )

    val result = possibleSquares
            .map { square ->
                square
                        .zip(matrix)
                        .map { Math.abs(it.first - it.second) }
                        .sum()
            }
            .min()

    System.out.println(result)
}
