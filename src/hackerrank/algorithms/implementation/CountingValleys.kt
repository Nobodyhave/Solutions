package hackerrank.algorithms.implementation

import java.util.*

/**
 * Created by Aleksandr on 26/02/2018.
 * Project Solutions
 *
 * https://www.hackerrank.com/challenges/counting-valleys
 */

fun main(args: Array<String>) {
    val input = Scanner(System.`in`)
    //val input = Scanner(FileInputStream("C:\\Projects\\Solutions\\src\\tests.txt"))

    val size = input.nextInt()
    val path = input.next()

    var elevation = 0
    var valleys = 0
    for (i in 0 until size) {
        if (path[i] == 'D' && elevation == 0) {
            valleys++
        }

        if (path[i] == 'U') elevation++ else elevation--
    }

    System.out.println(valleys)
}
