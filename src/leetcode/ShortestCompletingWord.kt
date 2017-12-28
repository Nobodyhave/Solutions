package leetcode

/**
 * Created by Aleksandr on 27/12/2017.
 * Project Solutions
 *
 * https://leetcode.com/problems/shortest-completing-word
 */
class ShortestCompletingWord {
    fun shortestCompletingWord(licensePlate: String, words: Array<String>): String {
        val licenceChars = stringToLetters(licensePlate)

        return words.filter { isComplete(licenceChars, stringToLetters(it)) }.minBy { it.length } ?: ""
    }

    private fun stringToLetters(s: String): Map<Char, Int> {
        return s.toLowerCase()
                .filter { it in 'a'..'z' }
                .groupBy { it }
                .mapValues { it.value.size }
    }

    private fun isComplete(licence: Map<Char, Int>, word: Map<Char, Int>): Boolean {
        return licence.all { word[it.key] ?: Int.MIN_VALUE >= it.value }
    }
}