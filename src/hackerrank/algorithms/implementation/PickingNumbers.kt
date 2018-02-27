package hackerrank.algorithms.implementation

import java.util.*

/**
 * Created by Aleksandr on 26/02/2018.
 * Project Solutions
 *
 * https://www.hackerrank.com/challenges/picking-numbers
 */

fun main(args: Array<String>) {
    val input = Scanner(System.`in`)
    //val input = Scanner(FileInputStream("C:\\Projects\\Solutions\\src\\tests.txt"))

    val size = input.nextInt()
    val numbers = IntArray(size, { input.nextInt() })
    val counts = IntArray(100)

    for (i in 0 until size) {
        counts[numbers[i]]++
    }

    val max = (1 until size)
            .map { counts[it] + counts[it - 1] }
            .max()
            ?: Int.MIN_VALUE

    System.out.println(max)
}
