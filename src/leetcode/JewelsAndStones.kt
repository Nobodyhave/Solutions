package leetcode

/**
 * Created by Aleksandr on 27/02/2018.
 * Project Solutions
 *
 * https://leetcode.com/problems/jewels-and-stones
 */
class JewelsAndStones {
    fun numJewelsInStones(J: String, S: String): Int {
        val jewels = J.toHashSet()

        return S.filter { jewels.contains(it) }.count()
    }
}