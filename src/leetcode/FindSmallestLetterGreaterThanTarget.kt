package leetcode

/**
 * Created by Aleksandr on 22/12/2017.
 * Project Solutions
 *
 * https://leetcode.com/problems/find-smallest-letter-greater-than-target
 */
class FindSmallestLetterGreaterThanTarget {
    fun nextGreatestLetter(letters: CharArray, target: Char): Char {
        var lo = 0
        var hi = letters.size
        while (lo < hi) {
            val mi = lo + (hi - lo) / 2

            if (letters[mi] <= target)
                lo = mi + 1
            else
                hi = mi
        }
        return letters[lo % letters.size]
    }
}