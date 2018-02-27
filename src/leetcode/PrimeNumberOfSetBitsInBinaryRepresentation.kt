package leetcode

/**
 * Created by Aleksandr on 23/02/2018.
 * Project Solutions
 *
 * https://leetcode.com/problems/prime-number-of-set-bits-in-binary-representation
 */
class PrimeNumberOfSetBitsInBinaryRepresentation {
    fun countPrimeSetBits(L: Int, R: Int): Int {
        val primes = setOf(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31)

        return (L..R).count { primes.contains(countBits(it)) }
    }

    private fun countBits(num: Int): Int {
        var count = 0
        var n = num
        while (n != 0) {
            if ((n.and(1)) != 0) {
                count++
            }
            n = n.ushr(1)
        }

        return count
    }
}