package leetcode

import java.util.*

/**
 * Created by Aleksandr on 27/02/2018.
 * Project Solutions
 *
 * https://leetcode.com/problems/reorganize-string
 */
class ReorganizeString {
    fun reorganizeString(S: String): String {
        if (S.isEmpty()) {
            return ""
        } else if (S.length == 1) {
            return S
        }

        val pq = PriorityQueue<MutableList<Char>>(kotlin.Comparator { list1, list2 -> list2.size.compareTo(list1.size) })
        S.asSequence().groupBy { it }.forEach { pq.add(it.value.toMutableList()) }

        val sb = StringBuilder()
        while (!pq.isEmpty()) {
            if (pq.size == 1 && pq.peek().size != 1) {
                return ""
            } else if (pq.size == 1 && pq.peek().size == 1) {
                val list = pq.poll()
                sb.append(list[0])
            } else {
                val list1 = pq.poll()
                sb.append(list1[0])
                list1.removeAt(list1.lastIndex)
                val list2 = pq.poll()
                sb.append(list2[0])
                list2.removeAt(list2.lastIndex)

                if (list1.isNotEmpty()) {
                    pq.add(list1)
                }
                if (list2.isNotEmpty()) {
                    pq.add(list2)
                }
            }
        }

        return sb.toString()
    }
}