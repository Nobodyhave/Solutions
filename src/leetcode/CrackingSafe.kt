package leetcode

/**
 * Created by Aleksandr on 28/12/2017.
 * Project Solutions
 *
 * https://leetcode.com/problems/cracking-the-safe
 */
class CrackingSafe {
    fun crackSafe(n: Int, k: Int): String {
        val sb = StringBuilder()
        val total = Math.pow(k.toDouble(), n.toDouble()).toInt()
        for (i in 0 until n) {
            sb.append('0')
        }

        val passwords = HashSet<String>()
        passwords.add(sb.toString())

        dfs(sb, total, passwords, n, k)

        return sb.toString()
    }

    private fun dfs(sb: StringBuilder, goal: Int, passwords: MutableSet<String>, n: Int, k: Int): Boolean {
        if (passwords.size == goal) return true

        val prev = sb.takeLast(n - 1).toString()
        for (i in 0 until k) {
            val next = prev + i
            if (passwords.add(next)) {
                sb.append(i)
                if (dfs(sb, goal, passwords, n, k)) {
                    return true
                } else {
                    passwords.remove(next)
                    sb.delete(sb.length - 1, sb.length)
                }
            }
        }
        return false
    }
}