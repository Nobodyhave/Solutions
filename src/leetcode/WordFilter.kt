package leetcode

import java.util.*

/**
 * Created by Aleksandr on 27/12/2017.
 * Project Solutions
 *
 * https://leetcode.com/problems/prefix-and-suffix-search
 */
class WordFilter(words: Array<String>) {
    private val prefixMap = HashMap<String, TreeMap<Int, String>>()
    private val suffixMap = HashMap<String, HashSet<String>>()

    init {
        words.forEachIndexed { weight, word ->
            for (i in 0..word.length) {
                val prefix = word.substring(0, i)
                val suffix = word.substring(i)
                prefixMap.getOrPut(prefix, { TreeMap(Comparator { o1: Int, o2: Int -> o2.compareTo(o1) }) }).put(weight, word)
                suffixMap.getOrPut(suffix, { HashSet() }).add(word)
            }
        }
    }

    fun f(prefix: String, suffix: String): Int {
        if (prefixMap[prefix] == null || suffixMap[suffix] == null) {
            return -1
        }

        prefixMap[prefix]?.forEach {
            if (suffixMap[suffix]?.contains(it.value) == true) return it.key
        }

        return -1
    }
}