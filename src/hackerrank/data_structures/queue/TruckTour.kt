package hackerrank.data_structures.queue

import java.util.*

/**
 * Created by Aleksandr on 03/01/2018.
 * Project Solutions
 *
 * https://www.hackerrank.com/challenges/truck-tour
 */
class TruckTour {
    fun main(args: Array<String>) {
        val input = Scanner(System.`in`)

        val size = input.nextInt()
        val fuel = IntArray(size)
        val distance = IntArray(size)
        for (i in 0 until size) {
            fuel[i] = input.nextInt()
            distance[i] = input.nextInt()
        }

        var start = 0
        while (start < size) {
            var curFuel = 0
            for (i in start until start + size) {
                val pump = i % size
                curFuel += fuel[pump]
                curFuel -= distance[pump]

                if (curFuel < 0) {
                    start = i + 1
                    break
                }
            }

            if (curFuel >= 0) {
                System.out.println(start)
                return
            }
        }
    }
}