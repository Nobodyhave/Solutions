package hackerrank.algorithms.implementation

import java.io.FileInputStream
import java.util.*

/**
 * Created by Aleksandr on 26/02/2018.
 * Project Solutions
 *
 * https://www.hackerrank.com/challenges/the-birthday-bar
 */
fun main(args: Array<String>) {
    //val input = Scanner(System.`in`)
    val input = Scanner(FileInputStream("C:\\Projects\\Solutions\\src\\tests.txt"))

    val size = input.nextInt()
    val squares = IntArray(size, { input.nextInt() })
    val day = input.nextInt()
    val month = input.nextInt()

    var sum = squares.take(month).sum()
    var result = if (sum == day) 1 else 0

    for (i in month until size) {
        sum -= squares[i - month]
        sum += squares[i]
        if (sum == day) {
            result++
        }
    }

    System.out.println(result)
}
