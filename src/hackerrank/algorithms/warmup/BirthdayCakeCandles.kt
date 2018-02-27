package hackerrank.algorithms.warmup

import java.util.*

/**
 * Created by Aleksandr on 26/02/2018.
 * Project Solutions
 *
 * https://www.hackerrank.com/challenges/birthday-cake-candles
 */
class BirthdayCakeCandles {
    fun main(args: Array<String>) {
        val input = Scanner(System.`in`)

        val size = input.nextInt()
        val candles = IntArray(size)

        for (i in 0 until size) {
            candles[i] = input.nextInt()
        }

        val blownCandles = candles.groupBy { it }.maxBy { it.key }?.value?.size

        System.out.println(blownCandles)
    }
}