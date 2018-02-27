package hackerrank.algorithms.implementation

import java.util.*

/**
 * Created by Aleksandr on 26/02/2018.
 * Project Solutions
 *
 * https://www.hackerrank.com/challenges/electronics-shop
 */

fun main(args: Array<String>) {
    val input = Scanner(System.`in`)
    //val input = Scanner(FileInputStream("C:\\Projects\\Solutions\\src\\tests.txt"))

    val s = input.nextInt()
    val n = input.nextInt()
    val m = input.nextInt()

    val keyboards = IntArray(n, { input.nextInt() })
    val devices = IntArray(m, { input.nextInt() })

    var max = -1
    keyboards.forEach { keyboard ->
        devices.forEach { device ->
            if (keyboard + device <= s) {
                max = Math.max(max, keyboard + device)
            }
        }
    }

    System.out.println(max)
}
