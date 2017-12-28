package leetcode

/**
 * Created by Aleksandr on 20/12/2017.
 * Project Solutions
 *
 * https://leetcode.com/problems/monotone-increasing-digits
 */
class MonotoneIncreasingDigits {
    fun monotoneIncreasingDigits(N: Int): Int {
        if (N < 0) return 0
        if (N <= 9) return N

        val digits = N.toString().toCharArray()

        val isIncreasing = digits.indices.none { it != digits.size - 1 && digits[it] - '0' > digits[it + 1] - '0' }

        if (isIncreasing) return N

        var idx = digits.size
        for (i in digits.indices.reversed()) {
            if (i != 0 && digits[i] < digits[i - 1]) {
                idx = i - 1
                digits[i - 1]--
            }
        }

        for (i in idx + 1 until digits.size) {
            digits[i] = '9'
        }

        return String(digits).toInt()
    }
}